package com.jalasoft.automation.erp.objects.selog.purchase;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class PurchaseOrder {

    public String code;
    public String supplier;
    public String purchaseType;

    public PurchaseOrder() {
    }

    public void fillMainData(PurchaseOrder aux) {
        this.code = aux.code;
    }

}
