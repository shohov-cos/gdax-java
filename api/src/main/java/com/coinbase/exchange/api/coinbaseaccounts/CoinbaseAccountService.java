package com.coinbase.exchange.api.coinbaseaccounts;

import com.coinbase.exchange.api.coinbase.Page;

public interface CoinbaseAccountService {
    Page<CoinbaseAccount> getCoinbaseAccounts(String startingAfter, String endingBefore, Integer limit, String order);

    CoinbaseAccount getCoinbaseAccount(String coinbaseAccountId);

    CoinbaseAccount updateCoinbaseAccount(String coinbaseAccountId, String name);
}
