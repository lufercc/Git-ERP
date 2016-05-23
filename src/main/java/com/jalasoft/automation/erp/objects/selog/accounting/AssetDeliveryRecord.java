package com.jalasoft.automation.erp.objects.selog.accounting;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class AssetDeliveryRecord {

    public String id;

    public void fillMainData(AssetDeliveryRecord aux) {
        id = aux.id;
    }
}
