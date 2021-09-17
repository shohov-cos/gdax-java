package com.coinbase.exchange.api.notifications;

import com.coinbase.exchange.api.coinbase.CoinbaseWallet;
import com.coinbase.exchange.api.coinbase.Data;
import com.coinbase.exchange.api.coinbase.Page;
import com.fasterxml.jackson.core.type.TypeReference;

public class CoinbaseNotificationService {

    public static final String COINBASE_NOTIFICATIONS_ENDPOINT = "/v2/notifications";
    final CoinbaseWallet wallet;

    public CoinbaseNotificationService(CoinbaseWallet wallet) {
        this.wallet = wallet;
    }

    public Page<CoinbaseNotification> getCoinbaseNotifications() {
        return this.wallet.get(COINBASE_NOTIFICATIONS_ENDPOINT, new TypeReference<>() { });
    }

    public CoinbaseNotification getCoinbaseNotification(String coinbaseNotificationId) {
        String coinbaseAccountEndpoint = COINBASE_NOTIFICATIONS_ENDPOINT + "/" + coinbaseNotificationId;
        Data<CoinbaseNotification> data = wallet.get(coinbaseAccountEndpoint, new TypeReference<>(){});
        return data.getData();
    }
}
