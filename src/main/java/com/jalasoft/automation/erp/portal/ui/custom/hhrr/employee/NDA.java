package com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class NDA {

    public String ndaVersion;
    public String signDate;


    public void fillMainData(NDA aux) {
        this.ndaVersion = (aux.ndaVersion != null) ? aux.ndaVersion : null;
        this.signDate = (aux.signDate != null) ? aux.signDate : null;
    }

    public boolean contains(NDA mainData) {
        if(!this.ndaVersion.equals(mainData.ndaVersion)) {return false;}
        if(!this.signDate.equals(mainData.signDate)) {return false;}
        return true;
    }
}
