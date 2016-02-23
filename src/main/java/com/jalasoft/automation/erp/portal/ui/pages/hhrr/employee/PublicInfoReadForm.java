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

    @FindBy(xpath = "//label[contains(text(),'Dirección de trabajo')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/a")
    protected WebElement address;

    @FindBy(xpath = "//label[contains(text(),'Dirección de trabajo')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/span")
    protected WebElement addressDescription;

//    @FindBy(xpath = "(//span[contains(@class,'oe_form_char_content')])[9]")
    @FindBy(xpath = "//label[contains(text(),'Correo-e del trabajo')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/span")
    protected WebElement workEmail;

//    @FindBy(xpath = "(//span[contains(@class,'oe_form_char_content')])[10]")
    @FindBy(xpath = "//label[contains(text(),'Teléfono trabajo')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/span")
    protected WebElement workPhone;

//    @FindBy(xpath = "(//span[contains(@class,'oe_form_char_content')])[11]")
    @FindBy(xpath = "//label[contains(text(),'Código de extensión')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/span")
    protected WebElement extCode;

//    @FindBy(xpath = "(//span[contains(@class,'oe_form_char_content')])[12]")
    @FindBy(xpath = "//label[contains(text(),'Móvil del trabajo')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/span")
    protected WebElement workMobile;

    @FindBy(xpath = "//label[contains(text(),'Usuario OpenERP')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/span")
    protected WebElement user;

    @FindBy(xpath = "//div[contains(@class,'oe_form_field oe_form_field_text')]/span")
    protected WebElement otherInfo;

    @FindBy(xpath = "//label[contains(text(),'Ubicación')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/a")
    protected WebElement location;

//    @FindBy(xpath = "(//span[contains(@class,'oe_form_char_content')])[13]")
    @FindBy(xpath = "//label[contains(text(),'Código de escritorio')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/span")
    protected WebElement codeDesktop;

    @FindBy(xpath = "//label[contains(text(),'País')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/span")
    protected WebElement country;

//    @FindBy(xpath = "(//span[contains(@class,'oe_form_char_content')])[14]")
    @FindBy(xpath = "//label[contains(text(),'Ciudad')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/span")
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
