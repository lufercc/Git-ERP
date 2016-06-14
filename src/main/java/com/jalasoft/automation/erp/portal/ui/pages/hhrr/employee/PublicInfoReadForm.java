package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.portal.ui.components.FormReadMode;
import com.jalasoft.automation.erp.objects.hhrr.employee.PublicInfoEmployee;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class PublicInfoReadForm extends FormReadMode {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(name = "address_id")
    protected WebElement address;

    @FindBy(xpath = "//label[contains(text(),'Working Address')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/span")
    protected WebElement addressDescription;

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

    @FindBy(name = "notes")
    protected WebElement otherInfo;

    @FindBy(name = "location_id")
    protected WebElement location;

    @FindBy(name = "country_localization_id")
    protected WebElement country;

    @FindBy(name = "city_localization")
    protected WebElement city;

    @FindBy(xpath = "//label[contains(text(),'Desk Code')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/span")
    protected WebElement codeDesktop;

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

        fieldsWereRead = new ArrayList<>();
        fieldsWereNotRead = new ArrayList<>();
        allFieldsWereRead = true;

        PublicInfoEmployee result = new PublicInfoEmployee();
        if(infoFromStep.address != null) {result.address = getSpanValue(address, "address");}
        if(infoFromStep.addressDescription != null) {result.addressDescription = getSpanValue(address, "address");}
        if(infoFromStep.workEmail != null) {result.workEmail = getSpanValue(workEmail, "workEmail");}
        if(infoFromStep.workPhone != null) {result.workPhone = getSpanValue(workPhone, "workPhone");}
        if(infoFromStep.workLocation != null) {result.workLocation = getSpanValue(workLocation, "workLocation");}
        if(infoFromStep.extCode != null) {result.extCode = getSpanValue(extCode, "extCode");}
        if(infoFromStep.workMobile != null) {result.workMobile = getSpanValue(workMobile, "workMobile");}
        if(infoFromStep.otherInfo != null) {result.otherInfo = getSpanValue(otherInfo, "otherInfo");}
        if(infoFromStep.location != null) {result.location = getSpanValue(location, "location");}
        if(infoFromStep.codeDesktop != null) {result.codeDesktop = getSpanValue(codeDesktop, "codeDesktop");}
        if(infoFromStep.country != null) {result.country = getSpanValue(country, "country");}
        if(infoFromStep.city != null) {result.city = getSpanValue(city, "city");}
        logReadStatus();
        return result;
    }

    public PublicInfoEmployee getDataFromUI(OdooObject inputData) {

        fieldsWereRead = new ArrayList<>();
        fieldsWereNotRead = new ArrayList<>();
        allFieldsWereRead = true;
        PublicInfoEmployee infoFromStep = (PublicInfoEmployee)inputData;
        PublicInfoEmployee result = new PublicInfoEmployee();

        if(infoFromStep.address != null) {result.address = getSpanValue(address, "address");}
        if(infoFromStep.addressDescription != null) {result.addressDescription = getSpanValue(address, "address");}
        if(infoFromStep.workEmail != null) {result.workEmail = getSpanValue(workEmail, "workEmail");}
        if(infoFromStep.workPhone != null) {result.workPhone = getSpanValue(workPhone, "workPhone");}
        if(infoFromStep.extCode != null) {result.extCode = getSpanValue(extCode, "extCode");}
        if(infoFromStep.workMobile != null) {result.workMobile = getSpanValue(workMobile, "workMobile");}
        if(infoFromStep.workLocation != null) {result.workLocation = getSpanValue(workLocation, "workLocation");}
        if(infoFromStep.otherInfo != null) {result.otherInfo = getSpanValue(otherInfo, "otherInfo");}
        if(infoFromStep.location != null) {result.location = getSpanValue(location, "location");}
        if(infoFromStep.country != null) {result.country = getSpanValue(country, "country");}
        if(infoFromStep.city != null) {result.city = getSpanValue(city, "city");}

        if(infoFromStep.codeDesktop != null) {result.codeDesktop = getSpanValue(codeDesktop, "codeDesktop");}

        logReadStatus();
        return result;
    }
}
