package com.jalasoft.automation.erp.objects.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class FamilyMember extends OdooObject{

    public String name;
    public String lastName;
    public String relation;
    public String sex;
    public String birthDate;

    public boolean matchWith(boolean shouldContain, OdooObject inputData) {
        return false;
    }
}
