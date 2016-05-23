package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class EmployeeForm extends PortalUIElement {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(xpath = "//ul[contains(@role,'tablist')]/li/a[contains(text(),'Public Information')]")
    protected WebElement publicInfoTab;

    @FindBy(xpath = "//ul[contains(@role,'tablist')]/li/a[contains(text(),'Personal Information')]")
    protected WebElement personalInfoTab;

    @FindBy(xpath = "//ul[contains(@role,'tablist')]/li/a[contains(text(),'HR Settings')]")
    protected WebElement hhrrInfoTab;

    @FindBy(xpath = "//ul[contains(@role,'tablist')]/li/a[contains(text(),'Engineering')]")
    protected WebElement engineeringInfoTab;

    @FindBy(xpath = "(//div[contains(@class,'oe_clear ui-tabs')]//ul/li/a)[5]")
    protected WebElement empHistoryInfoTab;

    public EmployeeForm() {
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

    public void selectTab(String tab) {
        switch (tab.toLowerCase()) {
        case "basic":
            break;
        case "public":
            publicInfoTab.click();
            break;

        case "personal":
            personalInfoTab.click();
            break;

        case "hhrr":
            hhrrInfoTab.click();
            break;

        case "engineering":
            engineeringInfoTab.click();
            break;

        case "history":
            if (this.webDriverTools.isElementDisplayed(empHistoryInfoTab)) {
                empHistoryInfoTab.click();
                break;
            } else {
                throw new ElementNotVisibleException("The tab " + tab.toLowerCase() + " is not visible");
            }
        default:
            throw new IllegalArgumentException("Case value '" + tab + "' for tabs is not defined yet. Add it!!!");
        }
        this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
    }
}
