package com.coinbase.exchange.api.coinbaseaccounts;

import com.coinbase.exchange.api.coinbase.CoinbaseWallet;
import com.coinbase.exchange.api.coinbase.Data;
import com.coinbase.exchange.api.coinbase.Page;
import com.fasterxml.jackson.core.type.TypeReference;

public class CoinbaseAccountService {

    final CoinbaseWallet wallet;

    public CoinbaseAccountService(final CoinbaseWallet wallet) {
        this.wallet = wallet;
    }

    public static final String COINBASE_ACCOUNTS_ENDPOINT = "/v2/accounts";

    public Page<CoinbaseAccount> getCoinbaseAccounts(String startingAfter, String endingBefore, Integer limit, String order) {
        return wallet.pagedGet(COINBASE_ACCOUNTS_ENDPOINT, new TypeReference<>(){}, startingAfter, endingBefore, limit, order);
    }

    public CoinbaseAccount getCoinbaseAccount(String coinbaseAccountId) {
        String accountHistoryEndpoint = COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId;
        Data<CoinbaseAccount> data = wallet.get(accountHistoryEndpoint, new TypeReference<>(){});
        return data.getData();
    }

}
