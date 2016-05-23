package com.jalasoft.automation.erp.objects.selog.warehouse;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class IncomingShipment {

    public String code;

    public IncomingShipment() {
    }

    public void fillMainData(IncomingShipment aux) {
        this.code = aux.code;
    }

}
