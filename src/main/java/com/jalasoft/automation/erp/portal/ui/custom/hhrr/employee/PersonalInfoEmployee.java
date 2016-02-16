package com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class PersonalInfoEmployee {

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
    public String homeAddressDescription;
    public String dateBirth;
    public String age;
    public String country;
    public String city;

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

    public boolean contains(PersonalInfoEmployee mainData) {
        if(!this.nationalOrForeign.equals(mainData.nationalOrForeign)) {return false;}
        if(!this.idNumber.equals(mainData.idNumber)) {return false;}
        if(!this.idExpDate.equals(mainData.idExpDate)) {return false;}
        if(!this.idPlace.equals(mainData.idPlace)) {return false;}
        if(!this.passportNumber.equals(mainData.passportNumber)) {return false;}
        if(!this.passportPlace.equals(mainData.passportPlace)) {return false;}
        if(!this.passportExpDate.equals(mainData.passportExpDate)) {return false;}
        if(!this.hasVisa.equals(mainData.hasVisa)) {return false;}
        if(!this.visaType.equals(mainData.visaType)) {return false;}
        if(!this.visaExpDate.equals(mainData.visaExpDate)) {return false;}
        if(!this.homeAddressDescription.equals(mainData.homeAddressDescription)) {return false;}
        if(!this.dateBirth.equals(mainData.dateBirth)) {return false;}
        if(!this.age.equals(mainData.age)) {return false;}
        if(!this.country.equals(mainData.country)) {return false;}
        if(!this.city.equals(mainData.city)) {return false;}
        return true;
    }
}
