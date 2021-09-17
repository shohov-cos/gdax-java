package com.coinbase.exchange.api.payments;

import java.util.List;

public interface PaymentService {
    List<PaymentType> getPaymentTypes();

    List<CoinbaseAccount> getCoinbaseAccounts();
}
