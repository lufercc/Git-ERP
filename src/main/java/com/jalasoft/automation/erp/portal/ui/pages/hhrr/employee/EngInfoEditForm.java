package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.portal.ui.components.FormEditMode;
import com.jalasoft.automation.erp.portal.ui.components.SelectOpenERP;
import com.jalasoft.automation.erp.objects.hhrr.employee.EngInfoEmployee;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class EngInfoEditForm extends FormEditMode {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(xpath = "//label[contains(text(),'Department')]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement departmentSelect;

    @FindBy(xpath = "//label[contains(text(),'Division')]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement divisionSelect;

    @FindBy(xpath = "//label[contains(text(),'Job Title')]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement jobTitleSelect;

    @FindBy(xpath = "//label[contains(text(),'Manager')]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement managerSelect;

    @FindBy(xpath = "//label[contains(text(),'Lead')]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement leadSelect;

    @FindBy(name = "visible")
    protected WebElement visible;

    @FindBy(name = "billable")
    protected WebElement billable;

    @FindBy(name = "shadow_category")
    protected WebElement shadowCategory;

    @FindBy(name = "staffing_notes")
    protected WebElement notes;

    @FindBy(name = "found_commitment")
    protected WebElement commitment;

    @FindBy(name = "exp_date_commit")
    protected WebElement expDateCommit;

    @FindBy(name = "active")
    protected WebElement active;

    @FindBy(name = "consultant")
    protected WebElement consultant;

    @FindBy(name = "jala_core_engineer")
    protected WebElement jce;

    @FindBy(name = "jce_reason")
    protected WebElement reason;

    @FindBy(name = "last_360_evaluation")
    protected WebElement lastEvalDate;

    @FindBy(name = "next_360_evaluation")
    protected WebElement nextEvalDate;

    SelectOpenERP department;
    SelectOpenERP division;
    SelectOpenERP jobTitle;
    SelectOpenERP manager;
    SelectOpenERP lead;

    public EngInfoEditForm() {
        this.waitForLoading();
        department = new SelectOpenERP(departmentSelect);
        division = new SelectOpenERP(divisionSelect);
        jobTitle = new SelectOpenERP(jobTitleSelect);
        manager = new SelectOpenERP(managerSelect);
        lead = new SelectOpenERP(leadSelect);
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
        fieldsWereEdited = new ArrayList<>();
        fieldsWereNotEdited = new ArrayList<>();
        allFieldsWereEdited = true;
        EngInfoEmployee inputData = (EngInfoEmployee)inputDataObj;
        if (inputData.department != null) {
            selectOpenERPItem(this.department, "department", inputData.department);
        }

        if (inputData.division != null) {
            selectOpenERPItem(this.division, "division", inputData.division);
        }

        if (inputData.jobTitle != null) {
            selectOpenERPItem(this.jobTitle, "jobTitle", inputData.jobTitle);
        }

        if (inputData.manager != null) {
            selectOpenERPItem(this.manager, "manager", inputData.manager);
        }

        if (inputData.lead != null) {
            selectOpenERPItem(this.lead, "lead", inputData.lead);
        }

        if (inputData.visible != null) {
            setCheckbox(this.visible, "visible", inputData.visible);
        }

        if (inputData.billable != null) {
            setCheckbox(this.billable, "billable", inputData.billable);
        }

        if (inputData.shadowCategory != null) {
            selectItem(this.shadowCategory, "shadowCategory", inputData.shadowCategory);
        }

        if (inputData.notes != null) {
            setInput(this.notes, "notes", inputData.notes);
        }

        if (inputData.commitment != null) {
            setCheckbox(this.commitment, "commitment", inputData.commitment);
        }

        if (inputData.expDateCommit != null) {
            setInput(this.expDateCommit, "expDateCommit", inputData.expDateCommit);
        }

        if (inputData.active != null) {
            setCheckbox(this.active, "active", inputData.active);
        }

        if (inputData.consultant != null) {
            setCheckbox(this.consultant, "consultant", inputData.consultant);
        }

        if (inputData.jce != null) {
            setCheckbox(this.jce, "jce", inputData.jce);
        }

        if (inputData.reason != null) {
            setInput(this.reason, "reason", inputData.reason);
        }

        if (inputData.lastEvalDate != null) {
            setInput(this.lastEvalDate, "lastEvalDate", inputData.lastEvalDate);
        }

        if (inputData.nextEvalDate != null) {
            setInput(this.nextEvalDate, "nextEvalDate", inputData.nextEvalDate);
        }

        logEditStatus();
    }
}
