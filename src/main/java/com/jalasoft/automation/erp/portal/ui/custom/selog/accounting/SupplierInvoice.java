package com.jalasoft.automation.erp.portal.ui.custom.selog.accounting;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class SupplierInvoice {

    public String code;
    public String tin;
    public String number;
    public String authorizationNumber;
    public String controlCode;

    public void fillMainData(SupplierInvoice aux) {
        this.code = aux.code;
    }
}
