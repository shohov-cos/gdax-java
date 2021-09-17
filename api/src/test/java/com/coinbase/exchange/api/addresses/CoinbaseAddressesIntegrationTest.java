package com.coinbase.exchange.api.addresses;

import com.coinbase.exchange.api.BaseIntegrationTest;
import com.coinbase.exchange.api.coinbase.Page;
import com.coinbase.exchange.api.coinbaseaccounts.CoinbaseAccount;
import com.coinbase.exchange.api.coinbaseaccounts.CoinbaseAccountService;
import com.coinbase.exchange.api.coinbaseaccounts.CoinbaseAccountServiceImpl;
import com.coinbase.exchange.api.config.IntegrationTestConfiguration;
import com.coinbase.exchange.api.transactions.CoinbaseTransaction;
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
class CoinbaseAddressesIntegrationTest extends BaseIntegrationTest {

    CoinbaseAccountService coinbaseAccountService;
    CoinbaseAddressService coinbaseAddressService;

    @BeforeEach
    void setUp() {
        this.coinbaseAccountService = new CoinbaseAccountServiceImpl(wallet);
        this.coinbaseAddressService = new CoinbaseAddressServiceImpl(wallet);
    }

    @Test
    void canCreateGetOneAndAllAddresses() {
        Page<CoinbaseAccount> coinbaseAccounts = coinbaseAccountService.getCoinbaseAccounts(null, null, null, null);
        CoinbaseAccount coinbaseAccount = coinbaseAccounts.getData().stream().filter(ca -> ca.getCurrency().getCode().equals("BTC")).findAny().orElseThrow();
        String newName = Integer.toString(ThreadLocalRandom.current().nextInt());
        CoinbaseAddress createdCoinbaseAddress = coinbaseAddressService.createCoinbaseAddress(coinbaseAccount.getId(), newName);
        assertNotNull(createdCoinbaseAddress);
        CoinbaseAddress coinbaseAddress = coinbaseAddressService.getCoinbaseAddress(coinbaseAccount.getId(), createdCoinbaseAddress.getId());
        assertNotNull(coinbaseAddress);
        Page<CoinbaseAddress> addresses = coinbaseAddressService.getCoinbaseAddresses(coinbaseAccount.getId(), null, null, null, null);
        assertTrue(addresses.getData().size() > 0);
    }

    @Test
    void canGetTransactionsOnAddress() {
        Page<CoinbaseAccount> coinbaseAccounts = coinbaseAccountService.getCoinbaseAccounts(null, null, null, null);
        CoinbaseAccount coinbaseAccount = coinbaseAccounts.getData().stream().filter(ca -> ca.getCurrency().getCode().equals("BTC")).findAny().orElseThrow();
        Page<CoinbaseAddress> addresses = coinbaseAddressService.getCoinbaseAddresses(coinbaseAccount.getId(), null, null, null, null);
        CoinbaseAddress coinbaseAddress = addresses.getData().stream().findAny().orElseGet(() -> coinbaseAddressService.createCoinbaseAddress(coinbaseAccount.getId(), Integer.toString(ThreadLocalRandom.current().nextInt())));
        Page<CoinbaseTransaction> addressTransactions = coinbaseAddressService.getCoinbaseAddressTransactions(coinbaseAccount.getId(), coinbaseAddress.getId(), null, null, null, null);
        assertNotNull(addressTransactions.getData());
    }
}
