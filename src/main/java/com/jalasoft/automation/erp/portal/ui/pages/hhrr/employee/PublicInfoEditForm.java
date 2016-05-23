package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.portal.ui.components.FormEditMode;
import com.jalasoft.automation.erp.portal.ui.components.SelectOpenERP;
import com.jalasoft.automation.erp.objects.hhrr.employee.PublicInfoEmployee;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class PublicInfoEditForm extends FormEditMode {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(xpath = "//label[contains(text(),'Work Email')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/div/input")
    protected WebElement workEmail;

    @FindBy(xpath = "//label[contains(text(),'Work Phone')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement workPhone;

    @FindBy(xpath = "//label[contains(text(),'Extension Code')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement extCode;

    @FindBy(xpath = "//label[contains(text(),'Work Mobile')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement workMobile;

    @FindBy(xpath = "//label[contains(text(),'Desk Code')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement codeDesktop;

    @FindBy(xpath = "//label[contains(text(),'City')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement city;

    @FindBy(xpath = "//label[contains(text(),'Working Address')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/div/input")
    protected WebElement addressSelect;

    @FindBy(xpath = "//label[contains(text(),'Location')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/div/input")
    protected WebElement locationSelect;

    @FindBy(xpath = "//label[contains(text(),'Country')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/div/input")
    protected WebElement countrySelect;

    @FindBy(xpath = "//label[contains(text(),'Related User')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/div/input")
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

    public void modifyData(OdooObject inputDataObj) {
        fieldsAffectedByAction = new ArrayList<>();
        fieldsNoAffectedByAction = new ArrayList<>();
        allFieldsAffected = true;
        PublicInfoEmployee inputData = (PublicInfoEmployee)inputDataObj;

        if (inputData.address != null) {
            selectOpenERPItem(this.address, "address", inputData.address);
        }

        if (inputData.location != null) {
            selectOpenERPItem(this.location, "location", inputData.location);
        }

        if (inputData.country != null) {
            selectOpenERPItem(this.country, "country", inputData.country);
        }

        if (inputData.user != null) {
            selectOpenERPItem(this.user, "user", inputData.user);
        }

        if (inputData.workEmail != null) {
            setInput(this.workEmail, "workEmail", inputData.workEmail);
        }

        if (inputData.workPhone != null) {
            setInput(this.workPhone, "workPhone", inputData.workPhone);
        }

        if (inputData.extCode != null) {
            setInput(this.extCode, "extCode", inputData.extCode);
        }

        if (inputData.workMobile != null) {
            setInput(this.workMobile, "workMobile", inputData.workMobile);
        }

        if (inputData.codeDesktop != null) {
            setInput(this.codeDesktop, "codeDesktop", inputData.codeDesktop);
        }

        if (inputData.city != null) {
            setInput(this.city, "city", inputData.city);
        }

        if (inputData.otherInfo != null) {
            setInput(this.otherInfo, "otherInfo", inputData.otherInfo);
        }

        logEditStatus();
    }
}
