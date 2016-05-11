package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/26/2015.
 */
public class InteriorFormButtonsBar extends PortalUIElement {

    @FindBy(xpath = "//div[contains(@class,'oe_right oe_button_box')]")
    protected WebElement container;

    @FindBy(xpath = "//div[contains(@class,'oe_right oe_button_box')]//button/span[contains(text(),'Internal Moves')]")
    protected WebElement internalMoves;

    @FindBy(xpath = "//div[contains(@class,'oe_right oe_button_box')]//button/span[contains(text(),'Delivery Records')]")
    protected WebElement deliveryRecords;

    public InteriorFormButtonsBar() {}
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
        case "internal moves":
            internalMoves.click();
            break;
        case "delivery records":
            deliveryRecords.click();
            break;
        }
    }
}
