package com.jalasoft.automation.erp.portal.ui.custom.selog.general;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class Product {

    public String productID;
    public String description;
    public String account;
    public String analyticDistribution;
    public String assetCategory;
    public String quantity;
    public String unitMeasure;
    public String unitPrice;
    public String discount;
    public String taxes;
    public String amount;

    public void fillMainData(Product aux) {
        this.productID = aux.productID;
    }
}
