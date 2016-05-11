package com.jalasoft.automation.erp.portal.ui.pages.selog.sales;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/16/2015.
 */
public class Submenu extends PortalUIElement{
    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']")
    protected WebElement submenuContainer;

    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']/div[not(contains(@style,'display: none'))]" +
                    "//span[contains(text(),'Sales Orders')]")
    protected WebElement salesOrders;

    public Submenu() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.salesOrders);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.submenuContainer);
    }

    public void goToSubmenu(String submenu) {
        switch (submenu.toLowerCase()) {
        case "sales orders":
            salesOrders.click();
            break;

        default:
            throw new IllegalArgumentException("Case value '" + submenu + "' for sales submenu is not defined yet!!!");
        }
        this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
    }
}
