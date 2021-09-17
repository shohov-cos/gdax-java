package com.coinbase.exchange.api.transactions;

import com.coinbase.exchange.api.coinbase.Page;

public interface CoinbaseTransactionService {
    Page<CoinbaseTransaction> getCoinbaseTransactions(String coinbaseAccountId, String startingAfter, String endingBefore, Integer limit, String order);

    CoinbaseTransaction getCoinbaseTransaction(String coinbaseAccountId, String coinbaseTransactionId);

    CoinbaseTransaction sendMoney(String coinbaseAccountId, SendMoneyRequest sendMoneyRequest);

    CoinbaseTransaction transferMoneyBetweenAccounts(String coinbaseAccountId, TransferMoneyBetweenAccountsRequest request);

    CoinbaseTransaction requestMoneyFromEmail(String coinbaseAccountId, RequestMoneyFromEmailRequest request);

    CoinbaseTransaction completeRequestMoney(String coinbaseAccountId, String coinbaseTransactionId);

    CoinbaseTransaction resendRequestMoneyFromEmail(String coinbaseAccountId, String coinbaseTransactionId);

    CoinbaseTransaction cancelRequestMoney(String coinbaseAccountId, String coinbaseTransactionId);
}
