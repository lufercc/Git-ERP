package com.jalasoft.automation.erp.portal.ui.custom.selog.accounting;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class JournalEntry {

    public String code;

    public void fillMainData(JournalEntry aux) {
        this.code = aux.code;
    }
}
