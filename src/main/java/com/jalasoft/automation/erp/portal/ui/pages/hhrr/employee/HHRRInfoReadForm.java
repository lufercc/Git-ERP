package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.FormReadMode;
import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.HHRRInfoEmployee;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class HHRRInfoReadForm extends FormReadMode {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(xpath = "//label[contains(text(),'Gender')]/ancestor::td/following-sibling::td/span")
    protected WebElement gender;

    @FindBy(xpath = "//label[contains(text(),'Marital Status')]/ancestor::td/following-sibling::td/span")
    protected WebElement maritalStatus;

    @FindBy(xpath = "//label[contains(text(),'Number of Children')]/ancestor::td/following-sibling::td/span/span")
    protected WebElement numberChildren;

    @FindBy(xpath = "//label[contains(text(),'Start Date')]/ancestor::td/following-sibling::td/span")
    protected WebElement startDate;

    @FindBy(xpath = "//label[contains(text(),'End Date') and ancestor::table/preceding-sibling::div[contains(text(),'Internship')]]/ancestor::td/following-sibling::td/span")
    protected WebElement endDate;

    @FindBy(xpath = "//label[contains(text(),'Hire Date')]/ancestor::td/following-sibling::td/span")
    protected WebElement hireDate;

    @FindBy(xpath = "//label[contains(text(),'Hire End Date')]/ancestor::td/following-sibling::td/span")
    protected WebElement endHireDate;

    @FindBy(xpath = "//label[contains(text(),'Salary Review Month')]/ancestor::td/following-sibling::td/span")
    protected WebElement salaryReviewMonth;

    @FindBy(xpath = "//label[contains(text(),'Working Schedule')]/ancestor::td/following-sibling::td/span/span[contains(@class,'uri')]")
    protected WebElement workingSchedule;

    @FindBy(xpath = "//label[contains(text(),'Holidays Group')]/ancestor::td/following-sibling::td/span/span[contains(@class,'uri')]")
    protected WebElement holidayGroup;

    @FindBy(xpath = "//label[contains(text(),'Vacation Anniversary')]/ancestor::td/following-sibling::td/span")
    protected WebElement vacationAnniversary;

    @FindBy(xpath = "//label[contains(text(),'Internal ID')]/ancestor::td/following-sibling::td/span/span")
    protected WebElement internalID;

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

    public HHRRInfoEmployee getDataFromUI(HHRRInfoEmployee infoFromStep) {
        fieldsWereRead = new ArrayList<>();
        fieldsWereNotRead = new ArrayList<>();
        allFieldsWereRead = true;

        HHRRInfoEmployee result = new HHRRInfoEmployee();

        if(infoFromStep.gender != null) {result.gender = getSpanValue(gender, "gender");}
        if(infoFromStep.maritalStatus != null) {result.maritalStatus = getSpanValue(maritalStatus, "maritalStatus");}
        if(infoFromStep.numberChildren != null) {result.numberChildren = getSpanValue(numberChildren, "numberChildren");}
        if(infoFromStep.startDate != null) {result.startDate = getSpanValue(startDate, "startDate");}
        if(infoFromStep.endDate != null) {result.endDate = getSpanValue(endDate, "endDate");}
        if(infoFromStep.hireDate != null) {result.hireDate = getSpanValue(hireDate, "hireDate");}
        if(infoFromStep.endHireDate != null) {result.endHireDate = getSpanValue(endHireDate, "endHireDate");}
        if(infoFromStep.salaryReviewMonth != null) {result.salaryReviewMonth = getSpanValue(salaryReviewMonth, "salaryReviewMonth");}
        if(infoFromStep.workingSchedule != null) {result.workingSchedule = getSpanValue(workingSchedule, "workingSchedule");}
        if(infoFromStep.holidayGroup != null) {result.holidayGroup = getSpanValue(holidayGroup, "holidayGroup");}
        if(infoFromStep.vacationAnniversary != null) {result.vacationAnniversary = getSpanValue(vacationAnniversary, "vacationAnniversary");}
        if(infoFromStep.internalID != null) {result.internalID = getSpanValue(internalID, "internalID");}
        logReadStatus();
        return result;
    }

}
