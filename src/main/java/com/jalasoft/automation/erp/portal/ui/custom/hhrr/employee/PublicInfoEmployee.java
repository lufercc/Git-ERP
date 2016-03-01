package com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee;

import org.apache.log4j.Logger;

import java.lang.reflect.Field;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class PublicInfoEmployee {

    private Logger log;
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

    public PublicInfoEmployee() {
        log = Logger.getLogger(getClass());
    }

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
        log = Logger.getLogger(getClass());

        if (this.addressDescription != null){
            if(!this.addressDescription.equals(uiData.addressDescription)) {
                log.warn("This expected value: '" + this.addressDescription + "' was not found in the UI");
                return false;
            }
        }
        if (this.workEmail != null) {
            if (!this.workEmail.equals(uiData.workEmail)) {
                log.warn("This expected value: '" + this.workEmail + "' was not found in the UI");
                return false;
            }
        }
        if (this.workPhone != null) {
            if(!this.workPhone.equals(uiData.workPhone)) {
                log.warn("This expected value: '" + this.workPhone + "' was not found in the UI");
                return false;
            }
        }
        if (this.extCode != null) {
            if (!this.extCode.equals(uiData.extCode)) {
                log.warn("This expected value: '" + this.extCode + "' was not found in the UI");
                return false;
            }
        }
        if (this.workMobile != null) {
            if (!this.workMobile.equals(uiData.workMobile)) {
                log.warn("This expected value: '" + this.workMobile + "' was not found in the UI");
                return false;
            }
        }
        if (this.user != null) {
            if (!this.user.equals(uiData.user)) {
                log.warn("This expected value: '" + this.user + "' was not found in the UI");
                return false;
            }
        }
        if (this.otherInfo != null){
            if(!this.otherInfo.equals(uiData.otherInfo)) {
                log.warn("This expected value: '" + this.otherInfo + "' was not found in the UI");
                return false;
            }
        }
        if (this.location != null){
            if(!this.location.equals(uiData.location)) {
                log.warn("This expected value: '" + this.location + "' was not found in the UI");
                return false;
            }
        }
        if (this.codeDesktop != null){
            if(!this.codeDesktop.equals(uiData.codeDesktop)) {
                log.warn("This expected value: '" + this.codeDesktop + "' was not found in the UI");
                return false;
            }
        }
        if (this.country != null){
            if(!this.country.equals(uiData.country)) {
                log.warn("This expected value: '" + this.country + "' was not found in the UI");
                return false;
            }
        }
        if (this.city != null){
            if(!this.city.equals(uiData.city)) {
                log.warn("This expected value: '" + this.city + "' was not found in the UI");
                return false;
            }
        }
        return true;
    }
}
