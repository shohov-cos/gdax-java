package com.coinbase.exchange.api.orders;

import com.coinbase.exchange.api.exchange.CoinbaseExchange;
import com.coinbase.exchange.model.Fill;
import com.coinbase.exchange.model.Hold;
import com.coinbase.exchange.model.NewOrderSingle;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Arrays;
import java.util.List;

/**
 * Created by robevansuk on 03/02/2017.
 */
public class OrderService {
    public static final String ORDERS_ENDPOINT = "/orders";
    public static final String FILLS_ENDPOINT = "/fills";

    final CoinbaseExchange exchange;

    public OrderService(final CoinbaseExchange exchange) {
        this.exchange = exchange;
    }

    public List<Hold> getHolds(String accountId) {
        return exchange.get(ORDERS_ENDPOINT + "/" + accountId + "/holds", new TypeReference<>(){});
    }

    public List<Order> getOpenOrders(String accountId) {
        return exchange.get(ORDERS_ENDPOINT + "/" + accountId + "/orders", new TypeReference<>(){});
    }

    public Order getOrder(String orderId) {
        return exchange.get(ORDERS_ENDPOINT + "/" + orderId,new TypeReference<>(){});
    }

    public Order createOrder(NewOrderSingle order) {
        return exchange.post(ORDERS_ENDPOINT, new TypeReference<>(){}, order);
    }

    public String cancelOrder(String orderId) {
        String deleteEndpoint = ORDERS_ENDPOINT + "/" + orderId;
        return exchange.delete(deleteEndpoint, new TypeReference<>(){});
    }

    public List<Order> getOpenOrders() {
        return exchange.get(ORDERS_ENDPOINT, new TypeReference<>(){});
    }

    public List<Order> cancelAllOpenOrders() {
        return Arrays.asList(exchange.delete(ORDERS_ENDPOINT, new TypeReference<>(){}));
    }

    public List<Fill> getFillsByProductId(String product_id, int resultLimit) {
        return exchange.get(FILLS_ENDPOINT + "?product_id=" + product_id + "&limit=" + resultLimit, new TypeReference<>(){});
    }
    
    public List<Fill> getFillByOrderId(String order_id, int resultLimit) {
        return exchange.get(FILLS_ENDPOINT + "?order_id=" + order_id + "&limit=" + resultLimit, new TypeReference<>(){});
    }
}


