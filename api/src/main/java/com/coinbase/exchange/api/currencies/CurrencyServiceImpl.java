package com.coinbase.exchange.api.currencies;

import com.coinbase.exchange.api.coinbase.CoinbaseExchange;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

public class CurrencyServiceImpl implements CurrencyService {

    public static final String CURRENCIES_ENDPOINT = "/currencies";

    final CoinbaseExchange exchange;

    public CurrencyServiceImpl(final CoinbaseExchange exchange) {
        this.exchange = exchange;
    }

    // no paged products necessary
    @Override
    public List<Currency> getCurrencies() {
        return exchange.get(CURRENCIES_ENDPOINT, new TypeReference<>() { });
    }

    @Override
    public Currency getCurrency(String currencyId) {
        return exchange.get(CURRENCIES_ENDPOINT + "/" + currencyId, new TypeReference<>() {
        });
    }
}
