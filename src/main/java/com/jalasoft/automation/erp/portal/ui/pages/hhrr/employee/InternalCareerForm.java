package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.portal.ui.components.OdooPopupForm;
import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.objects.hhrr.employee.InternalCareer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class InternalCareerForm extends OdooPopupForm {

    @FindBy(xpath = "//div[contains(@class,'modal-dialog')]//*[@name='department_id']")
    protected WebElement department;

    @FindBy(xpath = "//div[contains(@class,'modal-dialog')]//*[@name='name']")
    protected WebElement jobTitle;

    @FindBy(xpath = "//div[contains(@class,'modal-dialog')]//*[@name='manager_id']")
    protected WebElement manager;

    @FindBy(xpath = "//div[contains(@class,'modal-dialog')]//*[@name='lead_id']")
    protected WebElement lead;

    @FindBy(name = "employer")
    protected WebElement employer;

    @FindBy(xpath = "//input[@name='start_date']")
    protected WebElement startDate;

    @FindBy(xpath = "//input[@name='end_date']")
    protected WebElement endDate;

    @FindBy(name = "description")
    protected WebElement description;

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.department);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.department);
    }

    public void modifyData(OdooObject inputDataObj) {
        fieldsAffectedByAction = new ArrayList<>();
        fieldsNoAffectedByAction = new ArrayList<>();
        allFieldsAffected = true;

        InternalCareer inputData = (InternalCareer)inputDataObj;

        if (inputData.department != null) {
            selectOpenERPItem(department, "department", inputData.department);
        }

        if (inputData.jobTitle != null) {
            selectOpenERPItem(jobTitle, "jobTitle", inputData.jobTitle);
        }

        if (inputData.manager != null) {
            selectOpenERPItem(manager, "manager", inputData.manager);
        }

        if (inputData.lead != null) {
            selectOpenERPItem(lead, "lead", inputData.lead);
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
