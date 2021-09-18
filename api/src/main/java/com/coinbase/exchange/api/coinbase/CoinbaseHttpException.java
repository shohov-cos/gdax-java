package com.coinbase.exchange.api.coinbase;

import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;

public class CoinbaseHttpException extends CoinbaseException {
    private final int statusCode;
    private final String body;
    private final HttpHeaders headers;
    private final HttpResponse<String> response;

    public CoinbaseHttpException(HttpResponse<String> response) {
        super("Request failed with status code: " + response.statusCode() + ", body: " + response.body());
        this.statusCode = response.statusCode();
        this.body = response.body();
        this.headers = response.headers();
        this.response = response;
    }

    /**
     * Can be used for mocking. Response will return null with this constructor
     */
    public CoinbaseHttpException(int statusCode, String body, HttpHeaders headers) {
        super("Request failed with status code: " + statusCode + ", body: " + body);
        this.statusCode = statusCode;
        this.body = body;
        this.headers = headers;
        this.response = null;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getBody() {
        return body;
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public HttpResponse<String> getResponse() {
        return response;
    }
}
