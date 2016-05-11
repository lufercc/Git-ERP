package com.jalasoft.automation.erp.portal.ui.custom.selog.purchase;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class Supplier {

    public String name;
    public String isACompany;
    public String address;
    public String purchasePricelist;
    public String salePricelist;
    public String tin;

    public Supplier() {
    }

    public void fillMainData(Supplier aux) {
        name = aux.name;
    }

}
