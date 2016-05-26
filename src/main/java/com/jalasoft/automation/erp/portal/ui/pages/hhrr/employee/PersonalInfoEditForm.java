package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.portal.ui.components.FormEditMode;
import com.jalasoft.automation.erp.portal.ui.components.SelectOpenERP;
import com.jalasoft.automation.erp.objects.hhrr.employee.PersonalInfoEmployee;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class PersonalInfoEditForm extends FormEditMode {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(xpath = "//label[contains(text(),'ID Number')]/ancestor::td/following-sibling::td/span/input")
    protected WebElement idNumber;

    @FindBy(xpath = "//label[contains(text(),'Passport No')]/ancestor::td/following-sibling::td/span/input")
    protected WebElement passportNumber;

    @FindBy(xpath = "//label[contains(text(),'City of Birth')]/ancestor::td/following-sibling::td/span/input")
    protected WebElement city;

    @FindBy(xpath = "//label[contains(text(),'Passport Issued')]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement passportPlaceSelect;

    @FindBy(xpath = "//label[contains(text(),'Age')]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement age;

    @FindBy(xpath = "//label[contains(text(),'Country of Birth')]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement countrySelect;

    @FindBy(xpath = "//label[contains(text(),'Home Address')]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement homeAddressSelect;

    @FindBy(name = "identification_type")
    protected WebElement nationalOrForeign;

    @FindBy(name = "identification_poi")
    protected WebElement idPlace;

    @FindBy(name = "id_expiration")
    protected WebElement idExpDate;

    @FindBy(name = "passport_exp_date")
    protected WebElement passportExpDate;

    @FindBy(name = "has_visa")
    protected WebElement hasVisa;

    @FindBy(name = "type_of_visa_id")
    protected WebElement visaType;

    @FindBy(name = "visa_expiration")
    protected WebElement visaExpDate;

    @FindBy(name = "birthday")
    protected WebElement dateBirth;

    SelectOpenERP passportPlace;
    SelectOpenERP country;
    SelectOpenERP homeAddress;

    public PersonalInfoEditForm() {
        this.waitForLoading();
        passportPlace = new SelectOpenERP(passportPlaceSelect);
        country = new SelectOpenERP(countrySelect);
        homeAddress = new SelectOpenERP(homeAddressSelect);
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.dataContainer);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.dataContainer);
    }

    public void modifyData(OdooObject inputDataObj) {
        fieldsAffectedByAction = new ArrayList<>();
        fieldsNoAffectedByAction = new ArrayList<>();
        allFieldsAffected = true;

        PersonalInfoEmployee inputData = (PersonalInfoEmployee)inputDataObj;

        if (inputData.nationalOrForeign != null) {
            selectItem(this.nationalOrForeign, "nationalOrForeign", inputData.nationalOrForeign);
        }

        if (inputData.idNumber != null) {
            setInput(this.idNumber, "idNumber", inputData.idNumber);
        }

        if (inputData.idExpDate != null) {
            setInput(this.idExpDate, "idExpDate", inputData.idExpDate);
        }

        if (inputData.idPlace != null) {
            selectItem(this.idPlace, "idPlace", inputData.idPlace);
        }

        if (inputData.passportNumber != null) {
            setInput(this.passportNumber, "passportNumber", inputData.passportNumber);
        }

        if (inputData.passportPlace != null) {
            selectOpenERPItem(this.passportPlace, "passportPlace", inputData.passportPlace);
        }

        if (inputData.passportExpDate != null) {
            setInput(this.passportExpDate, "passportExpDate", inputData.passportExpDate);
        }

        if (inputData.hasVisa != null) {
            setCheckbox(this.hasVisa, "hasVisa", inputData.hasVisa);
        }

        if (inputData.visaType != null) {
            selectItem(this.visaType, "visaType", inputData.visaType);
        }

        if (inputData.visaExpDate != null) {
            setInput(this.visaExpDate, "visaExpDate", inputData.visaExpDate);
        }

        if (inputData.dateBirth != null) {
            setInput(this.dateBirth, "dateBirth", inputData.dateBirth);
        }

        if (inputData.age != null) {
            setInput(this.age, "age", inputData.age);
        }

        if (inputData.country != null) {
            selectOpenERPItem(this.country, "country", inputData.country);
        }

        if (inputData.city != null) {
            setInput(this.city, "city", inputData.city);
        }

        if (inputData.homeAddress != null) {
            selectOpenERPItem(this.homeAddress, "homeAddress", inputData.homeAddress);
        }

        logEditStatus();
    }
}
