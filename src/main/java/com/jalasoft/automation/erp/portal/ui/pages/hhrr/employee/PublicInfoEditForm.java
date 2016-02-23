package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.components.SelectOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.BasicInfoEmployee;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.PublicInfoEmployee;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class PublicInfoEditForm extends PortalUIElement {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(xpath = "//label[contains(text(),'Correo-e del trabajo')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement workEmail;

    @FindBy(xpath = "//label[contains(text(),'Teléfono trabajo')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement workPhone;

    @FindBy(xpath = "//label[contains(text(),'Código de extensión')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement extCode;

    @FindBy(xpath = "//label[contains(text(),'Móvil del trabajo')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement workMobile;

    @FindBy(xpath = "//label[contains(text(),'Código de escritorio')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement codeDesktop;

    @FindBy(xpath = "//label[contains(text(),'Ciudad')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement city;

    @FindBy(xpath = "//label[contains(text(),'Dirección de trabajo')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/div/input")
    protected WebElement addressSelect;

    @FindBy(xpath = "//label[contains(text(),'Ubicación')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/div/input")
    protected WebElement locationSelect;

    @FindBy(xpath = "//label[contains(text(),'País')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/div/input")
    protected WebElement countrySelect;

    @FindBy(xpath = "//label[contains(text(),'Usuario OpenERP')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/div/input")
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
