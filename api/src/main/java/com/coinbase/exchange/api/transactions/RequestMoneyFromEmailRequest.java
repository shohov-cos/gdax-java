package com.coinbase.exchange.api.transactions;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;

public class RequestMoneyFromEmailRequest {
    private static final String TYPE = "request";
    private String to;
    private BigDecimal amount;
    private String currency;
    private String description;

    public String getType() {
        return TYPE;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
