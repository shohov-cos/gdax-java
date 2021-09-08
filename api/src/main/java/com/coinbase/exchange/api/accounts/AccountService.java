package com.coinbase.exchange.api.accounts;

import com.coinbase.exchange.api.coinbase.CoinbaseExchange;
import com.coinbase.exchange.model.Hold;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

/**
 * Created by robevansuk on 25/01/2017.
 */
public class AccountService {

    final CoinbaseExchange exchange;

    public AccountService(final CoinbaseExchange exchange) {
        this.exchange = exchange;
    }

    public static final String ACCOUNTS_ENDPOINT = "/accounts";

    public List<Account> getAccounts(){
        return exchange.get(ACCOUNTS_ENDPOINT, new TypeReference<>(){});
    }

    public Account getAccount(String id) {
        return exchange.get(ACCOUNTS_ENDPOINT + "/" + id, new TypeReference<>() {});
    }

    public List<AccountHistory> getAccountHistory(String accountId) {
        String accountHistoryEndpoint = ACCOUNTS_ENDPOINT + "/" + accountId + "/ledger";
        return exchange.get(accountHistoryEndpoint, new TypeReference<>(){});
    }

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

    public List<Hold> getHolds(String accountId) {
        String holdsEndpoint = ACCOUNTS_ENDPOINT + "/" + accountId + "/holds";
        return exchange.get(holdsEndpoint, new TypeReference<>(){});
    }

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
