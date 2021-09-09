package com.coinbase.exchange.api.transactions;

import com.coinbase.exchange.api.addresses.Address;
import com.coinbase.exchange.api.coinbaseaccounts.MoneyAmount;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.Map;

public class CoinbaseTransaction {
    private String id;
    private String type;
    private String status;
    private MoneyAmount amount;
    private MoneyAmount nativeAmount;
    private String description;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private String resource;
    private String resourcePath;
    private Map<String, Object> details;
    private Map<String, Object> network;
    private Map<String, Object> to;
    private Map<String, Object> from;
    private Address address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public MoneyAmount getAmount() {
        return amount;
    }

    public void setAmount(MoneyAmount amount) {
        this.amount = amount;
    }

    public MoneyAmount getNativeAmount() {
        return nativeAmount;
    }

    @JsonProperty("native_amount")
    public void setNativeAmount(MoneyAmount nativeAmount) {
        this.nativeAmount = nativeAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Map<String, Object> getDetails() {
        return details;
    }

    public void setDetails(Map<String, Object> details) {
        this.details = details;
    }

    public Map<String, Object> getNetwork() {
        return network;
    }

    public void setNetwork(Map<String, Object> network) {
        this.network = network;
    }

    public Map<String, Object> getTo() {
        return to;
    }

    public void setTo(Map<String, Object> to) {
        this.to = to;
    }

    public Map<String, Object> getFrom() {
        return from;
    }

    public void setFrom(Map<String, Object> from) {
        this.from = from;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
