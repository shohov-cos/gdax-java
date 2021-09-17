package com.coinbase.exchange.api.time;

import com.coinbase.exchange.api.BaseIntegrationTest;
import com.coinbase.exchange.api.coinbase.CoinbaseCommonImpl;
import com.coinbase.exchange.api.config.IntegrationTestConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * See class doc for BaseIntegrationTest
 */
@ExtendWith(SpringExtension.class)
@Import({IntegrationTestConfiguration.class})
class CoinbaseTimeIntegrationTest extends BaseIntegrationTest {

    private static final Logger log = LoggerFactory.getLogger(CoinbaseCommonImpl.class.getName());

    CoinbaseTimeService coinbaseTimeService;

    @BeforeEach
    void setUp() {
        this.coinbaseTimeService = new CoinbaseTimeServiceImpl(wallet);
    }

    @Test
    void canGetCoinbaseTime() {
        long localEpochSeconds = Instant.now().getEpochSecond();
        CoinbaseTime coinbaseTime  = coinbaseTimeService.getCoinbaseTime();
        assertNotNull(coinbaseTime);
        long diff = Math.abs(localEpochSeconds - coinbaseTime.getEpoch());
        assertTrue(diff <= 30);
        log.info("Time difference: {}", diff);
    }
}
