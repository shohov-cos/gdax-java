package com.coinbase.exchange.api.orders;

import com.coinbase.exchange.model.Fill;
import com.coinbase.exchange.model.Hold;
import com.coinbase.exchange.model.NewOrderSingle;

import java.util.List;

public interface OrderService {
    List<Hold> getHolds(String accountId);

    List<Order> getOpenOrders(String accountId);

    Order getOrder(String orderId);

    Order createOrder(NewOrderSingle order);

    String cancelOrder(String orderId);

    List<Order> getOpenOrders();

    List<Order> cancelAllOpenOrders();

    List<Fill> getFillsByProductId(String product_id, int resultLimit);

    List<Fill> getFillByOrderId(String order_id, int resultLimit);
}
