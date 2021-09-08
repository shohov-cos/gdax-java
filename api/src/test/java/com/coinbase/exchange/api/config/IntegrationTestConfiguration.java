package com.coinbase.exchange.api.config;

import com.coinbase.exchange.api.coinbase.CoinbaseExchange;
import com.coinbase.exchange.api.coinbase.CoinbaseExchangeImpl;
import com.coinbase.exchange.api.coinbase.CoinbaseWallet;
import com.coinbase.exchange.api.coinbase.CoinbaseWalletImpl;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.concurrent.Executors;

@SpringBootConfiguration
public class IntegrationTestConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().registerModule(new JavaTimeModule()).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Bean
    public CoinbaseExchange coinbaseExchange(@Value("${exchange.key}") String apiKey,
                                             @Value("${exchange.passphrase}") String passphrase,
                                             @Value("${exchange.api.baseUrl}") String baseUrl,
                                             @Value("${exchange.secret}") String secretKey,
                                             ObjectMapper objectMapper) {
        return new CoinbaseExchangeImpl(apiKey,
                passphrase,
                baseUrl,
                secretKey,
                objectMapper,
                Executors.newSingleThreadExecutor());
    }

    @Bean
    public CoinbaseWallet coinbaseWallet(@Value("${wallet.key}") String apiKey,
                                         @Value("${wallet.api.baseUrl}") String baseUrl,
                                         @Value("${wallet.secret}") String secretKey,
                                         ObjectMapper objectMapper) {
        return new CoinbaseWalletImpl(apiKey,
                baseUrl,
                secretKey,
                null,
                objectMapper,
                Executors.newSingleThreadExecutor());
    }

}
