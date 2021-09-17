package com.coinbase.exchange.api.products;

import com.coinbase.exchange.model.Candles;
import com.coinbase.exchange.model.Granularity;
import com.coinbase.exchange.model.Product;

import java.time.Instant;
import java.util.List;
import java.util.Map;

public interface ProductService {
    // no paged products necessary
    List<Product> getProducts();

    Candles getCandles(String productId);

    Candles getCandles(String productId, Map<String, String> queryParams);

    Candles getCandles(String productId, Instant startTime, Instant endTime, Granularity granularity);

    Candles getCandles(String productId, Granularity granularity);

    Candles getCandles(String productId, Instant start, Instant end);
}
