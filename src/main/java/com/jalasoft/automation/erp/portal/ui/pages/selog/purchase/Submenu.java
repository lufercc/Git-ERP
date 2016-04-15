package com.jalasoft.automation.erp.portal.ui.pages.selog.purchase;

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

    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']/div[not(contains(@style,'display: none'))]//span[contains(text(),'Purchase Requisitions')]")
    protected WebElement purchaseRequisitions;

    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']//div[5]//span[contains(text(),'Request for Quotations')]")
    protected WebElement requestForQuotations;

    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']/div[not(contains(@style,'display: none'))]//span[contains(text(),'Purchase Orders')]")
    protected WebElement purchaseOrders;

    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']//div[5]//span[contains(text(),'Suppliers')]")
    protected WebElement suppliers;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']/div[not(contains(@style,'display: none'))]//span[contains(text(),'Incoming Shipments')]")
    protected WebElement incomingShipments;

    public Submenu() {}

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.purchaseRequisitions);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.submenuContainer);
    }

    public void goToSubmenu(String submenu) {
        switch (submenu.toLowerCase()) {
        case "purchase requisitions":
            purchaseRequisitions.click();
            break;

        case "request for quotations":
            requestForQuotations.click();
            break;

        case "purchase orders":
            purchaseOrders.click();
            break;

        case "suppliers":
            suppliers.click();
            break;

        case "incoming shipments":
            incomingShipments.click();
            break;

        default:
            throw new IllegalArgumentException("Case value '" + submenu + "' for purchase submenu is not defined yet!!!");
        }
    }
}
