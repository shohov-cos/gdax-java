package com.coinbase.exchange.api.addresses;

import com.coinbase.exchange.api.coinbase.CoinbaseWallet;
import com.coinbase.exchange.api.coinbase.Data;
import com.coinbase.exchange.api.coinbase.Page;
import com.coinbase.exchange.api.transactions.CoinbaseTransaction;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class CoinbaseAddressServiceImpl implements CoinbaseAddressService {

    final CoinbaseWallet wallet;

    public CoinbaseAddressServiceImpl(final CoinbaseWallet wallet) {
        this.wallet = wallet;
    }

    public static final String COINBASE_ACCOUNTS_ENDPOINT = "/v2/accounts";
    public static final String COINBASE_ADDRESSES_ENDPOINT = "/addresses";
    public static final String COINBASE_TRANSACTIONS_ENDPOINT = "/transactions";

    @Override
    public Page<CoinbaseAddress> getCoinbaseAddresses(String coinbaseAccountId, String startingAfter, String endingBefore, Integer limit, String order) {
        return wallet.pagedGet(COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + COINBASE_ADDRESSES_ENDPOINT, new TypeReference<>(){}, startingAfter, endingBefore, limit, order);
    }

    @Override
    public CompletableFuture<Page<CoinbaseAddress>> getCoinbaseAddressesAsync(String coinbaseAccountId, String startingAfter, String endingBefore, Integer limit, String order) {
        return wallet.pagedGetAsync(COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + COINBASE_ADDRESSES_ENDPOINT, new TypeReference<>(){}, startingAfter, endingBefore, limit, order);
    }

    @Override
    public CoinbaseAddress getCoinbaseAddress(String coinbaseAccountId, String coinbaseAddressId) {
        String addressEndpoint = COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + COINBASE_ADDRESSES_ENDPOINT + "/" + coinbaseAddressId;
        Data<CoinbaseAddress> data = wallet.get(addressEndpoint, new TypeReference<>(){});
        return data.getData();
    }

    @Override
    public CompletableFuture<CoinbaseAddress> getCoinbaseAddressAsync(String coinbaseAccountId, String coinbaseAddressId) {
        String addressEndpoint = COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + COINBASE_ADDRESSES_ENDPOINT + "/" + coinbaseAddressId;
        return wallet.getAsync(addressEndpoint, new TypeReference<Data<CoinbaseAddress>>(){}).thenApply(Data::getData);
    }

    @Override
    public Page<CoinbaseTransaction> getCoinbaseAddressTransactions(String coinbaseAccountId, String coinbaseAddressId, String startingAfter, String endingBefore, Integer limit, String order) {
        String addressEndpoint = COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + COINBASE_ADDRESSES_ENDPOINT + "/" + coinbaseAddressId + COINBASE_TRANSACTIONS_ENDPOINT;
        return wallet.pagedGet(addressEndpoint, new TypeReference<>(){}, startingAfter, endingBefore, limit, order);
    }
    @Override
    public CompletableFuture<Page<CoinbaseTransaction>> getCoinbaseAddressTransactionsAsync(String coinbaseAccountId, String coinbaseAddressId, String startingAfter, String endingBefore, Integer limit, String order) {
        String addressEndpoint = COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + COINBASE_ADDRESSES_ENDPOINT + "/" + coinbaseAddressId + COINBASE_TRANSACTIONS_ENDPOINT;
        return wallet.pagedGetAsync(addressEndpoint, new TypeReference<>(){}, startingAfter, endingBefore, limit, order);
    }

    @Override
    public CoinbaseAddress createCoinbaseAddress(String coinbaseAccountId, String name) {
        Map<String, String> body = prepareCreateCoinbaseAddressBody(name);
        Data<CoinbaseAddress> data = wallet.post(COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + COINBASE_ADDRESSES_ENDPOINT, new TypeReference<>(){}, body);
        return data.getData();
    }

    @Override
    public CompletableFuture<CoinbaseAddress> createCoinbaseAddressAsync(String coinbaseAccountId, String name) {
        Map<String, String> body = prepareCreateCoinbaseAddressBody(name);
        return wallet.postAsync(COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + COINBASE_ADDRESSES_ENDPOINT, new TypeReference<Data<CoinbaseAddress>>(){}, body).thenApply(Data::getData);
    }

    private Map<String, String> prepareCreateCoinbaseAddressBody(String name) {
        Map<String, String> body;
        if (name != null) {
            body = Map.of("name", name);
        } else {
            body = Collections.emptyMap();
        }
        return body;
    }
}
