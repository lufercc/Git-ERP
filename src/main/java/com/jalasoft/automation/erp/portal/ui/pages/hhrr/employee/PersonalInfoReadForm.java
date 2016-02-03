package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.PersonalInfoEmployee;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.PublicInfoEmployee;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class PersonalInfoReadForm extends PortalUIElement {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(xpath = "//span[contains(@class,'oe_form_field oe_form_field_selection oe_form_required')]")
    protected WebElement nationalOrForeign;

    @FindBy(xpath = "//span[contains(@class,'oe_form_field oe_form_field_char oe_field_child oe_form_required')]/span")
    protected WebElement idNumber;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_datepicker_root oe_form_field_date oe_field_child')])[1]")
    protected WebElement idExpDate;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_form_field_selection oe_field_child')])[2]")
    protected WebElement idPlace;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_form_field_char oe_form_required')]/span)[2]")
    protected WebElement passportNumber;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_form_field_many2one oe_form_field_with_button oe_form_required')]/a)[1]")
    protected WebElement passportPlace;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_datepicker_root oe_form_field_date oe_field_child')])[2]")
    protected WebElement passportExpDate;

    @FindBy(name = "has_visa")
    protected WebElement hasVisa;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_form_field_selection oe_field_child')])[3]")
    protected WebElement visaType;

    @FindBy(xpath = "(//span[contains(@class,'oe_datepicker_root oe_form_field_date')])[2]")
    protected WebElement visaExpDate;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_form_field_many2one oe_form_field_with_button')]/span)[11]")
    protected WebElement homeAddressDescription;

    @FindBy(xpath = "(//span[contains(@class,'oe_datepicker_root oe_form_field_date')])[4]")
    protected WebElement dateBirth;

    @FindBy(xpath = "//div[contains(@class,'oe_inline')]/div")
    protected WebElement age;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_form_field_many2one oe_form_field_with_button oe_form_required')]/a)[2]")
    protected WebElement country;

    @FindBy(xpath = "(//td[contains(@class,'oe_group_right')]//span[contains(@class,'oe_form_field oe_form_field_char')]/span)[4]")
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

    public PersonalInfoEmployee getMainData() {
        PersonalInfoEmployee result = new PersonalInfoEmployee();

        result.nationalOrForeign = nationalOrForeign.getAttribute("innerHTML");
        result.idNumber = idNumber.getAttribute("innerHTML");
        result.idExpDate = idExpDate.getAttribute("innerHTML");
        result.idPlace = idPlace.getAttribute("innerHTML");
        result.passportNumber = passportNumber.getAttribute("innerHTML");
        result.passportPlace = passportPlace.getAttribute("innerHTML");
        result.passportExpDate = passportExpDate.getAttribute("innerHTML");
        result.hasVisa = hasVisa.getAttribute("checked");
        result.visaType = visaType.getAttribute("innerHTML");
        result.visaExpDate = visaExpDate.getAttribute("innerHTML");
        result.homeAddressDescription = homeAddressDescription.getAttribute("innerHTML");
        result.dateBirth = dateBirth.getAttribute("innerHTML");
        result.age = age.getAttribute("innerHTML");
        result.country = country.getAttribute("innerHTML");
        result.city = city.getAttribute("innerHTML");

        return result;
    }

}
