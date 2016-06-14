package com.jalasoft.automation.erp.objects.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class EmergencyContact extends OdooObject {

    public String name;
    public String relationship;
    public String phone;
    public String mobile;
    public String employee;

    public boolean matchWith(boolean shouldContain, OdooObject inputData) {
        return false;
    }
}
