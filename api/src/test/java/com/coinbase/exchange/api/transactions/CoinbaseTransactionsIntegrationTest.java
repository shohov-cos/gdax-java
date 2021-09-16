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

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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
        CoinbaseAccount coinbaseAccount = coinbaseAccounts.getData().stream().filter(ca -> ca.getCurrency().getCode().equals("LINK")).findAny().orElseThrow();
        Page<CoinbaseTransaction> coinbaseTransactions  = coinbaseTransactionService.getCoinbaseTransactions(coinbaseAccount.getId(), null, null, null, null);
        assertTrue(coinbaseTransactions.getData().size() > 0);
    }

    @Test
    void canGetTransaction() {
        Page<CoinbaseAccount> coinbaseAccounts  = coinbaseAccountService.getCoinbaseAccounts(null, null, null, null);
        CoinbaseAccount coinbaseAccount = coinbaseAccounts.getData().stream().filter(ca -> ca.getCurrency().getCode().equals("LINK")).findAny().orElseThrow();
        Page<CoinbaseTransaction> coinbaseTransactions  = coinbaseTransactionService.getCoinbaseTransactions(coinbaseAccount.getId(), null, null, null, null);
        CoinbaseTransaction coinbaseTransaction = coinbaseTransactionService.getCoinbaseTransaction(coinbaseAccount.getId(), coinbaseTransactions.getData().get(0).getId());
        assertNotNull(coinbaseTransaction);
    }

    @Test
    void canSendMoney() {
        Page<CoinbaseAccount> coinbaseAccounts  = coinbaseAccountService.getCoinbaseAccounts(null, null, null, null);
        CoinbaseAccount coinbaseAccount = coinbaseAccounts.getData().stream().filter(ca -> ca.getCurrency().getCode().equals("LINK")).findAny().orElseThrow();
        BigDecimal amount = BigDecimal.valueOf(0.01);
        assertTrue(coinbaseAccount.getBalance().getAmount().compareTo(amount) >= 0);
        SendMoneyRequest sendMoneyRequest = new SendMoneyRequest();
        sendMoneyRequest.setCurrency(coinbaseAccount.getCurrency().getCode());
        sendMoneyRequest.setTo("0xd064449aB48A3615A026DA8fcF776d5c9F874ec4");
        sendMoneyRequest.setAmount(amount);
        sendMoneyRequest.setDescription("test - " + OffsetDateTime.now(ZoneOffset.UTC).toString());
        CoinbaseTransaction coinbaseTransaction = coinbaseTransactionService.sendMoney(coinbaseAccount.getId(), sendMoneyRequest);
        assertNotNull(coinbaseTransaction);
    }
}
