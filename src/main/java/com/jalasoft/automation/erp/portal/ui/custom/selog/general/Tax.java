package com.jalasoft.automation.erp.portal.ui.custom.selog.general;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class Tax {

    public String taxDescription;
    public String taxAccount;
    public String analyticDistribution;
    public String base;
    public String taxAmount;
    public String includeJournalEntry;

    public void fillMainData(Tax aux) {
        this.taxDescription = aux.taxDescription;
    }
}
