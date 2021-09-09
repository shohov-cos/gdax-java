package com.coinbase.exchange.api.coinbase;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Page<T> {

    private Pagination pagination;
    private List<T> data;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public static class Pagination {
        private String endingBefore;
        private String startingAfter;
        private Integer limit;
        private String order;
        private String previousUri;
        private String nextUri;

        public String getEndingBefore() {
            return endingBefore;
        }

        @JsonProperty("ending_before")
        public void setEndingBefore(String endingBefore) {
            this.endingBefore = endingBefore;
        }

        public String getStartingAfter() {
            return startingAfter;
        }

        @JsonProperty("starting_after")
        public void setStartingAfter(String startingAfter) {
            this.startingAfter = startingAfter;
        }

        public Integer getLimit() {
            return limit;
        }

        public void setLimit(Integer limit) {
            this.limit = limit;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getPreviousUri() {
            return previousUri;
        }

        @JsonProperty("previous_uri")
        public void setPreviousUri(String previousUri) {
            this.previousUri = previousUri;
        }

        public String getNextUri() {
            return nextUri;
        }

        @JsonProperty("next_uri")
        public void setNextUri(String nextUri) {
            this.nextUri = nextUri;
        }
    }
}
