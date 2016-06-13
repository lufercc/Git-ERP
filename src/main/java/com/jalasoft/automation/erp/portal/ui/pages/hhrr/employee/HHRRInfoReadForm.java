package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.portal.ui.components.FormReadMode;
import com.jalasoft.automation.erp.objects.hhrr.employee.HHRRInfoEmployee;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class HHRRInfoReadForm extends FormReadMode {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(name = "user_id")
    protected WebElement user;

    @FindBy(name = "hire_date")
    protected WebElement hireDate;

    @FindBy(xpath = "//label[contains(text(),'Hire End Date')]/ancestor::td/following-sibling::td/span")
    protected WebElement endHireDate;

    @FindBy(name = "salary_review_date")
    protected WebElement salaryReviewMonth;

    @FindBy(name = "gender")
    protected WebElement gender;

    @FindBy(name = "marital")
    protected WebElement maritalStatus;

    @FindBy(name = "children_number")
    protected WebElement numberChildren;

    @FindBy(name = "internal_number")
    protected WebElement internalID;

    @FindBy(name = "working_schedule")
    protected WebElement workingSchedule;

    @FindBy(name = "day_observance_group_id")
    protected WebElement holidayGroup;

    @FindBy(name = "vacation_anniversary")
    protected WebElement vacationAnniversary;

    @FindBy(xpath = "//label[contains(text(),'Start Date')]/ancestor::td/following-sibling::td/span")
    protected WebElement startDate;

    @FindBy(xpath = "//label[contains(text(),'End Date') and ancestor::table/preceding-sibling::div[contains(text(),'Internship')]]/ancestor::td/following-sibling::td/span")
    protected WebElement endDate;

    public HHRRInfoReadForm() {
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

    public HHRRInfoEmployee getDataFromUI(OdooObject infoFromStepObj) {
        fieldsWereRead = new ArrayList<>();
        fieldsWereNotRead = new ArrayList<>();
        allFieldsWereRead = true;
        HHRRInfoEmployee infoFromStep = (HHRRInfoEmployee)infoFromStepObj;
        HHRRInfoEmployee result = new HHRRInfoEmployee();

        if(infoFromStep.user != null) {result.user = getSpanValue(user, "user");}
        if(infoFromStep.hireDate != null) {result.hireDate = getSpanValue(hireDate, "hireDate");}
        if(infoFromStep.endHireDate != null) {result.endHireDate = getSpanValue(endHireDate, "endHireDate");}
        if(infoFromStep.salaryReviewDate != null) {result.salaryReviewDate = getSpanValue(salaryReviewMonth, "salaryReviewDate");}
        if(infoFromStep.gender != null) {result.gender = getSpanValue(gender, "gender");}
        if(infoFromStep.maritalStatus != null) {result.maritalStatus = getSpanValue(maritalStatus, "maritalStatus");}
        if(infoFromStep.numberChildren != null) {result.numberChildren = getSpanValue(numberChildren, "numberChildren");}
        if(infoFromStep.internalID != null) {result.internalID = getSpanValue(internalID, "internalID");}
        if(infoFromStep.workingSchedule != null) {result.workingSchedule = getSpanValue(workingSchedule, "workingSchedule");}
        if(infoFromStep.holidayGroup != null) {result.holidayGroup = getSpanValue(holidayGroup, "holidayGroup");}
        if(infoFromStep.vacationAnniversary != null) {result.vacationAnniversary = getSpanValue(vacationAnniversary, "vacationAnniversary");}
        if(infoFromStep.startDate != null) {result.startDate = getSpanValue(startDate, "startDate");}
        if(infoFromStep.endDate != null) {result.endDate = getSpanValue(endDate, "endDate");}
        logReadStatus();
        return result;
    }

}
