package com.coinbase.exchange.api.coinbase;

public class CoinbaseInterruptedException extends RuntimeException {

    public CoinbaseInterruptedException(InterruptedException cause) {
        super(cause);
    }
}
