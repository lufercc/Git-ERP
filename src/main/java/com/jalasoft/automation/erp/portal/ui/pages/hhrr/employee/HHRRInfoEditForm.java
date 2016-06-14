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

    @FindBy(name = "user_id")
    protected WebElement userSelect;

    @FindBy(name = "hire_date")
    protected WebElement hireDate;

    @FindBy(name = "hire_end_date")
    protected WebElement endHireDate;

    @FindBy(name = "salary_review_date")
    protected WebElement salaryReviewDate;

    @FindBy(name = "gender")
    protected WebElement gender;

    @FindBy(name = "marital")
    protected WebElement maritalStatus;

    @FindBy(name = "children_number")
    protected WebElement numberChildren;

    @FindBy(name = "internal_number")
    protected WebElement internalID;

    @FindBy(name = "working_schedule")
    protected WebElement workingScheduleSelect;

    @FindBy(name = "day_observance_group_id")
    protected WebElement holidayGroupSelect;

    @FindBy(name = "vacation_anniversary")
    protected WebElement vacationAnniversary;

    @FindBy(name = "vac_alloc_policy_ids")
    protected WebElement vacationAllocationPolicies;

    @FindBy(name = "internship_start_date")
    protected WebElement startDate;

    @FindBy(name = "internship_end_date")
    protected WebElement endDate;

    SelectOpenERP workingSchedule;
    SelectOpenERP holidayGroup;
    SelectOpenERP user;

    public HHRRInfoEditForm() {
        this.waitForLoading();
        workingSchedule = new SelectOpenERP(workingScheduleSelect);
        holidayGroup = new SelectOpenERP(holidayGroupSelect);
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

        HHRRInfoEmployee inputData = (HHRRInfoEmployee)inputDataObj;

        if (inputData.user != null) {
            selectOpenERPItem(this.user, "user", inputData.user);
        }

        if (inputData.hireDate != null) {
            setInput(this.hireDate, "hireDate", inputData.hireDate);
        }

        if (inputData.endHireDate != null) {
            setInput(this.endHireDate, "endHireDate", inputData.endHireDate);
        }

        if (inputData.salaryReviewDate != null) {
            setInput(this.salaryReviewDate, "salaryReviewDate", inputData.salaryReviewDate);
        }

        if (inputData.gender != null) {
            selectItem(this.gender, "gender", inputData.gender);
        }

        if (inputData.maritalStatus != null) {
            selectItem(this.maritalStatus, "maritalStatus", inputData.maritalStatus);
        }

        if (inputData.numberChildren != null) {
            setInput(this.numberChildren, "numberChildren", inputData.numberChildren);
        }

        if (inputData.internalID != null) {
            setInput(this.internalID, "internalID", inputData.internalID);
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

        if (inputData.vacationAllocationPolicies != null) {
            selectOpenERPItem(this.vacationAllocationPolicies, "vacationAllocationPolicies", inputData.vacationAllocationPolicies);
        }

        if (inputData.startDate != null) {
            setInput(this.startDate, "startDate", inputData.startDate);
        }

        if (inputData.endDate != null) {
            setInput(this.endDate, "endDate", inputData.endDate);
        }

       logEditStatus(true);
    }
}
