package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.components.SelectOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.EngInfoEmployee;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.HHRRInfoEmployee;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class EngInfoEditForm extends PortalUIElement {

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

    public void modifyData(EngInfoEmployee inputData) {

        if (inputData.department != null) {
            this.department.selectItem(inputData.department);
        }

        if (inputData.division != null) {
            this.division.selectItem(inputData.division);
        }

        if (inputData.jobTitle != null) {
            this.jobTitle.selectItem(inputData.jobTitle);
        }

        if (inputData.manager != null) {
            this.manager.selectItem(inputData.manager);
        }

        if (inputData.lead != null) {
            this.lead.selectItem(inputData.lead);
        }

        if (inputData.visible != null) {
            if (inputData.visible.equals("true")) {
                this.webDriverTools.checkBox(this.visible);
            }else {
                this.webDriverTools.unCheckBox(this.visible);
            }
        }

        if (inputData.billable != null) {
            if (inputData.billable.equals("true")) {
                this.webDriverTools.checkBox(this.billable);
            }else {
                this.webDriverTools.unCheckBox(this.billable);
            }
        }

        if (inputData.shadowCategory != null) {
            this.webDriverTools.selectOptionOfDropListElement(this.shadowCategory, inputData.shadowCategory);
        }

        if (inputData.notes != null) {
            this.webDriverTools.clearAndSendKeys(this.notes, inputData.notes);
        }

        if (inputData.commitment != null) {
            if (inputData.commitment.equals("true")) {
                this.webDriverTools.checkBox(this.commitment);
            }else {
                this.webDriverTools.unCheckBox(this.commitment);
            }
        }

        if (inputData.expDateCommit != null) {
            this.webDriverTools.clearAndSendKeys(this.expDateCommit, inputData.expDateCommit);
        }

        if (inputData.active != null) {
            if (inputData.active.equals("true")) {
                this.webDriverTools.checkBox(this.active);
            }else {
                this.webDriverTools.unCheckBox(this.active);
            }
        }

        if (inputData.consultant != null) {
            if (inputData.consultant.equals("true")) {
                this.webDriverTools.checkBox(this.consultant);
            }else {
                this.webDriverTools.unCheckBox(this.consultant);
            }
        }

        if (inputData.jce != null) {
            if (inputData.jce.equals("true")) {
                this.webDriverTools.checkBox(this.jce);
            }else {
                this.webDriverTools.unCheckBox(this.jce);
            }
        }

        if (inputData.reason != null) {
            this.webDriverTools.clearAndSendKeys(this.reason, inputData.reason);
        }

        if (inputData.lastEvalDate != null) {
            this.webDriverTools.clearAndSendKeys(this.lastEvalDate, inputData.lastEvalDate);
        }

        if (inputData.nextEvalDate != null) {
            this.webDriverTools.clearAndSendKeys(this.nextEvalDate, inputData.nextEvalDate);
        }
    }
}
