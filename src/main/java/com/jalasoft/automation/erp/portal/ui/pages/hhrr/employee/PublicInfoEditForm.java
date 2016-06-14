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

    @FindBy(xpath = "//div//input[contains(@name,'address_id')]")
    protected WebElement addressSelect;

    @FindBy(name = "work_email")
    protected WebElement workEmail;

    @FindBy(name = "work_phone")
    protected WebElement workPhone;

    @FindBy(name = "extension_code")
    protected WebElement extCode;

    @FindBy(name = "mobile_phone")
    protected WebElement workMobile;

    @FindBy(name = "work_location")
    protected WebElement workLocation;

    @FindBy(name = "location_id")
    protected WebElement locationSelect;

    @FindBy(name = "country_localization_id")
    protected WebElement countrySelect;

    @FindBy(name = "city_localization")
    protected WebElement city;

    @FindBy(name = "notes")
    protected WebElement otherInfo;

    @FindBy(xpath = "//label[contains(text(),'Desk Code')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement codeDesktop;

    SelectOpenERP address;
    SelectOpenERP location;
    SelectOpenERP country;

    public PublicInfoEditForm() {
        this.waitForLoading();
        address = new SelectOpenERP(addressSelect);
        location = new SelectOpenERP(locationSelect);
        country = new SelectOpenERP(countrySelect);
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

        if (inputData.workLocation != null) {
            setInput(this.workLocation, "workLocation", inputData.workLocation);
        }

        if (inputData.location != null) {
            selectOpenERPItem(this.location, "location", inputData.location);
        }

        if (inputData.country != null) {
            selectOpenERPItem(this.country, "country", inputData.country);
        }

        if (inputData.otherInfo != null) {
            setInput(this.otherInfo, "otherInfo", inputData.otherInfo);
        }

        if (inputData.codeDesktop != null) {
            setInput(this.codeDesktop, "codeDesktop", inputData.codeDesktop);
        }

        if (inputData.city != null) {
            setInput(this.city, "city", inputData.city);
        }

        logEditStatus(true);
    }
}
