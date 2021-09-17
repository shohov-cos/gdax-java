package com.coinbase.exchange.api.currencies;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {
    private String id;
    private String name;
    private BigDecimal minSize;
    private String status;
    private BigDecimal maxPrecision;
    private String message;
    private String[] convertibleTo;
    private Map<String, Object> details;

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

    public BigDecimal getMinSize() {
        return minSize;
    }

    @JsonProperty("min_size")
    public void setMinSize(BigDecimal minSize) {
        this.minSize = minSize;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getMaxPrecision() {
        return maxPrecision;
    }

    @JsonProperty("max_precision")
    public void setMaxPrecision(BigDecimal maxPrecision) {
        this.maxPrecision = maxPrecision;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String[] getConvertibleTo() {
        return convertibleTo;
    }

    @JsonProperty("convertible_to")
    public void setConvertibleTo(String[] convertibleTo) {
        this.convertibleTo = convertibleTo;
    }

    public Map<String, Object> getDetails() {
        return details;
    }

    public void setDetails(Map<String, Object> details) {
        this.details = details;
    }
}
