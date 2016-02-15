package com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class BasicInfoEmployee {

    public String name;
    public String fullName;

    public void fillMainData(BasicInfoEmployee aux) {
        this.name = aux.name;
        this.fullName = aux.fullName;

//        if (aux.name != null) {
//            this.name = aux.name;
//        }
//        this.fullName = (aux.fullName != null) ? aux.fullName : null;
    }

    public boolean contains(BasicInfoEmployee mainData) {
        if(!this.fullName.equals(mainData.fullName)) {return false;}
        return true;
    }
}
