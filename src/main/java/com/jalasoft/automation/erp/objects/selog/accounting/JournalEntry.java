package com.jalasoft.automation.erp.objects.selog.accounting;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class JournalEntry {

    public String code;
    public String reference;

    public void fillMainData(JournalEntry aux) {
        code = aux.code;
        reference = aux.reference;
    }
}
