package com.coinbase.exchange.api.exchange;

import java.net.http.HttpResponse;

public class CoinbaseHttpException extends RuntimeException {

    private final HttpResponse<String> response;

    public CoinbaseHttpException(HttpResponse<String> response) {
        super("Request failed with status code: " + response.statusCode() + ", body: " + response.body());
        this.response = response;
    }

    public HttpResponse<String> getResponse() {
        return response;
    }

    public String getBody() {
        return response.body();
    }
}
