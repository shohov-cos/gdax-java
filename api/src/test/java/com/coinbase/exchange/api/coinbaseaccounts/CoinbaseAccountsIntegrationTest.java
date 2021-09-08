package com.coinbase.exchange.api.coinbaseaccounts;

import com.coinbase.exchange.api.BaseIntegrationTest;
import com.coinbase.exchange.api.coinbase.Page;
import com.coinbase.exchange.api.config.IntegrationTestConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * See class doc for BaseIntegrationTest
 */
@ExtendWith(SpringExtension.class)
@Import({IntegrationTestConfiguration.class})
class CoinbaseAccountsIntegrationTest extends BaseIntegrationTest {

    CoinbaseAccountService coinbaseAccountService;

    @BeforeEach
    void setUp() {
        this.coinbaseAccountService = new CoinbaseAccountService(wallet);
    }

    @Test
    void canGetCoinbaseAccounts() {
        Page<CoinbaseAccount> coinbaseAccounts  = coinbaseAccountService.getCoinbaseAccounts(null, null, null, null);
        assertNotNull(coinbaseAccounts);
    }
}
