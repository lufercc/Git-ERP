package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.FormReadMode;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.PersonalInfoEmployee;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class PersonalInfoReadForm extends FormReadMode {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(xpath = "//label[contains(text(),'National or Foreign?')]/ancestor::td/following-sibling::td/span")
    protected WebElement nationalOrForeign;

    @FindBy(xpath = "//label[contains(text(),'ID Number')]/ancestor::td/following-sibling::td/span/span")
    protected WebElement idNumber;

    @FindBy(xpath = "//label[contains(text(),'ID Number Expiration Date')]/ancestor::td/following-sibling::td/span")
    protected WebElement idExpDate;

    @FindBy(xpath = "//label[contains(text(),'ID Place of Issue')]/ancestor::td/following-sibling::td/span")
    protected WebElement idPlace;

    @FindBy(xpath = "//label[contains(text(),'Passport No')]/ancestor::td/following-sibling::td/span/span")
    protected WebElement passportNumber;

    @FindBy(xpath = "//label[contains(text(),'Passport Issued')]/ancestor::td/following-sibling::td/span/a")
    protected WebElement passportPlace;

    @FindBy(xpath = "//label[contains(text(),'Passport Expiration Date')]/ancestor::td/following-sibling::td/span")
    protected WebElement passportExpDate;

    @FindBy(name = "has_visa")
    protected WebElement hasVisa;

    @FindBy(xpath = "//label[contains(text(),'Type Of Visa')]/ancestor::td/following-sibling::td/span")
    protected WebElement visaType;

    @FindBy(xpath = "//label[contains(text(),'Visa Expiration Date')]/ancestor::td/following-sibling::td/span")
    protected WebElement visaExpDate;

    @FindBy(xpath = "//label[contains(text(),'Home Address')]/ancestor::td/following-sibling::td/span/a")
    protected WebElement homeAddress;

    @FindBy(xpath = "//label[contains(text(),'Home Address')]/ancestor::td/following-sibling::td/span/span")
    protected WebElement homeAddressDescription;

    @FindBy(xpath = "//label[contains(text(),'Date of Birth')]/ancestor::td/following-sibling::td/span")
    protected WebElement dateBirth;

    @FindBy(xpath = "//label[contains(text(),'Age')]/ancestor::td/following-sibling::td/div/div")
    protected WebElement age;

    @FindBy(xpath = "//label[contains(text(),'Country of Birth')]/ancestor::td/following-sibling::td/span/a")
    protected WebElement country;

    @FindBy(xpath = "//label[contains(text(),'City of Birth')]/ancestor::td/following-sibling::td/span/span")
    protected WebElement city;

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

    public PersonalInfoEmployee getDataFromUI(PersonalInfoEmployee infoFromStep) {
        fieldsWereRead = new ArrayList<>();
        fieldsWereNotRead = new ArrayList<>();
        allFieldsWereRead = true;

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
        if(infoFromStep.homeAddress != null) {
            result.homeAddress = getSpanValue(homeAddress, "homeAddress");
        }
        if(infoFromStep.homeAddressDescription != null) {
            result.homeAddressDescription = getSpanValue(homeAddressDescription, "homeAddressDescription");
        }
        if(infoFromStep.dateBirth != null) {
            result.dateBirth = getSpanValue(dateBirth, "dateBirth");
        }
        if(infoFromStep.age != null) {
            result.age = getSpanValue(age, "age");
        }
        if(infoFromStep.country != null) {
            result.country = getSpanValue(country, "country");
        }
        if(infoFromStep.city != null) {
            result.city = getSpanValue(city, "city");
        }
        logReadStatus();
        return result;
    }
}
