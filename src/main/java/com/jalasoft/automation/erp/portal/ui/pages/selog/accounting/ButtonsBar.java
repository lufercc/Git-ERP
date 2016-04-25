package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/26/2015.
 */
public class ButtonsBar extends PortalUIElement {

    @FindBy(xpath = "//div[contains(@class,'oe_form_container')]//header")
    protected WebElement container;

    @FindBy(xpath = "//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Validate')]")
    protected WebElement validateButton;

    @FindBy(xpath = "//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Confirm Subclass')]")
    protected WebElement confirmSubclassButton;

    @FindBy(xpath = "//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Confirm Asset')]")
    protected WebElement confirmAssetButton;

    @FindBy(xpath = "//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Request Assignation')]")
    protected WebElement requestAssignationButton;

    @FindBy(xpath = "//header/button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Deliver')]")
    protected WebElement deliverButton;

    public ButtonsBar() {}

    @Override
    public boolean isLoaded() {
        return webDriverTools.isElementDisplayed(container);
    }

    @Override
    public void waitForLoading() {
        webDriverTools.waitUntilElementPresentAndVisible(container);
    }

    public void clickButton(String buttonString) {
        switch (buttonString.toLowerCase()) {
        case "validate":
            validateButton.click();
            break;

        case "confirm subclass":
            confirmSubclassButton.click();
            break;

        case "confirm asset":
            confirmAssetButton.click();
            break;

        case "request assignation":
            requestAssignationButton.click();
            break;

        case "deliver":
            deliverButton.click();
            break;

        default:
            throw new IllegalArgumentException("Case value '" + buttonString +
                                               "' for accounting buttons is not defined yet!!!");
        }

        this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
    }
}
