package com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee;

import org.apache.log4j.Logger;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class PersonalInfoEmployee {
    private Logger log;
    public String nationalOrForeign;
    public String idNumber;
    public String idExpDate;
    public String idPlace;
    public String passportNumber;
    public String passportPlace;
    public String passportExpDate;
    public String hasVisa;
    public String visaType;
    public String visaExpDate;
    public String homeAddress;
    public String homeAddressDescription;
    public String dateBirth;
    public String age;
    public String country;
    public String city;

    public PersonalInfoEmployee() {
        log = Logger.getLogger(getClass());
    }

    public void fillMainData(PersonalInfoEmployee aux) {
        this.nationalOrForeign = aux.nationalOrForeign;
        this.idNumber = aux.idNumber;
        this.idExpDate = aux.idExpDate;
        this.idPlace = aux.idPlace;
        this.passportNumber = aux.passportNumber;
        this.passportPlace = aux.passportPlace;
        this.passportExpDate = aux.passportExpDate;
        this.hasVisa = aux.hasVisa;
        this.visaType = aux.visaType;
        this.visaExpDate = aux.visaExpDate;
        this.homeAddressDescription = aux.homeAddressDescription;
        this.dateBirth = aux.dateBirth;
        this.age = aux.age;
        this.country = aux.country;
        this.city = aux.city;
    }

    public boolean contains(PersonalInfoEmployee uiData) {
        log = Logger.getLogger(getClass());

        if (this.nationalOrForeign != null){
            if(!this.nationalOrForeign.equals(uiData.nationalOrForeign)) {
                logWarning(this.nationalOrForeign);
                return false;
            }
        }
        if (this.idNumber != null) {
            if (!this.idNumber.equals(uiData.idNumber)) {
                logWarning(this.idNumber);
                return false;
            }
        }
        if (this.idExpDate != null) {
            if (!this.idExpDate.equals(uiData.idExpDate)) {
                logWarning(this.idExpDate);
                return false;
            }
        }
        if (this.idPlace != null) {
            if (!this.idPlace.equals(uiData.idPlace)) {
                logWarning(this.idPlace);
                return false;
            }
        }
        if (this.passportNumber != null) {
            if (!this.passportNumber.equals(uiData.passportNumber)) {
                logWarning(this.passportNumber);
                return false;
            }
        }
        if (this.passportPlace != null) {
            if (!this.passportPlace.equals(uiData.passportPlace)) {
                logWarning(this.passportPlace);
                return false;
            }
        }
        if (this.passportExpDate != null) {
            if (!this.passportExpDate.equals(uiData.passportExpDate)) {
                logWarning(this.passportExpDate);
                return false;
            }
        }
        if (this.hasVisa != null) {
            if (!this.hasVisa.equals(uiData.hasVisa)) {
                logWarning(this.hasVisa);
                return false;
            }
        }
        if (this.visaType != null) {
            if (!this.visaType.equals(uiData.visaType)) {
                logWarning(this.nationalOrForeign);
                return false;
            }
        }
        if (this.visaExpDate != null){
            if(!this.visaExpDate.equals(uiData.visaExpDate)) {
                logWarning(this.visaExpDate);
                return false;
            }
        }
        if (this.homeAddressDescription != null){
            if(!this.homeAddressDescription.equals(uiData.homeAddressDescription)) {
                logWarning(this.homeAddressDescription);
                return false;
            }
        }
        if (this.dateBirth != null){
            if(!this.dateBirth.equals(uiData.dateBirth)) {
                logWarning(this.dateBirth);
                return false;
            }
        }
        if (this.age != null){
            if(!this.age.equals(uiData.age)) {
                logWarning(this.age);
                return false;
            }
        }
        if (this.country != null){
            if(!this.country.equals(uiData.country)) {
                logWarning(this.country);
                return false;
            }
        }
        if (this.city != null){
            if(!this.city.equals(uiData.city)) {
                logWarning(this.city);
                return false;
            }
        }
        return true;
    }

    public void logWarning(String field) {
        log.warn("This expected value: '" + field + "' was not found in the UI");
    }
}
