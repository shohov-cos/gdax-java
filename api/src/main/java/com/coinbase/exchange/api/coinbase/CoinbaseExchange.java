package com.coinbase.exchange.api.coinbase;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.concurrent.CompletableFuture;

public interface CoinbaseExchange extends CoinbaseCommon {
    <T> T pagedGet(String endpoint, TypeReference<T> typeReference, String beforeOrAfter, Integer pageNumber, Integer limit);
    <T> CompletableFuture<T> pagedGetAsync(String endpoint, TypeReference<T> typeReference, String beforeOrAfter, Integer pageNumber, Integer limit);
}
