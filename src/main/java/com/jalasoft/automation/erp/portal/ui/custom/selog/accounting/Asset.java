package com.jalasoft.automation.erp.portal.ui.custom.selog.accounting;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class Asset {

    public String name;
    public String code;
    public String assetCategoryParent;
    public String grossValue;

    public void fillMainData(Asset aux) {
        this.code = aux.code;
    }
}
