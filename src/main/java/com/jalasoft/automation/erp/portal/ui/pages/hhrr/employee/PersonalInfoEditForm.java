package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.components.SelectOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.PersonalInfoEmployee;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.PublicInfoEmployee;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class PersonalInfoEditForm extends PortalUIElement {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(xpath = "(//td[contains(@class,'oe_form_group_cell')]/span[contains(@class,'oe_form_field')and(not(contains(@class,'invisible')))]/input[@type='text'])[7]")
    protected WebElement idNumber;

    @FindBy(xpath = "(//td[contains(@class,'oe_form_group_cell')]/span[contains(@class,'oe_form_field')and(not(contains(@class,'invisible')))]/input[@type='text'])[8]")
    protected WebElement passportNumber;

    @FindBy(xpath = "(//td[contains(@class,'oe_form_group_cell')]/span[contains(@class,'oe_form_field')and(not(contains(@class,'invisible')))]/input[@type='text'])[9]")
    protected WebElement city;

    @FindBy(xpath = "(//td[contains(@class,'oe_form_group_cell')]/span[contains(@class,'oe_form_field_many2one')and(not(contains(@class,'invisible')))]/div/input)[5]")
    protected WebElement passportPlaceSelect;

    @FindBy(xpath = "(//td[contains(@class,'oe_form_group_cell')]/span[contains(@class,'oe_form_field_many2one')and(not(contains(@class,'invisible')))]/div/input)[6]")
    protected WebElement countrySelect;

    @FindBy(xpath = "(//td[contains(@class,'oe_form_group_cell')]/span[contains(@class,'oe_form_field_many2one')and(not(contains(@class,'invisible')))]/div/input)[7]")
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

    public void modifyData(PersonalInfoEmployee inputData) {
        if (inputData.nationalOrForeign != null) {
            this.webDriverTools.selectOptionOfDropListElement(this.nationalOrForeign, inputData.nationalOrForeign);
        }

        if (inputData.idNumber != null) {
            this.webDriverTools.clearAndSendKeys(this.idNumber, inputData.idNumber);
        }

        if (inputData.idExpDate != null) {
            this.webDriverTools.clearAndSendKeys(this.idExpDate, inputData.idExpDate);
        }

        if (inputData.idPlace != null) {
            this.webDriverTools.selectOptionOfDropListElement(this.idPlace, inputData.idPlace);
        }

        if (inputData.passportNumber != null) {
            this.webDriverTools.clearAndSendKeys(this.passportNumber, inputData.passportNumber);
        }

        if (inputData.passportPlace != null) {
            this.passportPlace.selectItem(inputData.passportPlace);
        }

        if (inputData.passportExpDate != null) {
            this.webDriverTools.clearAndSendKeys(this.passportExpDate, inputData.passportExpDate);
        }

        if (inputData.hasVisa != null) {
            if (inputData.hasVisa.equals("true")) {
                this.webDriverTools.checkBox(this.hasVisa);
            }else {
                this.webDriverTools.unCheckBox(this.hasVisa);
            }
        }

        if (inputData.visaType != null) {
            this.webDriverTools.selectOptionOfDropListElement(this.visaType, inputData.visaType);
        }

        if (inputData.visaExpDate != null) {
            this.webDriverTools.clearAndSendKeys(this.visaExpDate, inputData.visaExpDate);
        }

        if (inputData.dateBirth != null) {
            this.webDriverTools.clearAndSendKeys(this.dateBirth, inputData.dateBirth);
        }

        if (inputData.country != null) {
            this.country.selectItem(inputData.country);
        }

        if (inputData.city != null) {
            this.webDriverTools.clearAndSendKeys(this.city, inputData.city);
        }

        if (inputData.homeAddress != null) {
            this.homeAddress.selectItem(inputData.homeAddress);
        }


    }
}
