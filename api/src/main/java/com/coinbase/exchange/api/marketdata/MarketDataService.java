package com.coinbase.exchange.api.marketdata;

import com.coinbase.exchange.api.exchange.CoinbaseExchange;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

/**
 * Created by robevansuk on 07/02/2017.
 */
public class MarketDataService {

    final CoinbaseExchange exchange;

    public MarketDataService(final CoinbaseExchange exchange) {
        this.exchange = exchange;
    }

    public static final String PRODUCT_ENDPOINT = "/products";

    public MarketData getMarketDataOrderBook(String productId, int level) {
        String marketDataEndpoint = PRODUCT_ENDPOINT + "/" + productId + "/book";
        if(level != 1)
            marketDataEndpoint += "?level=" + level;
       return exchange.get(marketDataEndpoint, new TypeReference<>(){});
    }

    public List<Trade> getTrades(String productId) {
        String tradesEndpoint = PRODUCT_ENDPOINT + "/" + productId + "/trades";
        return exchange.get(tradesEndpoint, new TypeReference<>(){});
    }
}
