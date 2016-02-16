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

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_form_field_selection')])[5]")
    protected WebElement gender;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_form_field_selection')])[6]")
    protected WebElement maritalStatus;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_form_field_char')]/span)[19]")
    protected WebElement numberChildren;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_datepicker_root oe_form_field_date')])[6]")
    protected WebElement startDate;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_datepicker_root oe_form_field_date')])[7]")
    protected WebElement endDate;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_datepicker_root oe_form_field_date')])[8]")
    protected WebElement hireDate;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_datepicker_root oe_form_field_date')])[9]")
    protected WebElement endHireDate;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_form_field_selection')])[7]")
    protected WebElement salaryReviewMonth;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_form_field_many2one oe_form_field_with_button oe_inline')]/span)[1]")
    protected WebElement workingSchedule;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_form_field_many2one oe_form_field_with_button oe_inline')]/span)[3]")
    protected WebElement holidayGroup;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_datepicker_root oe_form_field_date')])[5]")
    protected WebElement vacationAnniversary;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_form_field_char')]/span)[20]")
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

    public HHRRInfoEmployee getMainData() {
        HHRRInfoEmployee result = new HHRRInfoEmployee();

        result.gender = gender.getAttribute("innerHTML");
        result.maritalStatus = maritalStatus.getAttribute("innerHTML");
        result.numberChildren = numberChildren.getAttribute("innerHTML");
        result.startDate = startDate.getAttribute("innerHTML");
        result.endDate = endDate.getAttribute("innerHTML");
        result.hireDate = hireDate.getAttribute("innerHTML");
        result.endHireDate = endHireDate.getAttribute("innerHTML");
        result.salaryReviewMonth = salaryReviewMonth.getAttribute("innerHTML");
        result.workingSchedule = workingSchedule.getAttribute("innerHTML");
        result.holidayGroup = holidayGroup.getAttribute("innerHTML");
        result.vacationAnniversary = vacationAnniversary.getAttribute("innerHTML");
        result.internalID = internalID.getAttribute("innerHTML");

        return result;
    }

}
