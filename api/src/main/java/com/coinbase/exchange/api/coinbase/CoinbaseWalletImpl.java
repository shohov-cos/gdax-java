package com.coinbase.exchange.api.coinbase;

import com.coinbase.exchange.security.Signature;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;

import static com.coinbase.exchange.security.Signature.SignatureEncoding.HEX;

public class CoinbaseWalletImpl extends CoinbaseCommonImpl implements CoinbaseWallet {

    public CoinbaseWalletImpl(String publicKey, String baseUrl, String secretKey, String version,
                              ObjectMapper objectMapper, ExecutorService executorService) {
        super(publicKey, null, baseUrl, new Signature(secretKey.getBytes(StandardCharsets.UTF_8), HEX), version, objectMapper, executorService);
    }

    @Override
    public <T> Page<T> pagedGet(String resourcePath, TypeReference<Page<T>> typeReference, String startingAfter, String endingBefore, Integer limit, String order) {
        boolean questionMark = true;
        if (limit != null) {
            resourcePath += "?" + "limit=" + limit;
            questionMark = false;
        }
        if (startingAfter != null) {
            resourcePath += (questionMark ? "?" : "&") + "starting_after=" + startingAfter;
            questionMark = false;
        } else if (endingBefore != null) {
            resourcePath += (questionMark ? "?" : "&") + "ending_before=" + endingBefore;
            questionMark = false;
        }
        if (order != null) {
            resourcePath += (questionMark ? "?" : "&") + "order=" + order;
//            questionMark = false;
        }
        return get(resourcePath, typeReference);
    }
}
