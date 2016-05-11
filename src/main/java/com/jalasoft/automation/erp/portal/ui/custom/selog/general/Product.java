package com.jalasoft.automation.erp.portal.ui.custom.selog.general;

import com.jalasoft.automation.erp.portal.ui.custom.hhrr.GeneralRecord;
import org.apache.log4j.Logger;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class Product extends GeneralRecord {
    public String productID;
    public String name;
    public String category;
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
    public String productType;
    public String costPrice;
    public String purchasePrice;
    public String salePrice;
    public String quantityOnHand;
    public String expenseAccount;


    public void fillMainData(Product aux) {
        productID = aux.productID;
    }

    public boolean contains(boolean shouldContain, Product uiData) {
        if (name != null) {
            if(name.equals(uiData.name) != shouldContain) {
                logWarning("name", name);
                return false;
            }
        }
        if (salePrice != null) {
            if(salePrice.equals(uiData.salePrice) != shouldContain) {
                logWarning("salePrice", salePrice);
                return false;
            }
        }
        if (purchasePrice != null) {
            if (purchasePrice.equals(uiData.purchasePrice) != shouldContain) {
                logWarning("purchasePrice", purchasePrice);
                return false;
            }
        }
        if (costPrice != null) {
            if (costPrice.equals(uiData.costPrice) != shouldContain) {
                logWarning("costPrice", costPrice);
                return false;
            }
        }
        if (quantityOnHand != null) {
            if (quantityOnHand.equals(uiData.quantityOnHand) != shouldContain) {
                logWarning("quantityOnHand", quantityOnHand);
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String result = "";
        String eol = "\n";
        result += "productID: " + productID + eol;
        result += "description: " + description + eol;
        result += "account: " + account + eol;
        result += "analyticDistribution: " + analyticDistribution + eol;
        result += "assetCategory: " + assetCategory + eol;
        result += "quantity: " + quantity + eol;
        result += "unitMeasure: " + unitMeasure + eol;
        result += "unitPrice: " + unitPrice + eol;
        result += "discount: " + discount + eol;
        result += "taxes: " + taxes + eol;
        result += "amount: " + amount + eol;
        return result;
    }
}
