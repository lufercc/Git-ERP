package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.FormEditMode;
import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.BasicInfoEmployee;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class BasicInfoEditForm extends FormEditMode {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(name = "firstname_check")
    protected WebElement firstNameCheck;

    @FindBy(xpath = "//span[following-sibling::table//label[contains(text(),'Middle Name')] and preceding-sibling::table//label[contains(text(),'First Name')]]/input")
    protected WebElement firstName;

    @FindBy(name = "middlename_check")
    protected WebElement middleNameCheck;

    @FindBy(xpath = "//div[contains(@name,'prefered_div')]/input")
    protected WebElement preferredName;

    @FindBy(xpath = "//span[following-sibling::label[contains(text(),'Preferred Name')] and preceding-sibling::table//label[contains(text(),'Middle Name')]]/input")
    protected WebElement middleName;

    @FindBy(xpath = "//span[following-sibling::label[contains(text(),'Second Last Name')] and preceding-sibling::label[contains(text(),'Last Name')]]/input")
    protected WebElement lastName;

    @FindBy(xpath = "//span[following-sibling::label[contains(text(),'Married Name')] and preceding-sibling::label[contains(text(),'Second Last Name')]]/input")
    protected WebElement secondLastName;

    @FindBy(xpath = "//span[preceding-sibling::label[contains(text(),'Married Name')]]/input")
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
        fieldsWereEdited = new ArrayList<>();
        fieldsWereNotEdited = new ArrayList<>();
        allFieldsWereEdited = true;
        if (inputData.firstName != null) {
            setInput(this.firstName, "firstName", inputData.firstName);
        }

        if (inputData.firstNameCheck != null) {
            setCheckbox(this.firstNameCheck, "firstNameCheck", inputData.firstNameCheck);
        }

        if (inputData.middleName != null) {
            setInput(this.middleName, "middleName", inputData.middleName);
        }

        if (inputData.middleNameCheck != null) {
            setCheckbox(this.middleNameCheck, "middleNameCheck", inputData.middleNameCheck);
        }

        if (inputData.lastName != null) {
            setInput(this.lastName, "lastName", inputData.lastName);
        }

        if (inputData.secondLastName != null) {
            setInput(this.secondLastName, "secondLastName", inputData.secondLastName);
        }

        if (inputData.marriedName != null) {
            setInput(this.marriedName, "marriedName", inputData.marriedName);
        }

        if (inputData.preferredName != null) {
            setInput(this.preferredName, "preferredName", inputData.preferredName);
        }

        logEditStatus();
    }
}
