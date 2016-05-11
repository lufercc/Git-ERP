package com.jalasoft.automation.erp.portal.ui.pages.selog.purchase;

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

    public InteriorFormButtonsBar() {}
    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.container);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.container);
    }

    public void clickButton(String buttonString) {
        switch (buttonString.toLowerCase()) {
        case "internal moves":
            internalMoves.click();
            break;
        }
    }
}
