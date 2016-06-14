package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.portal.ui.components.OdooPopupForm;
import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.objects.hhrr.employee.ExternalCareer;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class ExternalCareerForm extends OdooPopupForm {

    @FindBy(xpath = "//div[contains(@class,'modal-dialog')]//*[@name='name']")
    protected WebElement jobTitle;

    @FindBy(xpath = "//input[@name='start_date']")
    protected WebElement startDate;

    @FindBy(xpath = "//input[@name='end_date']")
    protected WebElement endDate;

    @FindBy(name = "employer")
    protected WebElement employer;

    @FindBy(name = "description")
    protected WebElement description;

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.jobTitle);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.jobTitle);
    }

    public void modifyData(OdooObject inputDataObj) {
        fieldsAffectedByAction = new ArrayList<>();
        fieldsNoAffectedByAction = new ArrayList<>();
        allFieldsAffected = true;

        ExternalCareer inputData = (ExternalCareer)inputDataObj;

        if (inputData.jobTitle != null) {
            setInput(jobTitle, "jobTitle", inputData.jobTitle);
        }

        if (inputData.startDate != null) {
            setInput(startDate, "startDate", inputData.startDate);
        }

        if (inputData.endDate != null) {
            setInput(endDate, "endDate", inputData.endDate);
        }

        if (inputData.employer != null) {
            setInput(employer, "employer", inputData.employer);
        }

        if (inputData.description != null) {
            setInput(description, "description", inputData.description);
        }

        logEditStatus(true);
    }

    public OdooObject getDataFromUI(OdooObject odooObject) {return null;}
}
