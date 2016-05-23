package com.jalasoft.automation.erp.objects.selog.sales;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class SaleOrder {

    public String code;
    public String client;
    public String tin;
    public String saleTaxType;

    public SaleOrder() {
    }

    public void fillMainData(SaleOrder aux) {
        this.code = aux.code;
    }

}
