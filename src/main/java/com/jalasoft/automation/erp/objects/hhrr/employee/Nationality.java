package com.jalasoft.automation.erp.objects.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class Nationality extends OdooObject {

    public String name;
    public String code;

    public boolean matchWith(boolean shouldContain, OdooObject inputData) {
        return false;
    }
}
