package com.coinbase.exchange.api.accounts;

import com.coinbase.exchange.api.coinbase.CoinbaseExchange;
import com.coinbase.exchange.model.Hold;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

/**
 * Created by robevansuk on 25/01/2017.
 */
public class AccountServiceImpl implements AccountService {

    final CoinbaseExchange exchange;

    public AccountServiceImpl(final CoinbaseExchange exchange) {
        this.exchange = exchange;
    }

    public static final String ACCOUNTS_ENDPOINT = "/accounts";

    @Override
    public List<Account> getAccounts(){
        return exchange.get(ACCOUNTS_ENDPOINT, new TypeReference<>(){});
    }

    @Override
    public Account getAccount(String id) {
        return exchange.get(ACCOUNTS_ENDPOINT + "/" + id, new TypeReference<>() {});
    }

    @Override
    public List<AccountHistory> getAccountHistory(String accountId) {
        String accountHistoryEndpoint = ACCOUNTS_ENDPOINT + "/" + accountId + "/ledger";
        return exchange.get(accountHistoryEndpoint, new TypeReference<>(){});
    }

    @Override
    public List<AccountHistory> getPagedAccountHistory(String accountId,
                                                       String beforeOrAfter,
                                                       Integer pageNumber,
                                                       Integer limit) {

        String accountHistoryEndpoint = ACCOUNTS_ENDPOINT + "/" + accountId + "/ledger";
        return exchange.pagedGet(accountHistoryEndpoint,
                new TypeReference<>(){},
                beforeOrAfter,
                pageNumber,
                limit);
    }

    @Override
    public List<Hold> getHolds(String accountId) {
        String holdsEndpoint = ACCOUNTS_ENDPOINT + "/" + accountId + "/holds";
        return exchange.get(holdsEndpoint, new TypeReference<>(){});
    }

    @Override
    public List<Hold> getPagedHolds(String accountId,
                                    String beforeOrAfter,
                                    Integer pageNumber,
                                    Integer limit) {
        String holdsEndpoint = ACCOUNTS_ENDPOINT + "/" + accountId + "/holds";
        return exchange.pagedGet(holdsEndpoint,
                new TypeReference<>(){},
                beforeOrAfter,
                pageNumber,
                limit);
    }

}
