package com.coinbase.exchange.api.addresses;

import com.coinbase.exchange.api.BaseIntegrationTest;
import com.coinbase.exchange.api.coinbase.Page;
import com.coinbase.exchange.api.coinbaseaccounts.CoinbaseAccount;
import com.coinbase.exchange.api.coinbaseaccounts.CoinbaseAccountService;
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
class AddressesIntegrationTest extends BaseIntegrationTest {

    CoinbaseAccountService coinbaseAccountService;
    AddressService addressService;

    @BeforeEach
    void setUp() {
        this.coinbaseAccountService = new CoinbaseAccountService(wallet);
        this.addressService = new AddressService(wallet);
    }

    @Test
    void canCreateGetOneAndAllAddresses() {
        Page<CoinbaseAccount> coinbaseAccounts = coinbaseAccountService.getCoinbaseAccounts(null, null, null, null);
        CoinbaseAccount coinbaseAccount = coinbaseAccounts.getData().stream().filter(ca -> ca.getCurrency().getCode().equals("BTC")).findAny().orElseThrow();
        String newName = Integer.toString(ThreadLocalRandom.current().nextInt());
        Address createdAddress = addressService.createAddress(coinbaseAccount.getId(), newName);
        assertNotNull(createdAddress);
        Address address = addressService.getAddress(coinbaseAccount.getId(), createdAddress.getId());
        assertNotNull(address);
        Page<Address> addresses = addressService.getAddresses(coinbaseAccount.getId(), null, null, null, null);
        assertTrue(addresses.getData().size() > 0);
    }

    @Test
    void canGetTransactionsOnAddress() {
        Page<CoinbaseAccount> coinbaseAccounts = coinbaseAccountService.getCoinbaseAccounts(null, null, null, null);
        CoinbaseAccount coinbaseAccount = coinbaseAccounts.getData().stream().filter(ca -> ca.getCurrency().getCode().equals("BTC")).findAny().orElseThrow();
        Page<Address> addresses = addressService.getAddresses(coinbaseAccount.getId(), null, null, null, null);
        Address address = addresses.getData().stream().findAny().orElseGet(() -> addressService.createAddress(coinbaseAccount.getId(), Integer.toString(ThreadLocalRandom.current().nextInt())));
        Page<CoinbaseTransaction> addressTransactions = addressService.getAddressTransactions(coinbaseAccount.getId(), address.getId(), null, null, null, null);
        assertNotNull(addressTransactions.getData());
    }
}
