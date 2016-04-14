package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class ExtraGeneralButtonsBar extends PortalUIElement {

    @FindBy(xpath = "//div[@class='oe_view_manager_sidebar']")
    protected WebElement buttonsContainer;

    @FindBy(xpath = "//div[@class='oe_view_manager_sidebar']/div[not(contains(@style,'display: none;'))]//li/a[contains(.,'Create Delivery Record')]")
    protected WebElement createDeliveryRecordButton;

    public ExtraGeneralButtonsBar() {
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

    public void clickButton(String buttonString) {
        switch (buttonString.toLowerCase()) {
        case "create delivery record":
            createDeliveryRecordButton.click();
            break;
        }
    }
}
