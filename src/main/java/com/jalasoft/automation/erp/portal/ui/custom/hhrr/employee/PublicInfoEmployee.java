package com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class PublicInfoEmployee {

    public String addressDescription;
    public String workEmail;
    public String workPhone;
    public String extCode;
    public String workMobile;
    public String user;
    public String otherInfo;
    public String location;
    public String codeDesktop;
    public String country;
    public String city;

    public void fillMainData(PublicInfoEmployee aux) {
        this.addressDescription = aux.addressDescription;
        this.workEmail = aux.workEmail;
        this.workPhone = aux.workPhone;
        this.extCode = aux.extCode;
        this.workMobile = aux.workMobile;
        this.user = aux.user;
        this.otherInfo = aux.otherInfo;
        this.location = aux.location;
        this.codeDesktop = aux.codeDesktop;
        this.country = aux.country;
        this.city = aux.city;
    }

    public boolean contains(PublicInfoEmployee mainData) {
        if(!this.addressDescription.equals(mainData.addressDescription)) {return false;}
        if(!this.workEmail.equals(mainData.workEmail)) {return false;}
        if(!this.workPhone.equals(mainData.workPhone)) {return false;}
        if(!this.extCode.equals(mainData.extCode)) {return false;}
        if(!this.workMobile.equals(mainData.workMobile)) {return false;}
        if(!this.user.equals(mainData.user)) {return false;}
        if(!this.otherInfo.equals(mainData.otherInfo)) {return false;}
        if(!this.location.equals(mainData.location)) {return false;}
        if(!this.codeDesktop.equals(mainData.codeDesktop)) {return false;}
        if(!this.country.equals(mainData.country)) {return false;}
        if(!this.city.equals(mainData.city)) {return false;}
        return true;
    }
}
