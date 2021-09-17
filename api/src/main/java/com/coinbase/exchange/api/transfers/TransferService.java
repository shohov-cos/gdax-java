package com.coinbase.exchange.api.transfers;

import java.math.BigDecimal;

public interface TransferService {
    String transfer(String type, BigDecimal amount, String coinbaseAccountId);
}
