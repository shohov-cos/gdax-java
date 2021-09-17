package com.coinbase.exchange.api.notifications;

import com.coinbase.exchange.api.BaseIntegrationTest;
import com.coinbase.exchange.api.coinbase.Page;
import com.coinbase.exchange.api.config.IntegrationTestConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * See class doc for BaseIntegrationTest
 */
@ExtendWith(SpringExtension.class)
@Import({IntegrationTestConfiguration.class})
class CoinbaseNotificationsIntegrationTest extends BaseIntegrationTest {

    CoinbaseNotificationService coinbaseNotificationService;

    @BeforeEach
    void setUp() {
        this.coinbaseNotificationService = new CoinbaseNotificationServiceImpl(wallet);
    }

    @Test
    void canGetCoinbaseNotifications() {
        Page<CoinbaseNotification> coinbaseNotifications = coinbaseNotificationService.getCoinbaseNotifications();
        assertTrue(coinbaseNotifications.getData().size() > 0);
    }

    @Test
    void canGetCoinbaseAccount() {
        Page<CoinbaseNotification> coinbaseNotifications  = coinbaseNotificationService.getCoinbaseNotifications();
        CoinbaseNotification coinbaseNotification = coinbaseNotificationService.getCoinbaseNotification(coinbaseNotifications.getData().get(0).getId());
        assertNotNull(coinbaseNotification);
        assertEquals(coinbaseNotifications.getData().get(0).getId(), coinbaseNotification.getId());
    }
}
