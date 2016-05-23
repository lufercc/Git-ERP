package com.jalasoft.automation.erp.objects.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class InternalCareer extends OdooObject {

    public String department;
    public String division;
    public String jobTitle;
    public String projectCode;
    public String weight;
    public String startDate;
    public String endDate;
    public String employer;
    public String manager;
    public String lead;
    public String description;

    public boolean matchWith(boolean shouldContain, OdooObject inputData) {
        return false;
    }
}
