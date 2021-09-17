package com.coinbase.exchange.api.deposits;

import com.coinbase.exchange.model.PaymentResponse;

import java.math.BigDecimal;

public interface DepositService {
    PaymentResponse depositViaPaymentMethod(BigDecimal amount, String currency, String paymentMethodId);

    PaymentResponse depositViaCoinbase(BigDecimal amount, String currency, String coinbaseAccountId);
}
