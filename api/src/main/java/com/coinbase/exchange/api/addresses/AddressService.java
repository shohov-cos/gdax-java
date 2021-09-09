package com.coinbase.exchange.api.addresses;

import com.coinbase.exchange.api.coinbase.CoinbaseWallet;
import com.coinbase.exchange.api.coinbase.Data;
import com.coinbase.exchange.api.coinbase.Page;
import com.coinbase.exchange.api.transactions.CoinbaseTransaction;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Collections;
import java.util.Map;

public class AddressService {

    final CoinbaseWallet wallet;

    public AddressService(final CoinbaseWallet wallet) {
        this.wallet = wallet;
    }

    public static final String COINBASE_ACCOUNTS_ENDPOINT = "/v2/accounts";
    public static final String COINBASE_ADDRESSES_ENDPOINT = "/addresses";
    public static final String COINBASE_TRANSACTIONS_ENDPOINT = "/transactions";

    public Page<Address> getAddresses(String coinbaseAccountId, String startingAfter, String endingBefore, Integer limit, String order) {
        return wallet.pagedGet(COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + COINBASE_ADDRESSES_ENDPOINT, new TypeReference<>(){}, startingAfter, endingBefore, limit, order);
    }

    public Address getAddress(String coinbaseAccountId, String coinbaseAddressId) {
        String addressEndpoint = COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + COINBASE_ADDRESSES_ENDPOINT + "/" + coinbaseAddressId;
        Data<Address> data = wallet.get(addressEndpoint, new TypeReference<>(){});
        return data.getData();
    }

    public Page<CoinbaseTransaction> getAddressTransactions(String coinbaseAccountId, String coinbaseAddressId, String startingAfter, String endingBefore, Integer limit, String order) {
        String addressEndpoint = COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + COINBASE_ADDRESSES_ENDPOINT + "/" + coinbaseAddressId + COINBASE_TRANSACTIONS_ENDPOINT;
        return wallet.pagedGet(addressEndpoint, new TypeReference<>(){}, startingAfter, endingBefore, limit, order);
    }

    public Address createAddress(String coinbaseAccountId, String name) {
        Map<String, String> body;
        if (name != null) {
            body = Map.of("name", name);
        } else {
            body = Collections.emptyMap();
        }
        Data<Address> data = wallet.post(COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + COINBASE_ADDRESSES_ENDPOINT, new TypeReference<>(){}, body);
        return data.getData();
    }
}
