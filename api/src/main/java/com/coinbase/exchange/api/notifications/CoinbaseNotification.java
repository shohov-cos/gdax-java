package com.coinbase.exchange.api.notifications;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import java.util.Map;

public class CoinbaseNotification {
    private String id;
    private String type;
    private Map<String, Object> data;
    private Map<String, Object> user;
    private Map<String, Object> account;
    private Integer deliveryAttempts;
    private Map<String, Object> deliveryResponse;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private String resource;
    private String resourcePath;
    private Map<String, Object> additionalData;
    private OffsetDateTime deliveredAt;
    private Map<String, Object> subscriber;

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

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Map<String, Object> getUser() {
        return user;
    }

    public void setUser(Map<String, Object> user) {
        this.user = user;
    }

    public Map<String, Object> getAccount() {
        return account;
    }

    public void setAccount(Map<String, Object> account) {
        this.account = account;
    }

    public Integer getDeliveryAttempts() {
        return deliveryAttempts;
    }

    @JsonProperty("delivery_attempts")
    public void setDeliveryAttempts(Integer deliveryAttempts) {
        this.deliveryAttempts = deliveryAttempts;
    }

    public Map<String, Object> getDeliveryResponse() {
        return deliveryResponse;
    }

    @JsonProperty("delivery_response")
    public void setDeliveryResponse(Map<String, Object> deliveryResponse) {
        this.deliveryResponse = deliveryResponse;
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

    public Map<String, Object> getAdditionalData() {
        return additionalData;
    }

    @JsonProperty("additional_data")
    public void setAdditionalData(Map<String, Object> additionalData) {
        this.additionalData = additionalData;
    }

    public OffsetDateTime getDeliveredAt() {
        return deliveredAt;
    }

    @JsonProperty("delivered_at")
    public void setDeliveredAt(OffsetDateTime deliveredAt) {
        this.deliveredAt = deliveredAt;
    }

    public Map<String, Object> getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Map<String, Object> subscriber) {
        this.subscriber = subscriber;
    }
}
