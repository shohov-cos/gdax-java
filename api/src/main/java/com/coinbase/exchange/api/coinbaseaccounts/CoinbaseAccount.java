package com.coinbase.exchange.api.coinbaseaccounts;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class CoinbaseAccount {
    public enum Type {
        wallet, fiat, vault
    }

    private String id;
    private String name;
    private boolean primary;
    private boolean active;
    private Type type;
    private String currency;
    private BigDecimal balance;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public CoinbaseAccount() {
        balance = BigDecimal.ZERO;
    }

    public CoinbaseAccount(String id, String name, boolean primary, boolean active, Type type, String currency, BigDecimal balance) {
        this.id = id;
        this.name = name;
        this.primary = primary;
        this.active = active;
        this.type = type;
        this.currency = currency;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    @JsonProperty("updated_at")
    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
