package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.objects.hhrr.employee.EmergencyContact;
import com.jalasoft.automation.erp.portal.ui.components.OdooPopupForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;


/**
 * Created by Henry Benito on 10/20/2015.
 */
public class EmergencyContactForm extends OdooPopupForm {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(name = "employee_id")
    protected WebElement employee;

    @FindBy(name = "relationship")
    protected WebElement relationship;

    @FindBy(xpath = "//div[contains(@class,'modal-dialog')]//*[@name='name']")
    protected WebElement name;

    @FindBy(name = "phone")
    protected WebElement phone;


    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.employee);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.employee);
    }

    public void modifyData(OdooObject inputDataObj) {
        fieldsAffectedByAction = new ArrayList<>();
        fieldsNoAffectedByAction = new ArrayList<>();
        allFieldsAffected = true;

        EmergencyContact inputData = (EmergencyContact)inputDataObj;

        if (inputData.employee != null) {
            selectOpenERPItem(employee, "employee", inputData.employee);
        }

        if (inputData.relationship != null) {
            setInput(this.relationship, "relationship", inputData.relationship);
        }

        if (inputData.name != null) {
            setInput(this.name, "name", inputData.name);
        }

        if (inputData.phone != null) {
            setInput(this.phone, "phone", inputData.phone);
        }

        logEditStatus(true);
    }

    public OdooObject getDataFromUI(OdooObject odooObject) {return null;}
}
