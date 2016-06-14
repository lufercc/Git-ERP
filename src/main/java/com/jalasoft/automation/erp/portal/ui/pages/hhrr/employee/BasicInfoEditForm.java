package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.portal.ui.components.FormEditMode;
import com.jalasoft.automation.erp.objects.hhrr.employee.BasicInfoEmployee;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class BasicInfoEditForm extends FormEditMode {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(xpath = "//div[@class='oe_title']/h1//input")
    protected WebElement fullName;

    @FindBy(name = "firstname_check")
    protected WebElement firstNameCheck;

    @FindBy(name = "firstname")
    protected WebElement firstName;

    @FindBy(name = "middlename_check")
    protected WebElement middleNameCheck;

    @FindBy(xpath = "//div[contains(@name,'prefered_div')]/input")
    protected WebElement preferredName;

    @FindBy(name = "middlename")
    protected WebElement middleName;

    @FindBy(name = "lastname")
    protected WebElement lastName;

    @FindBy(name = "second_lastname")
    protected WebElement secondLastName;

    @FindBy(name = "married_name")
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

    public void modifyData(OdooObject inputDataObj) {
        fieldsAffectedByAction = new ArrayList<>();
        fieldsNoAffectedByAction = new ArrayList<>();
        allFieldsAffected = true;

        BasicInfoEmployee inputData = (BasicInfoEmployee)inputDataObj;

        if (inputData.fullName != null) {
            setInput(fullName, "fullName", inputData.fullName);
        }

        if (inputData.firstName != null) {
            setInput(firstName, "firstName", inputData.firstName);
        }

        if (inputData.firstNameCheck != null) {
            webDriverTools.waitUntilInvisibilityOpenERPProgress();
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            setCheckbox(firstNameCheck, "firstNameCheck", inputData.firstNameCheck);
        }

        if (inputData.middleName != null) {
            setInput(middleName, "middleName", inputData.middleName);
        }

        if (inputData.middleNameCheck != null) {
            webDriverTools.waitUntilInvisibilityOpenERPProgress();
            setCheckbox(middleNameCheck, "middleNameCheck", inputData.middleNameCheck);
        }

        if (inputData.lastName != null) {
            setInput(lastName, "lastName", inputData.lastName);
        }

        if (inputData.secondLastName != null) {
            setInput(secondLastName, "secondLastName", inputData.secondLastName);
        }

        if (inputData.marriedName != null) {
            setInput(marriedName, "marriedName", inputData.marriedName);
        }

        if (inputData.preferredName != null) {
            setInput(preferredName, "preferredName", inputData.preferredName);
        }

        logEditStatus(true);
    }
}
