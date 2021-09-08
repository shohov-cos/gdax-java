package com.coinbase.exchange.api.time;

import com.coinbase.exchange.api.coinbase.CoinbaseWallet;
import com.coinbase.exchange.api.coinbase.Data;
import com.fasterxml.jackson.core.type.TypeReference;

public class CoinbaseTimeService {

    final CoinbaseWallet wallet;

    public CoinbaseTimeService(final CoinbaseWallet wallet) {
        this.wallet = wallet;
    }

    public static final String TIME_ENDPOINT = "/v2/time";

    public CoinbaseTime getCoinbaseTime() {
        Data<CoinbaseTime> data = wallet.get(TIME_ENDPOINT, new TypeReference<>(){});
        return data.getData();
    }

}
