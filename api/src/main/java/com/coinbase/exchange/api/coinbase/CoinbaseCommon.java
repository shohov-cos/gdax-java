package com.coinbase.exchange.api.coinbase;

import com.fasterxml.jackson.core.type.TypeReference;

public interface CoinbaseCommon {

    String getBaseUrl();
    String[] securityHeaders(String endpoint, String method, String body);
    <T> T get(String endpoint, TypeReference<T> typeReference);
    <T, R> T post(String endpoint, TypeReference<T> typeReference, R jsonObject);
    <T, R> T put(String endpoint, TypeReference<T> typeReference, R jsonObject);
    <T> T delete(String endpoint, TypeReference<T> typeReference);
}
