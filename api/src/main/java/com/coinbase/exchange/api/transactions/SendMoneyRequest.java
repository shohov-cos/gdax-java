package com.coinbase.exchange.api.transactions;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class SendMoneyRequest {
    private static final String TYPE = "send";
    private String to;
    private BigDecimal amount;
    private String currency;
    private String description;
    private Boolean skipNotifications;
    private String fee;
    private String idem;
    private Boolean toFinancialInstitution;
    private String financialInstitutionWebsite;

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

    @JsonProperty("skip_notifications")
    public Boolean getSkipNotifications() {
        return skipNotifications;
    }

    public void setSkipNotifications(Boolean skipNotifications) {
        this.skipNotifications = skipNotifications;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getIdem() {
        return idem;
    }

    public void setIdem(String idem) {
        this.idem = idem;
    }

    @JsonProperty("to_financial_institution")
    public Boolean getToFinancialInstitution() {
        return toFinancialInstitution;
    }

    public void setToFinancialInstitution(Boolean toFinancialInstitution) {
        this.toFinancialInstitution = toFinancialInstitution;
    }

    @JsonProperty("financial_institution_website")
    public String getFinancialInstitutionWebsite() {
        return financialInstitutionWebsite;
    }

    public void setFinancialInstitutionWebsite(String financialInstitutionWebsite) {
        this.financialInstitutionWebsite = financialInstitutionWebsite;
    }
}
