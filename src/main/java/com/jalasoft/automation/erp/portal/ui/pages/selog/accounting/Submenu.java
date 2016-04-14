package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/16/2015.
 */
public class Submenu extends PortalUIElement{

    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']")
    protected WebElement submenuContainer;

    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']/div[not(contains(@style,'display: none'))]//span[contains(text(),'Supplier Invoices')]")
    protected WebElement supplierInvoices;

    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']/div[not(contains(@style,'display: none'))]//span[contains(text(),'Assets')]")
    protected WebElement assets;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']/div[not(contains(@style,'display: none'))]//span[contains(text(),'Assets Assignation')]")
    protected WebElement assetsAssignation;

    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']/div[not(contains(@style,'display: none'))]//span[contains(text(),'Journal Entries')]")
    protected WebElement journalEntries;

    public Submenu() {
    }

    @Override
    public boolean isLoaded() {
        return webDriverTools.isElementDisplayed(supplierInvoices);
    }

    @Override
    public void waitForLoading() {
        webDriverTools.waitUntilElementPresentAndVisible(submenuContainer);
    }

    public void goToSubmenu(String submenu) {
        switch (submenu.toLowerCase()) {
            case "supplier invoices":
                supplierInvoices.click();
                break;

            case "assets":
                webDriverTools.waitUntilElementPresentAndVisible(assets);
                assets.click();
                break;

            case "assets assignation":
                webDriverTools.waitUntilElementPresentAndVisible(assetsAssignation);
                assetsAssignation.click();
                break;

            case "journal entries":
                journalEntries.click();
                break;

            default:
                throw new IllegalArgumentException("Case value '" + submenu + "' for accounting submenu is not defined yet!!!");
        }
        webDriverTools.waitUntilInvisibilityOpenERPProgress();
    }
}
