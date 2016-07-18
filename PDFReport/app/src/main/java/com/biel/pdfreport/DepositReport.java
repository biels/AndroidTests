package com.biel.pdfreport;

/**
 * Created by Biel on 18/7/2016.
 */
public class DepositReport extends ReportFragment {
    DepositReportHeader header;
    DepositReportDetails details;
    @Override
    public String getXML() {
        return String.format("<html><head><title>pilota</title></head><body>{0}{1}</body></html>", header.getXML(), details.getXML());
    }
}
