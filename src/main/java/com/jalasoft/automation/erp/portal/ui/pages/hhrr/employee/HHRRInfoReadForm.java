package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.HHRRInfoEmployee;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class HHRRInfoReadForm extends PortalUIElement {

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
        HHRRInfoEmployee result = new HHRRInfoEmployee();

        if(infoFromStep.gender != null) {result.gender = gender.getAttribute("innerHTML");}
        if(infoFromStep.maritalStatus != null) {result.maritalStatus = maritalStatus.getAttribute("innerHTML");}
        if(infoFromStep.numberChildren != null) {result.numberChildren = numberChildren.getAttribute("innerHTML");}
        if(infoFromStep.startDate != null) {result.startDate = startDate.getAttribute("innerHTML");}
        if(infoFromStep.endDate != null) {result.endDate = endDate.getAttribute("innerHTML");}
        if(infoFromStep.hireDate != null) {result.hireDate = hireDate.getAttribute("innerHTML");}
        if(infoFromStep.endHireDate != null) {result.endHireDate = endHireDate.getAttribute("innerHTML");}
        if(infoFromStep.salaryReviewMonth != null) {result.salaryReviewMonth = salaryReviewMonth.getAttribute("innerHTML");}
        if(infoFromStep.workingSchedule != null) {result.workingSchedule = workingSchedule.getAttribute("innerHTML");}
        if(infoFromStep.holidayGroup != null) {result.holidayGroup = holidayGroup.getAttribute("innerHTML");}
        if(infoFromStep.vacationAnniversary != null) {result.vacationAnniversary = vacationAnniversary.getAttribute("innerHTML");}
        if(infoFromStep.internalID != null) {result.internalID = internalID.getAttribute("innerHTML");}

        return result;
    }

}
