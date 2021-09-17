package com.coinbase.exchange.api.currencies;

import com.coinbase.exchange.api.BaseIntegrationTest;
import com.coinbase.exchange.api.config.IntegrationTestConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@Import({IntegrationTestConfiguration.class})
class CurrencyIntegrationTest extends BaseIntegrationTest {

    private CurrencyService currencyService;

    @BeforeEach
    void setUp() {
        this.currencyService = new CurrencyServiceImpl(exchange);
    }

    @Test
    void getCurrencies() {
        List<Currency> currencies = currencyService.getCurrencies();
        currencies.forEach(item -> System.out.println(item.getId()));
        assertTrue(currencies.size() >= 0);
    }

    @Test
    void getCurrency() {
        List<Currency> currencies = currencyService.getCurrencies();
        Currency currency = currencyService.getCurrency(currencies.get(0).getId());

        assertNotNull(currency);
    }
}
