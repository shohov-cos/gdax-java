package com.coinbase.exchange.api.notifications;

import com.coinbase.exchange.api.coinbase.Page;

public interface CoinbaseNotificationService {
    Page<CoinbaseNotification> getCoinbaseNotifications();

    CoinbaseNotification getCoinbaseNotification(String coinbaseNotificationId);
}
