package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.portal.ui.components.FormReadMode;
import com.jalasoft.automation.erp.objects.hhrr.employee.PersonalInfoEmployee;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class PersonalInfoReadForm extends FormReadMode {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(name = "identification_type")
    protected WebElement nationalOrForeign;

    @FindBy(name = "identification_id")
    protected WebElement idNumber;

    @FindBy(name = "id_expiration")
    protected WebElement idExpDate;

    @FindBy(name = "identification_poi")
    protected WebElement idPlace;

    @FindBy(name = "passport_id")
    protected WebElement passportNumber;

    @FindBy(name = "passport_issued_id")
    protected WebElement passportPlace;

    @FindBy(name = "passport_exp_date")
    protected WebElement passportExpDate;

    @FindBy(name = "has_visa")
    protected WebElement hasVisa;

    @FindBy(name = "type_of_visa_id")
    protected WebElement visaType;

    @FindBy(name = "visa_expiration")
    protected WebElement visaExpDate;

    @FindBy(name = "has_driver_license")
    protected WebElement hasDriverLicense;

    @FindBy(xpath = "//input[@name='motorcycle_license']")
    protected WebElement motorcycleLicence;

    @FindBy(name = "motorcycle_exp_date")
    protected WebElement motorcycleLicenceEXP;

    @FindBy(name = "car_license")
    protected WebElement carLicence;

    @FindBy(name = "blood_type")
    protected WebElement bloodType;

    @FindBy(name = "birthday")
    protected WebElement dateBirth;

    @FindBy(name = "country_of_birth_id")
    protected WebElement country;

    @FindBy(name = "city_of_birth")
    protected WebElement city;

    @FindBy(name = "address_home_id")
    protected WebElement homeAddress;

    @FindBy(xpath = "//label[contains(text(),'Age')]/ancestor::td/following-sibling::td/div/div")
    protected WebElement age;

    @FindBy(xpath = "//label[contains(text(),'Home Address')]/ancestor::td/following-sibling::td/span/span")
    protected WebElement homeAddressDescription;

    public PersonalInfoReadForm() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.dataContainer);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.dataContainer);
    }

    public PersonalInfoEmployee getDataFromUI(OdooObject infoFromStepObj) {
        fieldsWereRead = new ArrayList<>();
        fieldsWereNotRead = new ArrayList<>();
        allFieldsWereRead = true;
        PersonalInfoEmployee infoFromStep = (PersonalInfoEmployee)infoFromStepObj;
        PersonalInfoEmployee result = new PersonalInfoEmployee();

        if(infoFromStep.nationalOrForeign != null) {
            result.nationalOrForeign = getSpanValue(nationalOrForeign, "nationalOrForeign");
        }
        if(infoFromStep.idNumber != null) {
            result.idNumber = getSpanValue(idNumber, "idNumber");
        }
        if(infoFromStep.idExpDate != null) {
            result.idExpDate = getSpanValue(idExpDate, "idExpDate");
        }
        if(infoFromStep.idPlace != null) {
            result.idPlace = getSpanValue(idPlace, "idPlace");
        }
        if(infoFromStep.passportNumber != null) {
            result.passportNumber = getSpanValue(passportNumber, "passportNumber");
        }
        if(infoFromStep.passportPlace != null) {
            result.passportPlace = getSpanValue(passportPlace, "passportPlace");
        }
        if(infoFromStep.passportExpDate != null) {
            result.passportExpDate = getSpanValue(passportExpDate, "passportExpDate");
        }
        if(infoFromStep.hasVisa != null) {
            result.hasVisa = getCheckValue(hasVisa, "hasVisa");
        }
        if(infoFromStep.visaType != null) {
            result.visaType = getSpanValue(visaType, "visaType");
        }
        if(infoFromStep.visaExpDate != null) {
            result.visaExpDate = getSpanValue(visaExpDate, "visaExpDate");
        }
        if(infoFromStep.hasDriverLicense != null) {
            result.hasDriverLicense = getCheckValue(hasDriverLicense, "hasDriverLicense");
        }
        if(infoFromStep.motorcycleLicence != null) {
            result.motorcycleLicence = getCheckValue(motorcycleLicence, "motorcycleLicence");
        }
        if(infoFromStep.motorcycleLicenceEXP != null) {
            result.motorcycleLicenceEXP = getSpanValue(motorcycleLicenceEXP, "motorcycleLicenceEXP");
        }
        if(infoFromStep.carLicence != null) {
            result.carLicence = getSpanValue(carLicence, "carLicence");
        }
        if(infoFromStep.bloodType != null) {
            result.bloodType = getSpanValue(bloodType, "bloodType");
        }
        if(infoFromStep.dateBirth != null) {
            result.dateBirth = getSpanValue(dateBirth, "dateBirth");
        }
        if(infoFromStep.country != null) {
            result.country = getSpanValue(country, "country");
        }
        if(infoFromStep.city != null) {
            result.city = getSpanValue(city, "city");
        }
        if(infoFromStep.homeAddress != null) {
            result.homeAddress = getSpanValue(homeAddress, "homeAddress");
        }
        if(infoFromStep.age != null) {
            result.age = getSpanValue(age, "age");
        }
        if(infoFromStep.homeAddressDescription != null) {
            result.homeAddressDescription = getSpanValue(homeAddressDescription, "homeAddressDescription");
        }

        logReadStatus();
        return result;
    }
}
