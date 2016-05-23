package com.jalasoft.automation.erp.objects.selog.accounting;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class Asset {

    public String name;
    public String code;
    public String parent;
    public String grossValue;
    public String hierarchyType;

    public void fillMainData(Asset aux) {
        code = aux.code;
    }
}
