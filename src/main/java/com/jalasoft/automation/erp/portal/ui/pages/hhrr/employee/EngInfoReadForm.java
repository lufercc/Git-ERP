package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.FormReadMode;
import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.EngInfoEmployee;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class EngInfoReadForm extends FormReadMode {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(xpath = "//label[contains(text(),'Department')]/ancestor::td/following-sibling::td/span/a | " +
                    "//label[contains(text(),'Department')]/ancestor::td/following-sibling::td/span/span")
    protected WebElement department;

    @FindBy(xpath = "//label[contains(text(),'Division')]/ancestor::td/following-sibling::td/span/a | " +
                    "//label[contains(text(),'Division')]/ancestor::td/following-sibling::td/span/span")
    protected WebElement division;

    @FindBy(xpath = "//label[contains(text(),'Job Title')]/ancestor::td/following-sibling::td/span/span[contains(@class,'uri')]")
    protected WebElement jobTitle;

    @FindBy(xpath = "//label[contains(text(),'Manager')]/ancestor::td/following-sibling::td/span/span[contains(@class,'uri')]")
    protected WebElement manager;

    @FindBy(xpath = "//label[contains(text(),'Lead')]/ancestor::td/following-sibling::td/span/span[contains(@class,'uri')]")
    protected WebElement lead;

    @FindBy(name = "visible")
    protected WebElement visible;

    @FindBy(name = "billable")
    protected WebElement billable;

    @FindBy(xpath = "//label[contains(text(),'Shadow Category')]/ancestor::td/following-sibling::td/span")
    protected WebElement shadowCategory;

    @FindBy(xpath = "//label[contains(text(),'Notes')]/ancestor::td/following-sibling::td/div/span")
    protected WebElement notes;

    @FindBy(name = "found_commitment")
    protected WebElement commitment;

    @FindBy(xpath = "//label[contains(text(),'  Expiration Date')]/ancestor::td/following-sibling::td/span")
    protected WebElement expDateCommit;

    @FindBy(name = "active")
    protected WebElement active;

    @FindBy(name = "consultant")
    protected WebElement consultant;

    @FindBy(name = "jala_core_engineer")
    protected WebElement jce;

    @FindBy(xpath = "//label[contains(text(),'Reason')]/ancestor::td/following-sibling::td/div/span")
    protected WebElement reason;

    @FindBy(xpath = "//label[contains(text(),'Last 360 Date')]/ancestor::td/following-sibling::td/span")
    protected WebElement lastEvalDate;

    @FindBy(xpath = "//label[contains(text(),'Next 360 Date')]/ancestor::td/following-sibling::td/span")
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

    public EngInfoEmployee getDataFromUI(EngInfoEmployee infoFromStep) {
        fieldsWereRead = new ArrayList<>();
        fieldsWereNotRead = new ArrayList<>();
        allFieldsWereRead = true;

        EngInfoEmployee result = new EngInfoEmployee();

        if(infoFromStep.department != null) {
            result.department = getSpanValue(department, "department");
        }
        if(infoFromStep.division != null) {
            result.division = getSpanValue(division, "division");
        }
        if(infoFromStep.jobTitle != null) {
            result.jobTitle = getSpanValue(jobTitle, "jobTitle");
        }
        if(infoFromStep.manager != null) {
            result.manager = getSpanValue(manager, "manager");
        }
        if(infoFromStep.lead != null) {
            result.lead = getSpanValue(lead, "lead");
        }
        if(infoFromStep.visible != null) {
            result.visible = getCheckValue(visible, "visible");
        }
        if(infoFromStep.billable != null) {
            result.billable = getCheckValue(billable, "billable");
        }
        if(infoFromStep.shadowCategory != null) {
            result.shadowCategory = getSpanValue(shadowCategory, "shadowCategory");
        }
        if(infoFromStep.notes != null) {
            result.notes = getSpanValue(notes, "notes");
        }
        if(infoFromStep.commitment != null) {
            result.commitment = getCheckValue(commitment, "commitment");
        }
        if(infoFromStep.expDateCommit != null) {
            result.expDateCommit = getSpanValue(expDateCommit, "lastEvalDate");
        }
        if(infoFromStep.active != null) {
            result.active = getCheckValue(active, "active");
        }
        if(infoFromStep.consultant != null) {
            result.consultant = getCheckValue(consultant, "consultant");
        }
        if(infoFromStep.jce != null) {
            result.jce = getCheckValue(jce, "jce");
        }
        if(infoFromStep.reason != null) {
            result.reason = getSpanValue(reason, "reason");
        }
        if(infoFromStep.lastEvalDate != null) {
            result.lastEvalDate = getSpanValue(lastEvalDate, "lastEvalDate");
        }
        if(infoFromStep.nextEvalDate != null) {
            result.nextEvalDate = getSpanValue(nextEvalDate, "nextEvalDate");
        }
        logReadStatus();
        return result;
    }
}
