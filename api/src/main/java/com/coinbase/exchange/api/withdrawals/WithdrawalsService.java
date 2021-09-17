package com.coinbase.exchange.api.withdrawals;

import com.coinbase.exchange.model.PaymentResponse;

import java.math.BigDecimal;

public interface WithdrawalsService {
    PaymentResponse makeWithdrawalToPaymentMethod(BigDecimal amount, String currency, String paymentMethodId);

    // TODO untested - needs coinbase account ID to work.
    PaymentResponse makeWithdrawalToCoinbase(BigDecimal amount, String currency, String coinbaseAccountId);

    // TODO untested - needs a crypto currency account address
    PaymentResponse makeWithdrawalToCryptoAccount(BigDecimal amount, String currency, String cryptoAccountAddress);
}
