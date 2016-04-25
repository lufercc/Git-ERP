package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.components.FormEditMode;
import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.Asset;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class AssetEditForm extends FormEditMode {

    @FindBy(xpath = "//input[@placeholder='Name']")
    protected WebElement name;

    @FindBy(xpath = "//input[@placeholder='Code']")
    protected WebElement code;

    @FindBy(name = "parent_image")
    protected WebElement parentImage;

    @FindBy(xpath = "//label[contains(text(),'Gross Value')]/ancestor::td/following-sibling::td/span/input")
    protected WebElement grossValue;

    @FindBy(xpath = "//label[contains(text(),'Parent')]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement parent;

    @FindBy(name = "type")
    protected WebElement hierarchyType;

    public AssetEditForm() {
        waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return webDriverTools.isElementDisplayed(parentImage);
    }

    @Override
    public void waitForLoading() {
        webDriverTools.waitUntilElementPresentAndVisible(parentImage);
    }

    public void modifyData(Asset inputData) throws InterruptedException {
        fieldsWereEdited = new ArrayList<>();
        fieldsWereNotEdited = new ArrayList<>();
        allFieldsWereEdited = true;
        if (inputData.hierarchyType != null) {
            selectItem(hierarchyType, "hierarchyType", inputData.hierarchyType);
            Thread.sleep(2000);
        }
        if (inputData.parent != null) {
            selectOpenERPItem(parent, "parent", inputData.parent);
        }
        if (inputData.grossValue != null) {
            setInput(grossValue, "grossValue", inputData.grossValue);
        }
        if (inputData.code != null) {
            setInput(code, "code", inputData.code);
        }
        if (inputData.name != null) {
            setInput(name, "name", inputData.name);
        }
        logEditStatus();
    }
}
