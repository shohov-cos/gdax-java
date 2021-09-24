package com.coinbase.exchange.api.exchangerates;

import com.coinbase.exchange.api.BaseIntegrationTest;
import com.coinbase.exchange.api.config.IntegrationTestConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * See class doc for BaseIntegrationTest
 */
@ExtendWith(SpringExtension.class)
@Import({IntegrationTestConfiguration.class})
class CoinbaseExchangeRatesIntegrationTest extends BaseIntegrationTest {

    CoinbaseExchangeRatesService coinbaseExchangeRatesService;

    @BeforeEach
    void setUp() {
        this.coinbaseExchangeRatesService = new CoinbaseExchangeRatesServiceImpl(wallet);
    }

    @Test
    void canGetCoinbaseExchangeRates() {
        CoinbaseExchangeRates coinbaseExchangeRates = coinbaseExchangeRatesService.getCoinbaseExchangeRates(null);
        assertNotNull(coinbaseExchangeRates);
    }

    @Test
    void canGetCoinbaseExchangeRatesWithCurrency() {
        CoinbaseExchangeRates coinbaseExchangeRates = coinbaseExchangeRatesService.getCoinbaseExchangeRates("EUR");
        assertNotNull(coinbaseExchangeRates);
        assertNotNull(coinbaseExchangeRates.getRates());
        assertFalse(coinbaseExchangeRates.getRates().isEmpty());
    }
}
