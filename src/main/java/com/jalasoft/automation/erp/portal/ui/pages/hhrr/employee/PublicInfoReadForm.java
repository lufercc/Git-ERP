package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.PublicInfoEmployee;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class PublicInfoReadForm extends PortalUIElement {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_form_field_many2one oe_form_field_with_button')]/a)[0]")
    protected WebElement address;

    @FindBy(xpath = "//span[contains(@class,'oe_form_m2o_follow')]")
    protected WebElement addressDescription;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_char_content')])[9]")
    protected WebElement workEmail;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_char_content')])[10]")
    protected WebElement workPhone;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_char_content')])[11]")
    protected WebElement extCode;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_char_content')])[12]")
    protected WebElement workMobile;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_form_field_many2one oe_form_field_with_button')]/span)[6]")
    protected WebElement user;

    @FindBy(xpath = "//div[contains(@class,'oe_form_field oe_form_field_text')]/span")
    protected WebElement otherInfo;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_form_field_many2one oe_form_field_with_button')]/a)[2]")
    protected WebElement location;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_char_content')])[13]")
    protected WebElement codeDesktop;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_form_field_many2one oe_form_field_with_button')]/span)[3]")
    protected WebElement country;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_char_content')])[14]")
    protected WebElement city;

    public PublicInfoReadForm() {
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

    public PublicInfoEmployee getMainData() {
        PublicInfoEmployee result = new PublicInfoEmployee();

        result.addressDescription = addressDescription.getAttribute("innerHTML");
        result.workEmail = workEmail.getAttribute("innerHTML");
        result.workPhone = workPhone.getAttribute("innerHTML");
        result.extCode = extCode.getAttribute("innerHTML");
        result.workMobile = workMobile.getAttribute("innerHTML");
        result.user = user.getAttribute("innerHTML");
        result.otherInfo = otherInfo.getAttribute("innerHTML");
        result.location = location.getAttribute("innerHTML");
        result.codeDesktop = codeDesktop.getAttribute("innerHTML");
        result.country = country.getAttribute("innerHTML");
        result.city = city.getAttribute("innerHTML");

        return result;
    }

}
