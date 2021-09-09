package com.coinbase.exchange.api.coinbaseaccounts;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;

public class CoinbaseAccount {
    public enum Type {
        wallet, fiat, vault
    }

    private String id;
    private String name;
    private boolean primary;
    private Type type;
    private Currency currency;
    private MoneyAmount balance;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private String resource;
    private String resourcePath;
    private boolean allowDeposits;
    private boolean allowWithdrawals;

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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public MoneyAmount getBalance() {
        return balance;
    }

    public void setBalance(MoneyAmount balance) {
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

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    @JsonProperty("resource_path")
    public void setResourcePath(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public boolean isAllowDeposits() {
        return allowDeposits;
    }

    @JsonProperty("allow_deposits")
    public void setAllowDeposits(boolean allowDeposits) {
        this.allowDeposits = allowDeposits;
    }

    public boolean isAllowWithdrawals() {
        return allowWithdrawals;
    }

    @JsonProperty("allow_withdrawals")
    public void setAllowWithdrawals(boolean allowWithdrawals) {
        this.allowWithdrawals = allowWithdrawals;
    }

    public static class Currency {
        public enum Type {
            fiat, crypto
        }

        private String code;
        private String name;
        private String color;
        private String sortIndex;
        private int exponent;
        private Type type;
        private String addressRegex;
        private String assetId;
        private String slug;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getSortIndex() {
            return sortIndex;
        }

        @JsonProperty("sort_index")
        public void setSortIndex(String sortIndex) {
            this.sortIndex = sortIndex;
        }

        public int getExponent() {
            return exponent;
        }

        public void setExponent(int exponent) {
            this.exponent = exponent;
        }

        public Type getType() {
            return type;
        }

        public void setType(Type type) {
            this.type = type;
        }

        public String getAddressRegex() {
            return addressRegex;
        }

        @JsonProperty("address_regex")
        public void setAddressRegex(String addressRegex) {
            this.addressRegex = addressRegex;
        }

        public String getAssetId() {
            return assetId;
        }

        @JsonProperty("asset_id")
        public void setAssetId(String assetId) {
            this.assetId = assetId;
        }

        public String getSlug() {
            return slug;
        }

        public void setSlug(String slug) {
            this.slug = slug;
        }
    }

}
