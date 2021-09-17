package com.coinbase.exchange.api.reports;

import com.coinbase.exchange.api.coinbase.CoinbaseExchange;
import com.fasterxml.jackson.core.type.TypeReference;

/**
 * Created by robevansuk on 16/02/2017.
 */
public class ReportServiceImpl implements ReportService {

    private static final String REPORTS_ENDPOINT = "/reports";

    final CoinbaseExchange coinbaseExchange;

    public ReportServiceImpl(final CoinbaseExchange coinbaseExchange) {
        this.coinbaseExchange = coinbaseExchange;
    }

    // TODO untested
    @Override
    public ReportResponse createReport(String type, String startDate, String endDate){
        ReportRequest reportRequest = new ReportRequest(type, startDate, endDate);
        return coinbaseExchange.post(REPORTS_ENDPOINT, new TypeReference<>(){}, reportRequest);
    }

    // TODO untested
    @Override
    public ReportResponse getReportStatus(String id) {
        return coinbaseExchange.get(REPORTS_ENDPOINT + "/" + id, new TypeReference<>(){});
    }
}
