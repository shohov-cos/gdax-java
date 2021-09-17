package com.coinbase.exchange.api.orders;

import com.coinbase.exchange.api.coinbase.CoinbaseExchange;
import com.coinbase.exchange.model.Fill;
import com.coinbase.exchange.model.Hold;
import com.coinbase.exchange.model.NewOrderSingle;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Arrays;
import java.util.List;

/**
 * Created by robevansuk on 03/02/2017.
 */
public class OrderServiceImpl implements OrderService {
    public static final String ORDERS_ENDPOINT = "/orders";
    public static final String FILLS_ENDPOINT = "/fills";

    final CoinbaseExchange exchange;

    public OrderServiceImpl(final CoinbaseExchange exchange) {
        this.exchange = exchange;
    }

    @Override
    public List<Hold> getHolds(String accountId) {
        return exchange.get(ORDERS_ENDPOINT + "/" + accountId + "/holds", new TypeReference<>(){});
    }

    @Override
    public List<Order> getOpenOrders(String accountId) {
        return exchange.get(ORDERS_ENDPOINT + "/" + accountId + "/orders", new TypeReference<>(){});
    }

    @Override
    public Order getOrder(String orderId) {
        return exchange.get(ORDERS_ENDPOINT + "/" + orderId,new TypeReference<>(){});
    }

    @Override
    public Order createOrder(NewOrderSingle order) {
        return exchange.post(ORDERS_ENDPOINT, new TypeReference<>(){}, order);
    }

    @Override
    public String cancelOrder(String orderId) {
        String deleteEndpoint = ORDERS_ENDPOINT + "/" + orderId;
        return exchange.delete(deleteEndpoint, new TypeReference<>(){});
    }

    @Override
    public List<Order> getOpenOrders() {
        return exchange.get(ORDERS_ENDPOINT, new TypeReference<>(){});
    }

    @Override
    public List<Order> cancelAllOpenOrders() {
        return Arrays.asList(exchange.delete(ORDERS_ENDPOINT, new TypeReference<>(){}));
    }

    @Override
    public List<Fill> getFillsByProductId(String product_id, int resultLimit) {
        return exchange.get(FILLS_ENDPOINT + "?product_id=" + product_id + "&limit=" + resultLimit, new TypeReference<>(){});
    }
    
    @Override
    public List<Fill> getFillByOrderId(String order_id, int resultLimit) {
        return exchange.get(FILLS_ENDPOINT + "?order_id=" + order_id + "&limit=" + resultLimit, new TypeReference<>(){});
    }
}


