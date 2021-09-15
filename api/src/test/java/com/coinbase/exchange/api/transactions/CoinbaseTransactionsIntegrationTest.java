package com.coinbase.exchange.api.transactions;

import com.coinbase.exchange.api.BaseIntegrationTest;
import com.coinbase.exchange.api.coinbase.Page;
import com.coinbase.exchange.api.coinbaseaccounts.CoinbaseAccount;
import com.coinbase.exchange.api.coinbaseaccounts.CoinbaseAccountService;
import com.coinbase.exchange.api.config.IntegrationTestConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * See class doc for BaseIntegrationTest
 */
@ExtendWith(SpringExtension.class)
@Import({IntegrationTestConfiguration.class})
class CoinbaseTransactionsIntegrationTest extends BaseIntegrationTest {

    CoinbaseAccountService coinbaseAccountService;
    CoinbaseTransactionService coinbaseTransactionService;

    @BeforeEach
    void setUp() {
        this.coinbaseAccountService = new CoinbaseAccountService(wallet);
        this.coinbaseTransactionService = new CoinbaseTransactionService(wallet);
    }

    @Test
    void canGetTransactions() {
        Page<CoinbaseAccount> coinbaseAccounts  = coinbaseAccountService.getCoinbaseAccounts(null, null, null, null);
        CoinbaseAccount coinbaseAccount = coinbaseAccounts.getData().stream().filter(ca -> ca.getCurrency().getCode().equals("BTC")).findAny().orElseThrow();
        Page<CoinbaseTransaction> coinbaseTransactions  = coinbaseTransactionService.getCoinbaseTransactions(coinbaseAccount.getId(), null, null, null, null);
        assertTrue(coinbaseTransactions.getData().size() > 0);
    }
}
