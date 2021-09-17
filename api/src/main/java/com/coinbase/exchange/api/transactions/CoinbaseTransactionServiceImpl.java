package com.coinbase.exchange.api.transactions;

import com.coinbase.exchange.api.coinbase.CoinbaseWallet;
import com.coinbase.exchange.api.coinbase.Data;
import com.coinbase.exchange.api.coinbase.Page;
import com.fasterxml.jackson.core.type.TypeReference;

public class CoinbaseTransactionServiceImpl implements CoinbaseTransactionService {

    final CoinbaseWallet wallet;

    public CoinbaseTransactionServiceImpl(final CoinbaseWallet wallet) {
        this.wallet = wallet;
    }

    public static final String COINBASE_ACCOUNTS_ENDPOINT = "/v2/accounts";
    public static final String TRANSACTIONS_ENDPOINT = "/transactions";
    public static final String COMPLETE_TRANSACTION_ENDPOINT = "/complete";
    public static final String RESEND_TRANSACTION_ENDPOINT = "/resend";

    @Override
    public Page<CoinbaseTransaction> getCoinbaseTransactions(String coinbaseAccountId, String startingAfter, String endingBefore, Integer limit, String order) {
        return wallet.pagedGet(COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + TRANSACTIONS_ENDPOINT, new TypeReference<>(){}, startingAfter, endingBefore, limit, order);
    }

    @Override
    public CoinbaseTransaction getCoinbaseTransaction(String coinbaseAccountId, String coinbaseTransactionId) {
        String coinbaseTransactionEndpoint = COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + TRANSACTIONS_ENDPOINT + "/" + coinbaseTransactionId;
        Data<CoinbaseTransaction> data = wallet.get(coinbaseTransactionEndpoint, new TypeReference<>(){});
        return data.getData();
    }

    @Override
    public CoinbaseTransaction sendMoney(String coinbaseAccountId, SendMoneyRequest sendMoneyRequest) {
        Data<CoinbaseTransaction> data = wallet.post(COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + TRANSACTIONS_ENDPOINT, new TypeReference<>(){}, sendMoneyRequest);
        return data.getData();
    }

    @Override
    public CoinbaseTransaction transferMoneyBetweenAccounts(String coinbaseAccountId, TransferMoneyBetweenAccountsRequest request) {
        Data<CoinbaseTransaction> data = wallet.post(COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + TRANSACTIONS_ENDPOINT, new TypeReference<>(){}, request);
        return data.getData();
    }

    @Override
    public CoinbaseTransaction requestMoneyFromEmail(String coinbaseAccountId, RequestMoneyFromEmailRequest request) {
        Data<CoinbaseTransaction> data = wallet.post(COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + TRANSACTIONS_ENDPOINT, new TypeReference<>(){}, request);
        return data.getData();
    }

    @Override
    public CoinbaseTransaction completeRequestMoney(String coinbaseAccountId, String coinbaseTransactionId) {
        String coinbaseTransactionEndpoint = COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + TRANSACTIONS_ENDPOINT + "/" + coinbaseTransactionId + COMPLETE_TRANSACTION_ENDPOINT;
        Data<CoinbaseTransaction> data = wallet.post(coinbaseTransactionEndpoint, new TypeReference<>(){}, null);
        return data.getData();
    }

    @Override
    public CoinbaseTransaction resendRequestMoneyFromEmail(String coinbaseAccountId, String coinbaseTransactionId) {
        String coinbaseTransactionEndpoint = COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + TRANSACTIONS_ENDPOINT + "/" + coinbaseTransactionId + RESEND_TRANSACTION_ENDPOINT;
        Data<CoinbaseTransaction> data = wallet.post(coinbaseTransactionEndpoint, new TypeReference<>(){}, null);
        return data.getData();
    }

    @Override
    public CoinbaseTransaction cancelRequestMoney(String coinbaseAccountId, String coinbaseTransactionId) {
        String coinbaseTransactionEndpoint = COINBASE_ACCOUNTS_ENDPOINT + "/" + coinbaseAccountId + TRANSACTIONS_ENDPOINT + "/" + coinbaseTransactionId;
        Data<CoinbaseTransaction> data = wallet.delete(coinbaseTransactionEndpoint, new TypeReference<>(){});
        return data.getData();
    }
}
