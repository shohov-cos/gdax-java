package com.coinbase.exchange.api.exchangerates;

import com.coinbase.exchange.api.coinbase.CoinbaseWallet;
import com.fasterxml.jackson.core.type.TypeReference;

public class CoinbaseExchangeRatesServiceImpl implements CoinbaseExchangeRatesService {

    public static final String COINBASE_EXCHANGE_RATES_ENDPOINT = "/v2/exchange-rates";

    private final CoinbaseWallet wallet;

    public CoinbaseExchangeRatesServiceImpl(CoinbaseWallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public CoinbaseExchangeRates getCoinbaseExchangeRates(String currency) {
        String endpoint = COINBASE_EXCHANGE_RATES_ENDPOINT;
        if (currency != null) {
            endpoint += "?currency=" + currency.toUpperCase();
        }
        return wallet.get(endpoint, new TypeReference<>() { });
    }
}
