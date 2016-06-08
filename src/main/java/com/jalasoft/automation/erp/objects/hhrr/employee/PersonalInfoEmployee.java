package com.jalasoft.automation.erp.objects.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import org.apache.log4j.Logger;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class PersonalInfoEmployee extends OdooObject {
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
    public String hasDriverLicense;
    public String motorcycleLicence;
    public String motorcycleLicenceEXP;
    public String carLicence;
    public String bloodType;
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
        this.hasDriverLicense = aux.hasDriverLicense;
        this.motorcycleLicence = aux.motorcycleLicence;
        this.motorcycleLicenceEXP = aux.motorcycleLicenceEXP;
        this.carLicence = aux.carLicence;
        this.bloodType = aux.bloodType;
        this.homeAddress = aux.homeAddress;
        this.homeAddressDescription = aux.homeAddressDescription;
        this.dateBirth = aux.dateBirth;
        this.age = aux.age;
        this.country = aux.country;
        this.city = aux.city;
    }

    public boolean matchWith(boolean shouldContain, OdooObject inputData) {
        PersonalInfoEmployee uiData = (PersonalInfoEmployee)inputData;

        if (this.nationalOrForeign != null) {
            if(this.nationalOrForeign.equals(uiData.nationalOrForeign) != shouldContain) {
                logWarning("nationalOrForeign", this.nationalOrForeign);
                return false;
            }
        }
        if (this.idNumber != null) {
            if (this.idNumber.equals(uiData.idNumber) != shouldContain) {
                logWarning("idNumber", this.idNumber);
                return false;
            }
        }
        if (this.idExpDate != null) {
            if (this.idExpDate.equals(uiData.idExpDate) != shouldContain) {
                logWarning("idExpDate", this.idExpDate);
                return false;
            }
        }
        if (this.idPlace != null) {
            if (this.idPlace.equals(uiData.idPlace) != shouldContain) {
                logWarning("idPlace", this.idPlace);
                return false;
            }
        }
        if (this.passportNumber != null) {
            if (this.passportNumber.equals(uiData.passportNumber) != shouldContain) {
                logWarning("passportNumber", this.passportNumber);
                return false;
            }
        }
        if (this.passportPlace != null) {
            if (this.passportPlace.equals(uiData.passportPlace) != shouldContain) {
                logWarning("passportPlace", this.passportPlace);
                return false;
            }
        }
        if (this.passportExpDate != null) {
            if (this.passportExpDate.equals(uiData.passportExpDate) != shouldContain) {
                logWarning("passportExpDate", this.passportExpDate);
                return false;
            }
        }
        if (this.hasVisa != null) {
            if (this.hasVisa.equals(uiData.hasVisa) != shouldContain) {
                logWarning("hasVisa", this.hasVisa);
                return false;
            }
        }
        if (this.visaType != null) {
            if (this.visaType.equals(uiData.visaType) != shouldContain) {
                logWarning("nationalOrForeign", this.nationalOrForeign);
                return false;
            }
        }
        if (this.visaExpDate != null) {
            if (this.visaExpDate.equals(uiData.visaExpDate) != shouldContain) {
                logWarning("visaExpDate", this.visaExpDate);
                return false;
            }
        }
        if (this.hasDriverLicense != null) {
            if (this.hasDriverLicense.equals(uiData.hasDriverLicense) != shouldContain) {
                logWarning("hasDriverLicense", this.hasDriverLicense);
                return false;
            }
        }
        if (this.motorcycleLicenceEXP != null) {
            if (this.motorcycleLicenceEXP.equals(uiData.motorcycleLicence) != shouldContain) {
                logWarning("motorcycleLicence", this.motorcycleLicence);
                return false;
            }
        }
        if (this.motorcycleLicenceEXP != null) {
            if (this.motorcycleLicenceEXP.equals(uiData.motorcycleLicenceEXP) != shouldContain) {
                logWarning("motorcycleLicenceEXP", this.motorcycleLicenceEXP);
                return false;
            }
        }
        if (this.carLicence != null) {
            if (this.carLicence.equals(uiData.carLicence) != shouldContain) {
                logWarning("carLicence", this.carLicence);
                return false;
            }
        }
        if (this.bloodType != null) {
            if (this.bloodType.equals(uiData.bloodType) != shouldContain) {
                logWarning("bloodType", this.bloodType);
                return false;
            }
        }
        if (this.homeAddress !=  null) {
            if (this.homeAddress.equals(uiData.homeAddress) != shouldContain) {
                logWarning("homeAddress", this.homeAddress);
                return false;
            }
        }
        if (this.homeAddressDescription != null) {
            if (this.homeAddressDescription.equals(uiData.homeAddressDescription) != shouldContain) {
                logWarning("homeAddressDescription", this.homeAddressDescription);
                return false;
            }
        }
        if (this.dateBirth != null) {
            if (this.dateBirth.equals(uiData.dateBirth) != shouldContain) {
                logWarning("dateBirth", this.dateBirth);
                return false;
            }
        }
        if (this.age != null) {
            if (this.age.equals(uiData.age) != shouldContain) {
                logWarning("age", this.age);
                return false;
            }
        }
        if (this.country != null) {
            if (this.country.equals(uiData.country) != shouldContain) {
                logWarning("country", this.country);
                return false;
            }
        }
        if (this.city != null) {
            if (this.city.equals(uiData.city) != shouldContain) {
                logWarning("city", this.city);
                return false;
            }
        }
        return true;
    }
}
