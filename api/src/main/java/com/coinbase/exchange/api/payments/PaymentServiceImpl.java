package com.coinbase.exchange.api.payments;

import com.coinbase.exchange.api.coinbase.CoinbaseExchange;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

/**
 * Created by robevansuk on 16/02/2017.
 */
public class PaymentServiceImpl implements PaymentService {

    private static final String PAYMENT_METHODS_ENDPOINT = "/payment-methods";
    private static final String COINBASE_ACCOUNTS_ENDPOINT = "/coinbase-accounts";

    final CoinbaseExchange coinbaseExchange;

    public PaymentServiceImpl(final CoinbaseExchange coinbaseExchange) {
        this.coinbaseExchange = coinbaseExchange;
    }

    @Override
    public List<PaymentType> getPaymentTypes() {
        return coinbaseExchange.get(PAYMENT_METHODS_ENDPOINT, new TypeReference<>(){});
    }

    @Override
    public List<CoinbaseAccount> getCoinbaseAccounts() {
        return coinbaseExchange.get(COINBASE_ACCOUNTS_ENDPOINT, new TypeReference<>() {});
    }
}