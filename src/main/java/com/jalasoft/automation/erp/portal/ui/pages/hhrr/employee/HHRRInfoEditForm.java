package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.portal.ui.components.FormEditMode;
import com.jalasoft.automation.erp.portal.ui.components.SelectOpenERP;
import com.jalasoft.automation.erp.objects.hhrr.employee.HHRRInfoEmployee;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class HHRRInfoEditForm extends FormEditMode {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(xpath = "//label[contains(text(),'Number of Children')]/ancestor::td/following-sibling::td/span/input")
    protected WebElement numberChildren;

    @FindBy(xpath = "//label[contains(text(),'Internal ID')]/ancestor::td/following-sibling::td/span/input")
    protected WebElement internalID;

    @FindBy(xpath = "//label[contains(text(),'Working Schedule')]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement workingScheduleSelect;

    @FindBy(xpath = "//label[contains(text(),'Holidays Group')]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement holidayGroupSelect;

    @FindBy(name = "gender")
    protected WebElement gender;

    @FindBy(name = "marital")
    protected WebElement maritalStatus;

    @FindBy(name = "internship_start_date")
    protected WebElement startDate;

    @FindBy(name = "internship_end_date")
    protected WebElement endDate;

    @FindBy(name = "hire_date")
    protected WebElement hireDate;

    @FindBy(name = "hire_end_date")
    protected WebElement endHireDate;

    @FindBy(name = "salary_review_month")
    protected WebElement salaryReviewMonth;

    @FindBy(name = "vacation_anniversary")
    protected WebElement vacationAnniversary;

    SelectOpenERP workingSchedule;
    SelectOpenERP holidayGroup;

    public HHRRInfoEditForm() {
        this.waitForLoading();
        workingSchedule = new SelectOpenERP(workingScheduleSelect);
        holidayGroup = new SelectOpenERP(holidayGroupSelect);
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

        HHRRInfoEmployee inputData = (HHRRInfoEmployee)inputDataObj;

        if (inputData.gender != null) {
            selectItem(this.gender, "gender", inputData.gender);
        }

        if (inputData.maritalStatus != null) {
            selectItem(this.maritalStatus, "maritalStatus", inputData.maritalStatus);
        }

        if (inputData.numberChildren != null) {
            setInput(this.numberChildren, "numberChildren", inputData.numberChildren);
        }

        if (inputData.startDate != null) {
            setInput(this.startDate, "startDate", inputData.startDate);
        }

        if (inputData.endDate != null) {
            setInput(this.endDate, "endDate", inputData.endDate);
        }

        if (inputData.hireDate != null) {
            setInput(this.hireDate, "hireDate", inputData.hireDate);
        }

        if (inputData.endHireDate != null) {
            setInput(this.endHireDate, "endHireDate", inputData.endHireDate);
        }

        if (inputData.salaryReviewMonth != null) {
            selectItem(this.salaryReviewMonth, "salaryReviewMonth", inputData.salaryReviewMonth);
        }

        if (inputData.workingSchedule != null) {
            selectOpenERPItem(this.workingSchedule, "workingSchedule", inputData.workingSchedule);
        }

        if (inputData.holidayGroup != null) {
            selectOpenERPItem(this.holidayGroup, "holidayGroup", inputData.holidayGroup);
        }

        if (inputData.vacationAnniversary != null) {
            setInput(this.vacationAnniversary, "vacationAnniversary", inputData.vacationAnniversary);
        }

        if (inputData.internalID != null) {
            setInput(this.internalID, "internalID", inputData.internalID);
        }

        logEditStatus();
    }
}
