package com.coinbase.exchange.api.useraccount;

import com.coinbase.exchange.api.coinbase.CoinbaseExchange;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

/**
 * Created by robevansuk on 17/02/2017.
 */
public class UserAccountServiceImpl implements UserAccountService {

    private static final String USER_ACCOUNT_ENDPOINT = "/users/self/trailing-volume";

    final CoinbaseExchange coinbaseExchange;

    public UserAccountServiceImpl(final CoinbaseExchange coinbaseExchange) {
        this.coinbaseExchange = coinbaseExchange;
    }

    /**
     * Returns the 30 day trailing volume information from all accounts
     * @return UserAccountData
     */
    @Override
    public List<UserAccountData> getTrailingVolume(){
        return coinbaseExchange.get(USER_ACCOUNT_ENDPOINT, new TypeReference<>() {});
    }
}
