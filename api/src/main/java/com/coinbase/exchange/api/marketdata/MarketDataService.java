package com.coinbase.exchange.api.marketdata;

import java.util.List;

public interface MarketDataService {
    MarketData getMarketDataOrderBook(String productId, int level);

    List<Trade> getTrades(String productId);
}
