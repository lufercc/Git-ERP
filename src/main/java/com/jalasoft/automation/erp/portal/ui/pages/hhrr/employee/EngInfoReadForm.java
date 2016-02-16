package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.EngInfoEmployee;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class EngInfoReadForm extends PortalUIElement {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;


    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_form_field_many2one oe_form_field_with_button')]/a)[8]")
    protected WebElement department;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_form_field_many2one oe_form_field_with_button')]/a)[9]")
    protected WebElement division;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field_many2one oe_form_field_with_button')]/span[contains(@class,'oe_form_uri')])[5]")
    protected WebElement jobTitle;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field_many2one oe_form_field_with_button')]/span[contains(@class,'oe_form_uri')])[6]")
    protected WebElement manager;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field_many2one oe_form_field_with_button')]/span[contains(@class,'oe_form_uri')])[7]")
    protected WebElement lead;

    @FindBy(name = "visible")
    protected WebElement visible;

    @FindBy(name = "billable")
    protected WebElement billable;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_field oe_form_field_selection')])[8]")
    protected WebElement shadowCategory;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_text_content')])[2]")
    protected WebElement notes;

    @FindBy(name = "found_commitment")
    protected WebElement commitment;

    @FindBy(name = "active")
    protected WebElement active;

    @FindBy(name = "consultant")
    protected WebElement consultant;

    @FindBy(name = "jala_core_engineer")
    protected WebElement jce;

    @FindBy(xpath = "(//span[contains(@class,'oe_form_text_content')])[3]")
    protected WebElement reason;

    @FindBy(xpath = "(//span[contains(@class,'oe_datepicker_root oe_form_field_date')])[11]")
    protected WebElement lastEvalDate;

    @FindBy(xpath = "(//span[contains(@class,'oe_datepicker_root oe_form_field_date')])[12]")
    protected WebElement nextEvalDate;

    public EngInfoReadForm() {
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

    public EngInfoEmployee getMainData() {
        EngInfoEmployee result = new EngInfoEmployee();

        result.department = department.getAttribute("innerHTML");
        result.division = division.getAttribute("innerHTML");
        result.jobTitle = jobTitle.getAttribute("innerHTML");
        result.manager = manager.getAttribute("innerHTML");
        result.lead = lead.getAttribute("innerHTML");
        result.visible = visible.getAttribute("checked");
        result.billable = billable.getAttribute("checked");
        result.shadowCategory = shadowCategory.getAttribute("innerHTML");
        result.notes = notes.getAttribute("innerHTML");
        result.commitment = commitment.getAttribute("checked");
        result.active = active.getAttribute("checked");
        result.consultant = consultant.getAttribute("checked");
        result.jce = jce.getAttribute("checked");
        result.reason = reason.getAttribute("innerHTML");
        result.lastEvalDate = lastEvalDate.getAttribute("innerHTML");
        result.nextEvalDate = nextEvalDate.getAttribute("innerHTML");

        return result;
    }

}
