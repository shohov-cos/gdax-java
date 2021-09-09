package com.coinbase.exchange.api.coinbaseaccounts;

import com.coinbase.exchange.api.BaseIntegrationTest;
import com.coinbase.exchange.api.coinbase.Page;
import com.coinbase.exchange.api.config.IntegrationTestConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

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
        assertTrue(coinbaseAccounts.getData().size() > 0);
    }

    @Test
    void canGetCoinbaseAccount() {
        Page<CoinbaseAccount> coinbaseAccounts  = coinbaseAccountService.getCoinbaseAccounts(null, null, null, null);
        CoinbaseAccount coinbaseAccount = coinbaseAccountService.getCoinbaseAccount(coinbaseAccounts.getData().get(0).getId());
        assertNotNull(coinbaseAccount);
        assertEquals(coinbaseAccounts.getData().get(0).getId(), coinbaseAccount.getId());
    }

    @Test
    void canUpdateCoinbaseAccount() {
        Page<CoinbaseAccount> coinbaseAccounts  = coinbaseAccountService.getCoinbaseAccounts(null, null, null, null);
        String newName = Integer.toString(ThreadLocalRandom.current().nextInt());
        CoinbaseAccount coinbaseAccount = coinbaseAccountService.updateCoinbaseAccount(coinbaseAccounts.getData().get(0).getId(), newName);
        assertEquals(newName, coinbaseAccount.getName());
        coinbaseAccount = coinbaseAccountService.getCoinbaseAccount(coinbaseAccounts.getData().get(0).getId());
        assertNotNull(coinbaseAccount);
        assertEquals(newName, coinbaseAccount.getName());
    }
}
