package com.coinbase.exchange.api.transactions;

import com.coinbase.exchange.api.coinbase.CoinbaseWallet;
import com.coinbase.exchange.api.coinbase.Data;
import com.coinbase.exchange.api.coinbase.Page;
import com.fasterxml.jackson.core.type.TypeReference;

public class TransactionsService {

    final CoinbaseWallet wallet;

    public TransactionsService(final CoinbaseWallet wallet) {
        this.wallet = wallet;
    }

    public static final String COINBASE_ACCOUNTS_ENDPOINT = "/v2/accounts";
    public static final String TRANSACTIONS_ENDPOINT = "/transactions";

    public Page<CoinbaseTransaction> getCoinbaseTransactions(String coinbaseAccountId, String startingAfter, String endingBefore, Integer limit, String order) {
        return wallet.pagedGet(COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + TRANSACTIONS_ENDPOINT, new TypeReference<>(){}, startingAfter, endingBefore, limit, order);
    }

    public CoinbaseTransaction getCoinbaseTransaction(String coinbaseAccountId, String coinbaseTransactionId) {
        String coinbaseTransactionEndpoint = COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + TRANSACTIONS_ENDPOINT + "/" + coinbaseTransactionId;
        Data<CoinbaseTransaction> data = wallet.get(coinbaseTransactionEndpoint, new TypeReference<>(){});
        return data.getData();
    }

    public CoinbaseTransaction sendMoney(String coinbaseAccountId, SendMoneyRequest sendMoneyRequest) {
        Data<CoinbaseTransaction> data = wallet.post(COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + TRANSACTIONS_ENDPOINT, new TypeReference<>(){}, sendMoneyRequest);
        return data.getData();
    }

    public CoinbaseTransaction transferMoneyBetweenAccounts(String coinbaseAccountId, TransferMoneyBetweenAccountsRequest request) {
        Data<CoinbaseTransaction> data = wallet.post(COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + TRANSACTIONS_ENDPOINT, new TypeReference<>(){}, request);
        return data.getData();
    }

    public CoinbaseTransaction requestMoneyFromEmail(String coinbaseAccountId, RequestMoneyFromEmailRequest request) {
        Data<CoinbaseTransaction> data = wallet.post(COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + TRANSACTIONS_ENDPOINT, new TypeReference<>(){}, request);
        return data.getData();
    }

    public CoinbaseTransaction completeRequestMoney(String coinbaseAccountId, String coinbaseTransactionId) {
        String coinbaseTransactionEndpoint = COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + TRANSACTIONS_ENDPOINT + "/" + coinbaseTransactionId;
        Data<CoinbaseTransaction> data = wallet.get(coinbaseTransactionEndpoint, new TypeReference<>(){});
        return data.getData();
    }

    public CoinbaseTransaction resendRequestMoneyFromEmail(String coinbaseAccountId, String coinbaseTransactionId) {
        String coinbaseTransactionEndpoint = COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + TRANSACTIONS_ENDPOINT + "/" + coinbaseTransactionId;
        Data<CoinbaseTransaction> data = wallet.get(coinbaseTransactionEndpoint, new TypeReference<>(){});
        return data.getData();
    }

    public CoinbaseTransaction cancelRequestMoney(String coinbaseAccountId, String coinbaseTransactionId) {
        String coinbaseTransactionEndpoint = COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + TRANSACTIONS_ENDPOINT + "/" + coinbaseTransactionId;
        Data<CoinbaseTransaction> data = wallet.get(coinbaseTransactionEndpoint, new TypeReference<>(){});
        return data.getData();
    }
}
