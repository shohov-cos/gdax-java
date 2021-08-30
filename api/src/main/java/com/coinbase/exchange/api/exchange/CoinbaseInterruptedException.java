package com.coinbase.exchange.api.exchange;

public class CoinbaseInterruptedException extends RuntimeException {

    public CoinbaseInterruptedException(InterruptedException cause) {
        super(cause);
    }
}
