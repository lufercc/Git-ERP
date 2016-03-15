package com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.custom.hhrr.GeneralRecord;
import org.apache.log4j.Logger;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class PublicInfoEmployee extends GeneralRecord{
    public String address;
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

    public boolean contains(PublicInfoEmployee uiData) {
        if (this.address != null){
            if(!this.address.equals(uiData.address)) {
                logWarning("address", this.address);
                return false;
            }
        }

        if (this.addressDescription != null){
            if(!this.addressDescription.equals(uiData.addressDescription)) {
                logWarning("addressDescription", this.addressDescription);
                return false;
            }
        }
        if (this.workEmail != null) {
            if (!this.workEmail.equals(uiData.workEmail)) {
                logWarning("workEmail", this.workEmail);
                return false;
            }
        }
        if (this.workPhone != null) {
            if(!this.workPhone.equals(uiData.workPhone)) {
                logWarning("workPhone", this.workPhone);
                return false;
            }
        }
        if (this.extCode != null) {
            if (!this.extCode.equals(uiData.extCode)) {
                logWarning("extCode", this.extCode);
                return false;
            }
        }
        if (this.workMobile != null) {
            if (!this.workMobile.equals(uiData.workMobile)) {
                logWarning("workMobile", this.workMobile);
                return false;
            }
        }
        if (this.user != null) {
            if (!this.user.equals(uiData.user)) {
                logWarning("user", this.user);
                return false;
            }
        }
        if (this.otherInfo != null){
            if(!this.otherInfo.equals(uiData.otherInfo)) {
                logWarning("otherInfo", this.otherInfo);
                return false;
            }
        }
        if (this.location != null){
            if(!this.location.equals(uiData.location)) {
                logWarning("location", this.location);
                return false;
            }
        }
        if (this.codeDesktop != null){
            if(!this.codeDesktop.equals(uiData.codeDesktop)) {
                logWarning("codeDesktop", this.codeDesktop);
                return false;
            }
        }
        if (this.country != null){
            if(!this.country.equals(uiData.country)) {
                logWarning("country", this.country);
                return false;
            }
        }
        if (this.city != null){
            if(!this.city.equals(uiData.city)) {
                logWarning("city", this.city);
                return false;
            }
        }
        return true;
    }
}
