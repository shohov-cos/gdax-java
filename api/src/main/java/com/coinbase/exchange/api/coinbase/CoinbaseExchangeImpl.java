package com.coinbase.exchange.api.coinbase;

import com.coinbase.exchange.security.Signature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Base64;
import java.util.concurrent.ExecutorService;

import static com.coinbase.exchange.security.Signature.SignatureEncoding.BASE64;

public class CoinbaseExchangeImpl extends CoinbaseCommonImpl implements CoinbaseExchange {

    public CoinbaseExchangeImpl(String publicKey, String passphrase, String baseUrl, String secretKey,
                                ObjectMapper objectMapper, ExecutorService executorService) {
        super(publicKey, passphrase, baseUrl, new Signature(Base64.getDecoder().decode(secretKey), BASE64), null, objectMapper, executorService);
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
}
