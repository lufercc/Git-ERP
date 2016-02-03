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
        this.addressDescription = (aux.addressDescription != null) ? aux.addressDescription : null;
        this.workEmail = (aux.workEmail != null) ? aux.workEmail : null;
        this.workPhone = (aux.workPhone != null) ? aux.workPhone : null;
        this.extCode = (aux.extCode != null) ? aux.extCode : null;
        this.workMobile = (aux.workMobile != null) ? aux.workMobile : null;
        this.user = (aux.user != null) ? aux.user : null;
        this.otherInfo = (aux.otherInfo != null) ? aux.otherInfo : null;
        this.location = (aux.location != null) ? aux.location : null;
        this.codeDesktop = (aux.codeDesktop != null) ? aux.codeDesktop : null;
        this.country = (aux.country != null) ? aux.country : null;
        this.city = (aux.city != null) ? aux.city : null;
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
