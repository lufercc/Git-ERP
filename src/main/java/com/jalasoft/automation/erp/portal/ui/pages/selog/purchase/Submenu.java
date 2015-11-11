package com.jalasoft.automation.erp.portal.ui.pages.selog.purchase;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/16/2015.
 */
public class Submenu extends PortalUIElement{
    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']")
    protected WebElement submenuContainer;

    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']/div[not(contains(@style,'display: none'))]//span[contains(text(),'Solicitudes de compra')]")
    protected WebElement purchaseRequisitions;

    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']//div[5]//span[contains(text(),'Solicitud de cotizaciones')]")
    protected WebElement requestForQuotations;

    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']/div[not(contains(@style,'display: none'))]//span[contains(text(),'Pedidos de compra')]")
    protected WebElement purchaseOrders;

    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']//div[5]//span[contains(text(),'Proveedores')]")
    protected WebElement suppliers;

    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']/div[not(contains(@style,'display: none'))]//span[contains(text(),'Albaranes de entrada')]")
    protected WebElement incomingShipments;

    public Submenu() {
        this.waitForLoading();
    }

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
