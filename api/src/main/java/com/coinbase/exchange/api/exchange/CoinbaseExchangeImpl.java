package com.coinbase.exchange.api.exchange;

import com.coinbase.exchange.security.Signature;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;

/**
 * This class acts as a central point for providing user configuration and making GET/POST/PUT requests as well as
 * getting responses as Lists of objects rather than arrays.
 */
public class CoinbaseExchangeImpl implements CoinbaseExchange {

    static final Logger log = LoggerFactory.getLogger(CoinbaseExchangeImpl.class.getName());

    private final String publicKey;
    private final String passphrase;
    private final String baseUrl;
    private final Signature signature;
    private final ObjectMapper objectMapper;
    private final HttpClient httpClient;

    public CoinbaseExchangeImpl(final String publicKey,
                                final String passphrase,
                                final String baseUrl,
                                final Signature signature,
                                final ObjectMapper objectMapper,
                                final ExecutorService executorService) {
        this.publicKey = publicKey;
        this.passphrase = passphrase;
        this.baseUrl = baseUrl;
        this.signature = signature;
        this.objectMapper = objectMapper;
        this.httpClient = HttpClient.newBuilder().executor(executorService).build();
    }

    @Override
    public <T> T get(String resourcePath, TypeReference<T> typeReference) {
        try {
            HttpResponse<String> response = httpClient.send(HttpRequest.newBuilder()
                    .GET()
                    .uri(URI.create(getBaseUrl() + resourcePath))
                    .headers(securityHeaders(resourcePath, "GET", ""))
                    .build(), HttpResponse.BodyHandlers.ofString());
            logResponse(response);
            if (response.statusCode() < 200 || response.statusCode() > 299) {
                throw new CoinbaseHttpException(response);
            } else {
                return objectMapper.readValue(response.body(), typeReference);
            }
        } catch (IOException e) {
            throw new CoinbaseIOException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new CoinbaseInterruptedException(e);
        }
    }

    @Override
    public <T> T pagedGet(String resourcePath,
                          TypeReference<T> typeReference,
                          String beforeOrAfter,
                          Integer pageNumber,
                          Integer limit) {
        resourcePath += "?" + beforeOrAfter + "=" + pageNumber + "&limit=" + limit;
        return get(resourcePath, typeReference);
    }

    @Override
    public <T> T delete(String resourcePath, TypeReference<T> typeReference) {
        try {
            HttpResponse<String> response = httpClient.send(HttpRequest.newBuilder()
                    .DELETE()
                    .uri(URI.create(getBaseUrl() + resourcePath))
                    .headers(securityHeaders(resourcePath, "DELETE", ""))
                    .build(), HttpResponse.BodyHandlers.ofString());
            logResponse(response);
            if (response.statusCode() < 200 || response.statusCode() > 299) {
                throw new CoinbaseHttpException(response);
            } else {
                return objectMapper.readValue(response.body(), typeReference);
            }
        } catch (IOException e) {
            throw new CoinbaseIOException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new CoinbaseInterruptedException(e);
        }
    }

    @Override
    public <T, R> T post(String resourcePath, TypeReference<T> typeReference, R jsonObj) {
        String jsonBody = toJson(jsonObj);

        try {
            HttpResponse<String> response = httpClient.send(HttpRequest.newBuilder()
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .uri(URI.create(getBaseUrl() + resourcePath))
                    .headers(securityHeaders(resourcePath, "POST", jsonBody))
                    .build(), HttpResponse.BodyHandlers.ofString());
            logResponse(response);
            if (response.statusCode() < 200 || response.statusCode() > 299) {
                throw new CoinbaseHttpException(response);
            } else {
                return objectMapper.readValue(response.body(), typeReference);
            }
        } catch (IOException e) {
            throw new CoinbaseIOException(e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new CoinbaseInterruptedException(e);
        }
    }

    @Override
    public String getBaseUrl() {
        return baseUrl;
    }

    @Override
    public String[] securityHeaders(String endpoint, String method, String jsonBody) {
        String[] headers = new String[14];

        String timestamp = Instant.now().getEpochSecond() + "";
        String resource = endpoint.replace(getBaseUrl(), "");

        headers[0] = "accept";
        headers[1] = "application/json";
        headers[2] = "content-type";
        headers[3] = "application/json";
        headers[4] = "User-Agent";
        headers[5] = "gdax-java unofficial coinbase pro api library";
        headers[6] = "CB-ACCESS-KEY";
        headers[7] = publicKey;
        headers[8] = "CB-ACCESS-SIGN";
        headers[9] = signature.generate(resource, method, jsonBody, timestamp);
        headers[10] = "CB-ACCESS-TIMESTAMP";
        headers[11] = timestamp;
        headers[12] = "CB-ACCESS-PASSPHRASE";
        headers[13] = passphrase;

        curlRequest(method, jsonBody, headers, resource);

        return headers;
    }

    /**
     * Purely here for logging an equivalent curl request for debugging
     * note that the signature is time-sensitive and has a time to live of about 1 minute after which the request
     * is no longer valid.
     */
    private void curlRequest(String method, String jsonBody, String[] headers, String resource) {
        if (log.isDebugEnabled()) {
            StringBuilder curlTest = new StringBuilder("curl ");
            for (int i = 0; i < headers.length; i += 2) {
                curlTest.append("-H '").append(headers[i]).append(":").append(headers[i + 1]).append("' ");
            }
            if (jsonBody != null && !jsonBody.equals(""))
                curlTest.append("-d '").append(jsonBody).append("' ");

            curlTest.append("-X ").append(method).append(" ").append(getBaseUrl()).append(resource);
            log.debug(curlTest.toString());
        }
    }

    private void logResponse(HttpResponse<String> response) {
        if (log.isDebugEnabled()) {
            log.debug("< {} {}", response.version(), response.statusCode());
            HttpHeaders httpHeaders = response.headers();
            for (Map.Entry<String, List<String>> headersEntry : httpHeaders.map().entrySet()) {
                String headerName = headersEntry.getKey();
                List<String> values = headersEntry.getValue();
                for (String value : values) {
                    log.debug("< {}: {}", headerName, value);
                }
            }
            log.debug(response.body());
        }
    }

    private String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("Unable to serialize", e);
            throw new RuntimeException("Unable to serialize");
        }
    }
}
