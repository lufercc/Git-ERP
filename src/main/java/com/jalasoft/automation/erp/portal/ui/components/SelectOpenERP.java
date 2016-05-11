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
        webDriverTools.clearAndSendKeys(control, value);
        WebElement suggestedValue = webDriver.findElement(By.xpath("//ul[contains(@style,'display: block')]/li[contains(@class,'ui-menu-item')]/a[text()='" + value + "']"));
        suggestedValue.click();
    }

    public void selectItemFromPartialItem(String value) {
        String partialValue = value.split(" ")[0];
        webDriverTools.clearAndSendKeys(control, partialValue);
        WebElement suggestedValue = webDriver.findElement(By.xpath("//ul[contains(@style,'display: block')]/li[contains(@class,'ui-menu-item')]/a[text()='" + value + "']"));
        suggestedValue.click();
    }

    @Override
    public boolean isLoaded() {
        return webDriverTools.isElementDisplayed(this.control);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.control);
    }
}
