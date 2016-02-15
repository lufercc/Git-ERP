package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.components.SelectOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.BasicInfoEmployee;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.PublicInfoEmployee;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class PublicInfoEditForm extends PortalUIElement {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(xpath = "(//td[contains(@class,'oe_form_group_cell')]/span[contains(@class,'oe_form_field')and(not(contains(@class,'invisible')))]/input[@type='text'])[1]")
    protected WebElement workEmail;

    @FindBy(xpath = "(//td[contains(@class,'oe_form_group_cell')]/span[contains(@class,'oe_form_field')and(not(contains(@class,'invisible')))]/input[@type='text'])[2]")
    protected WebElement workPhone;

    @FindBy(xpath = "(//td[contains(@class,'oe_form_group_cell')]/span[contains(@class,'oe_form_field')and(not(contains(@class,'invisible')))]/input[@type='text'])[3]")
    protected WebElement extCode;

    @FindBy(xpath = "(//td[contains(@class,'oe_form_group_cell')]/span[contains(@class,'oe_form_field')and(not(contains(@class,'invisible')))]/input[@type='text'])[4]")
    protected WebElement workMobile;

    @FindBy(xpath = "(//td[contains(@class,'oe_form_group_cell')]/span[contains(@class,'oe_form_field')and(not(contains(@class,'invisible')))]/input[@type='text'])[5]")
    protected WebElement codeDesktop;

    @FindBy(xpath = "(//td[contains(@class,'oe_form_group_cell')]/span[contains(@class,'oe_form_field')and(not(contains(@class,'invisible')))]/input[@type='text'])[6]")
    protected WebElement city;

    @FindBy(xpath = "(//td[contains(@class,'oe_form_group_cell')]/span[contains(@class,'oe_form_field_many2one')and(not(contains(@class,'invisible')))]/div/input)[1]")
    protected WebElement addressSelect;

    @FindBy(xpath = "(//td[contains(@class,'oe_form_group_cell')]/span[contains(@class,'oe_form_field_many2one')and(not(contains(@class,'invisible')))]/div/input)[2]")
    protected WebElement locationSelect;

    @FindBy(xpath = "(//td[contains(@class,'oe_form_group_cell')]/span[contains(@class,'oe_form_field_many2one')and(not(contains(@class,'invisible')))]/div/input)[3]")
    protected WebElement countrySelect;

    @FindBy(xpath = "(//td[contains(@class,'oe_form_group_cell')]/span[contains(@class,'oe_form_field_many2one')and(not(contains(@class,'invisible')))]/div/input)[4]")
    protected WebElement userSelect;

    @FindBy(name = "notes")
    protected WebElement otherInfo;

    SelectOpenERP address;
    SelectOpenERP location;
    SelectOpenERP country;
    SelectOpenERP user;

    public PublicInfoEditForm() {
        this.waitForLoading();
        address = new SelectOpenERP(addressSelect);
        location = new SelectOpenERP(locationSelect);
        country = new SelectOpenERP(countrySelect);
        user = new SelectOpenERP(userSelect);
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.dataContainer);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.dataContainer);
    }

    public void modifyData(PublicInfoEmployee inputData) {
        if (inputData.address != null) {
            this.address.selectItem(inputData.address);
        }

        if (inputData.location != null) {
            this.location.selectItem(inputData.location);
        }

        if (inputData.country != null) {
            this.country.selectItem(inputData.country);
        }

        if (inputData.user != null) {
            this.user.selectItem(inputData.user);
        }

        if (inputData.workEmail != null) {
            this.webDriverTools.clearAndSendKeys(this.workEmail, inputData.workEmail);
        }

        if (inputData.workPhone != null) {
            this.webDriverTools.clearAndSendKeys(this.workPhone, inputData.workPhone);
        }

        if (inputData.extCode != null) {
            this.webDriverTools.clearAndSendKeys(this.extCode, inputData.extCode);
        }

        if (inputData.workMobile != null) {
            this.webDriverTools.clearAndSendKeys(this.workMobile, inputData.workMobile);
        }

        if (inputData.codeDesktop != null) {
            this.webDriverTools.clearAndSendKeys(this.codeDesktop, inputData.codeDesktop);
        }

        if (inputData.city != null) {
            this.webDriverTools.clearAndSendKeys(this.city, inputData.city);
        }

        if (inputData.otherInfo != null) {
            this.webDriverTools.clearAndSendKeys(this.otherInfo, inputData.otherInfo);
        }
    }
}
