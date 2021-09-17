package com.coinbase.exchange.api.currencies;

import java.util.List;

public interface CurrencyService {
    List<Currency> getCurrencies();

    Currency getCurrency(String currencyId);
}
