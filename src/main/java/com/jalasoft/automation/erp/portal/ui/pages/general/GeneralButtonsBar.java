package com.jalasoft.automation.erp.portal.ui.pages.general;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class GeneralButtonsBar extends PortalUIElement {

    @FindBy(xpath = "//div[@class='oe_view_manager_buttons']")
    protected WebElement buttonsContainer;

    @FindBy(xpath = "//div[@class='oe_view_manager_buttons']//div[not(contains(@style,'display: none;'))]//button[contains(.,'Crear')]")
    protected WebElement createButton;

    @FindBy(xpath = "//div[@class='oe_view_manager_buttons']//div[not(contains(@style,'display: none;'))]//button[contains(.,'Guardar')]")
    protected WebElement saveButton;

    @FindBy(xpath = "//div[@class='oe_view_manager_buttons']//div[not(contains(@style,'display: none;'))]//button[contains(.,'Editar')]")
    protected WebElement editButton;

    public void clickButton(String buttonString) {
        switch (buttonString.toLowerCase()) {
        case "create":
            createButton.click();
            break;

        case "save":
            saveButton.click();
            break;

        case "edit":
            editButton.click();
            break;
        }
    }

    public GeneralButtonsBar() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.buttonsContainer);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.buttonsContainer);
    }

}
