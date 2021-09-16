package com.coinbase.exchange.api.coinbase;

public class CoinbaseException extends RuntimeException {

    public CoinbaseException(Throwable cause) {
        super(cause);
    }

    public CoinbaseException(String message) {
        super(message);
    }

    public CoinbaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
