package com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class BasicInfoEmployee {

    public String firstName;
    public String firstNameCheck;
    public String middleName;
    public String middleNameCheck;
    public String lastName;
    public String secondLastName;
    public String marriedName;
    public String fullName;

    public void fillMainData(BasicInfoEmployee aux) {
        this.fullName = aux.fullName;
        this.firstName = aux.firstName;
        this.firstNameCheck = aux.firstNameCheck;
        this.middleName = aux.middleName;
        this.middleNameCheck = aux.middleNameCheck;
        this.lastName = aux.lastName;
        this.secondLastName = aux.secondLastName;
        this.marriedName = aux.marriedName;
    }

    public boolean contains(BasicInfoEmployee mainData) {
        if(!this.fullName.equals(mainData.fullName)) {return false;}
        return true;
    }
}
