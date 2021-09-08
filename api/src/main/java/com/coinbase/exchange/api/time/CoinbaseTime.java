package com.coinbase.exchange.api.time;

import java.time.OffsetDateTime;

public class CoinbaseTime {
    private OffsetDateTime iso;
    private long epoch;

    public OffsetDateTime getIso() {
        return iso;
    }

    public void setIso(OffsetDateTime iso) {
        this.iso = iso;
    }

    public long getEpoch() {
        return epoch;
    }

    public void setEpoch(long epoch) {
        this.epoch = epoch;
    }
}
