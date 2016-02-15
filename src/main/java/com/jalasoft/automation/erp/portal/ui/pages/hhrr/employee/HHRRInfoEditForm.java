package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.components.SelectOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.HHRRInfoEmployee;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.PersonalInfoEmployee;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class HHRRInfoEditForm extends PortalUIElement {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(xpath = "(//td[contains(@class,'oe_form_group_cell')]/span[contains(@class,'oe_form_field')and(not(contains(@class,'invisible')))]/input[@type='text'])[10]")
    protected WebElement numberChildren;

    @FindBy(xpath = "(//td[contains(@class,'oe_form_group_cell')]/span[contains(@class,'oe_form_field')and(not(contains(@class,'invisible')))]/input[@type='text'])[11]")
    protected WebElement internalID;

    @FindBy(xpath = "(//td[contains(@class,'oe_form_group_cell')]/span[contains(@class,'oe_form_field_many2one')and(not(contains(@class,'invisible')))]/div/input)[8]")
    protected WebElement workingScheduleSelect;

    @FindBy(xpath = "(//td[contains(@class,'oe_form_group_cell')]/span[contains(@class,'oe_form_field_many2one')and(not(contains(@class,'invisible')))]/div/input)[9]")
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

    public void modifyData(HHRRInfoEmployee inputData) {

        if (inputData.gender != null) {
            this.webDriverTools.selectOptionOfDropListElement(this.gender, inputData.gender);
        }

        if (inputData.maritalStatus != null) {
            this.webDriverTools.selectOptionOfDropListElement(this.maritalStatus, inputData.maritalStatus);
        }

        if (inputData.numberChildren != null) {
            this.webDriverTools.clearAndSendKeys(this.numberChildren, inputData.numberChildren);
        }

        if (inputData.startDate != null) {
            this.webDriverTools.clearAndSendKeys(this.startDate, inputData.startDate);
        }

        if (inputData.endDate != null) {
            this.webDriverTools.clearAndSendKeys(this.endDate, inputData.endDate);
        }

        if (inputData.hireDate != null) {
            this.webDriverTools.clearAndSendKeys(this.hireDate, inputData.hireDate);
        }

        if (inputData.endHireDate != null) {
            this.webDriverTools.clearAndSendKeys(this.endHireDate, inputData.endHireDate);
        }

        if (inputData.salaryReviewMonth != null) {
            this.webDriverTools.selectOptionOfDropListElement(this.salaryReviewMonth, inputData.salaryReviewMonth);
        }

        if (inputData.workingSchedule != null) {
            this.workingSchedule.selectItem(inputData.workingSchedule);
        }

        if (inputData.holidayGroup != null) {
            this.holidayGroup.selectItem(inputData.holidayGroup);
        }

        if (inputData.vacationAnniversary != null) {
            this.webDriverTools.clearAndSendKeys(this.vacationAnniversary, inputData.vacationAnniversary);
        }

        if (inputData.internalID != null) {
            this.webDriverTools.clearAndSendKeys(this.internalID, inputData.internalID);
        }
    }
}
