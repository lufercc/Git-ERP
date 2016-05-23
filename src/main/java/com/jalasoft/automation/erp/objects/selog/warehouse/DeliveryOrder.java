package com.jalasoft.automation.erp.objects.selog.warehouse;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class DeliveryOrder {

    public String code;

    public DeliveryOrder() {
    }

    public void fillMainData(DeliveryOrder aux) {
        this.code = aux.code;
    }

}
