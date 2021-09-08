package com.coinbase.exchange.api.coinbase;

import java.util.List;

public class Data<T> {
    private T data;
    private List<Warning> warnings;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<Warning> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<Warning> warnings) {
        this.warnings = warnings;
    }

    public static class Warning {
        private String id;
        private String message;
        private String url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
