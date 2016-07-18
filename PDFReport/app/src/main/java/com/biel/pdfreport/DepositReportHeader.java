package com.biel.pdfreport;

/**
 * Created by Biel on 18/7/2016.
 */
public class DepositReportHeader extends ReportFragment {
    String dades;
    @Override
    public String getXML() {
        return "<h1>Títol Diposits</h1>";
    }
}
