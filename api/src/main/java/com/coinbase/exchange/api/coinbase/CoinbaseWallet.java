package com.coinbase.exchange.api.coinbase;

import com.fasterxml.jackson.core.type.TypeReference;

public interface CoinbaseWallet extends CoinbaseCommon {
    <T> Page<T> pagedGet(String endpoint, TypeReference<Page<T>> typeReference, String startingAfter, String endingBefore, Integer limit, String order);
}
