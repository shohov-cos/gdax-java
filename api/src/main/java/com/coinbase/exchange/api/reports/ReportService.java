package com.coinbase.exchange.api.reports;

public interface ReportService {
    // TODO untested
    ReportResponse createReport(String type, String startDate, String endDate);

    // TODO untested
    ReportResponse getReportStatus(String id);
}
