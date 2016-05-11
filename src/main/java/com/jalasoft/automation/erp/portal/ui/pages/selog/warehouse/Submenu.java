package com.jalasoft.automation.erp.portal.ui.pages.selog.warehouse;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/16/2015.
 */
public class Submenu extends PortalUIElement{
    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']")
    protected WebElement submenuContainer;

    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']/div[not(contains(@style,'display: none'))]//span[contains(text(),'Internal Moves')]")
    protected WebElement internalMoves;

    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']/div[not(contains(@style,'display: none'))]//span[contains(text(),'Delivery Orders')]")
    protected WebElement deliveryOrders;

    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']/div[not(contains(@style,'display: none'))]//span[contains(text(),'Products') and not(contains(text(),'ICE') or contains(text(),'Category') or contains(text(),'Incoming') or contains(text(),'Deliver'))]")
    protected WebElement products;

    public Submenu() {
        waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return webDriverTools.isElementDisplayed(internalMoves);
    }

    @Override
    public void waitForLoading() {
        webDriverTools.waitUntilElementPresentAndVisible(submenuContainer);
    }

    public void goToSubmenu(String submenu) {
        switch (submenu.toLowerCase()) {
        case "internal moves":
            internalMoves.click();
            break;

        case "delivery orders":
            deliveryOrders.click();
            break;

        case "products":
            products.click();
            break;

    }
        webDriverTools.waitUntilInvisibilityOpenERPProgress();
    }
}
