package com.coinbase.exchange.api.accounts;

import com.coinbase.exchange.model.Hold;

import java.util.List;

public interface AccountService {
    List<Account> getAccounts();

    Account getAccount(String id);

    List<AccountHistory> getAccountHistory(String accountId);

    List<AccountHistory> getPagedAccountHistory(String accountId,
                                                String beforeOrAfter,
                                                Integer pageNumber,
                                                Integer limit);

    List<Hold> getHolds(String accountId);

    List<Hold> getPagedHolds(String accountId,
                             String beforeOrAfter,
                             Integer pageNumber,
                             Integer limit);
}
