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

    @FindBy(xpath = "//label[contains(text(),'Working Address')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/a")
    protected WebElement address;

    @FindBy(xpath = "//label[contains(text(),'Working Address')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/span")
    protected WebElement addressDescription;

    @FindBy(xpath = "//label[contains(text(),'Work Email')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/span")
    protected WebElement workEmail;

    @FindBy(xpath = "//label[contains(text(),'Work Phone')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/span")
    protected WebElement workPhone;

    @FindBy(xpath = "//label[contains(text(),'Extension Code')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/span")
    protected WebElement extCode;

    @FindBy(xpath = "//label[contains(text(),'Work Mobile')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/span")
    protected WebElement workMobile;

    @FindBy(xpath = "//label[contains(text(),'Related User')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/span")
    protected WebElement user;

    @FindBy(xpath = "//div[contains(@class,'oe_form_field oe_form_field_text')]/span")
    protected WebElement otherInfo;

    @FindBy(xpath = "//label[contains(text(),'Location')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/a")
    protected WebElement location;

    @FindBy(xpath = "//label[contains(text(),'Desk Code')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/span")
    protected WebElement codeDesktop;

    @FindBy(xpath = "//label[contains(text(),'Country')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/span")
    protected WebElement country;

    @FindBy(xpath = "//label[contains(text(),'City')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/span")
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

    public PublicInfoEmployee getDataFromUI(PublicInfoEmployee infoFromStep) {
        PublicInfoEmployee result = new PublicInfoEmployee();
        if(infoFromStep.address != null) {result.address = address.getAttribute("innerHTML").replace("<br>","");}
        if(infoFromStep.addressDescription != null) {result.addressDescription = addressDescription.getAttribute("innerHTML");}
        if(infoFromStep.workEmail != null) {result.workEmail = workEmail.getAttribute("innerHTML");}
        if(infoFromStep.workPhone != null) {result.workPhone = workPhone.getAttribute("innerHTML");}
        if(infoFromStep.extCode != null) {result.extCode = extCode.getAttribute("innerHTML");}
        if(infoFromStep.workMobile != null) {result.workMobile = workMobile.getAttribute("innerHTML");}
        if(infoFromStep.user != null) {result.user = user.getAttribute("innerHTML");}
        if(infoFromStep.otherInfo != null) {result.otherInfo = otherInfo.getAttribute("innerHTML");}
        if(infoFromStep.location != null) {result.location = location.getAttribute("innerHTML");}
        if(infoFromStep.codeDesktop != null) {result.codeDesktop = codeDesktop.getAttribute("innerHTML");}
        if(infoFromStep.country != null) {result.country = country.getAttribute("innerHTML");}
        if(infoFromStep.city != null) {result.city = city.getAttribute("innerHTML");}

        return result;
    }

}
