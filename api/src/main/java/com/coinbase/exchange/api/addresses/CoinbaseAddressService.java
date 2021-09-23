package com.coinbase.exchange.api.addresses;

import com.coinbase.exchange.api.coinbase.Page;
import com.coinbase.exchange.api.transactions.CoinbaseTransaction;

import java.util.concurrent.CompletableFuture;

public interface CoinbaseAddressService {
    Page<CoinbaseAddress> getCoinbaseAddresses(String coinbaseAccountId, String startingAfter, String endingBefore, Integer limit, String order);
    CompletableFuture<Page<CoinbaseAddress>> getCoinbaseAddressesAsync(String coinbaseAccountId, String startingAfter, String endingBefore, Integer limit, String order);

    CoinbaseAddress getCoinbaseAddress(String coinbaseAccountId, String coinbaseAddressId);
    CompletableFuture<CoinbaseAddress> getCoinbaseAddressAsync(String coinbaseAccountId, String coinbaseAddressId);

    Page<CoinbaseTransaction> getCoinbaseAddressTransactions(String coinbaseAccountId, String coinbaseAddressId, String startingAfter, String endingBefore, Integer limit, String order);
    CompletableFuture<Page<CoinbaseTransaction>> getCoinbaseAddressTransactionsAsync(String coinbaseAccountId, String coinbaseAddressId, String startingAfter, String endingBefore, Integer limit, String order);

    CoinbaseAddress createCoinbaseAddress(String coinbaseAccountId, String name);
    CompletableFuture<CoinbaseAddress> createCoinbaseAddressAsync(String coinbaseAccountId, String name);
}
