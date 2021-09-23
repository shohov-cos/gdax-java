package com.coinbase.exchange.api.coinbase;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.concurrent.CompletableFuture;

public interface CoinbaseCommon {

    String getBaseUrl();
    <T> T get(String endpoint, TypeReference<T> typeReference);
    <T> CompletableFuture<T> getAsync(String resourcePath, TypeReference<T> typeReference);
    <T, R> T post(String endpoint, TypeReference<T> typeReference, R jsonObject);
    <T, R> CompletableFuture<T> postAsync(String endpoint, TypeReference<T> typeReference, R jsonObject);
    <T, R> T put(String endpoint, TypeReference<T> typeReference, R jsonObject);
    <T, R> CompletableFuture<T> putAsync(String endpoint, TypeReference<T> typeReference, R jsonObject);
    <T> T delete(String endpoint, TypeReference<T> typeReference);
    <T> CompletableFuture<T> deleteAsync(String endpoint, TypeReference<T> typeReference);
}
