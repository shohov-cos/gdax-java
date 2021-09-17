package com.coinbase.exchange.api.addresses;

import com.coinbase.exchange.api.coinbase.Page;
import com.coinbase.exchange.api.transactions.CoinbaseTransaction;

public interface CoinbaseAddressService {
    Page<CoinbaseAddress> getCoinbaseAddresses(String coinbaseAccountId, String startingAfter, String endingBefore, Integer limit, String order);

    CoinbaseAddress getCoinbaseAddress(String coinbaseAccountId, String coinbaseAddressId);

    Page<CoinbaseTransaction> getCoinbaseAddressTransactions(String coinbaseAccountId, String coinbaseAddressId, String startingAfter, String endingBefore, Integer limit, String order);

    CoinbaseAddress createCoinbaseAddress(String coinbaseAccountId, String name);
}
