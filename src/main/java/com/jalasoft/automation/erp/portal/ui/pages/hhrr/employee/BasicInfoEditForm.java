package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.BasicInfoEmployee;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class BasicInfoEditForm extends PortalUIElement {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(name = "firstname_check")
    protected WebElement firstNameCheck;

    @FindBy(xpath = "(//div[contains(@class,'oe_title')]//input[contains(@id,'oe-field-input')])[2]")
    protected WebElement firstName;

    @FindBy(name = "middlename_check")
    protected WebElement middleNameCheck;

    @FindBy(xpath = "(//div[contains(@class,'oe_title')]//input[contains(@id,'oe-field-input')])[4]")
    protected WebElement middleName;

    @FindBy(xpath = "(//div[contains(@class,'oe_title')]//input[contains(@id,'oe-field-input')])[6]")
    protected WebElement lastName;

    @FindBy(xpath = "(//div[contains(@class,'oe_title')]//input[contains(@id,'oe-field-input')])[7]")
    protected WebElement secondLastName;

    @FindBy(xpath = "(//div[contains(@class,'oe_title')]//input[contains(@id,'oe-field-input')])[8]")
    protected WebElement marriedName;

    public BasicInfoEditForm() {
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

    public void modifyData(BasicInfoEmployee inputData) {
        if (inputData.firstName != null) {
            this.webDriverTools.clearAndSendKeys(this.firstName, inputData.firstName);
        }

        if (inputData.firstNameCheck != null) {
            if (inputData.firstNameCheck.equals("true")) {
                this.webDriverTools.checkBox(this.firstNameCheck);
            }else {
                this.webDriverTools.unCheckBox(this.firstNameCheck);
            }
        }

        if (inputData.middleName != null) {
            this.webDriverTools.clearAndSendKeys(this.middleName, inputData.middleName);
        }

        if (inputData.middleNameCheck != null) {
            if (inputData.middleNameCheck.equals("true")) {
                this.webDriverTools.checkBox(this.middleNameCheck);
            }else {
                this.webDriverTools.unCheckBox(this.middleNameCheck);
            }
        }

        if (inputData.lastName != null) {
            this.webDriverTools.clearAndSendKeys(this.lastName, inputData.lastName);
        }

        if (inputData.secondLastName != null) {
            this.webDriverTools.clearAndSendKeys(this.secondLastName, inputData.secondLastName);
        }

        if (inputData.marriedName != null) {
            this.webDriverTools.clearAndSendKeys(this.marriedName, inputData.marriedName);
        }
    }
}
