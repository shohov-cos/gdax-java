package com.coinbase.exchange.api.exchange;

import com.fasterxml.jackson.core.type.TypeReference;

public interface CoinbaseExchange {

    String getBaseUrl();
    String[] securityHeaders(String endpoint, String method, String body);
    <T> T get(String endpoint, TypeReference<T> typeReference);
    <T> T pagedGet(String endpoint, TypeReference<T> typeReference, String beforeOrAfter, Integer pageNumber, Integer limit);
    <T, R> T post(String endpoint, TypeReference<T> typeReference, R jsonObject);
    <T> T delete(String endpoint, TypeReference<T> typeReference);
}
