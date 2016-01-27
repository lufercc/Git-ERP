package com.jalasoft.automation.erp.portal.ui.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Henry Benito on 1/12/2016.
 */
public class SelectOpenERP extends PortalUIElement {
    WebElement control;
    public SelectOpenERP(By by) {
        control = this.webDriver.findElement(by);
    }

    public SelectOpenERP(WebElement inputOpenERP) {
        control = inputOpenERP;
    }

    public void selectItem(String value) {
        control.sendKeys(value);
        WebElement suggestedValue = super.webDriver.findElement(By.linkText(value));
        suggestedValue.click();
    }
    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.control);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.control);
    }
}
