package com.jalasoft.automation.erp.portal.ui.pages.selog.sales;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.selog.purchase.PurchaseOrder;
import com.jalasoft.automation.erp.portal.ui.custom.selog.sales.SaleOrder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class SaleOrderEditForm extends PortalUIElement {

    @FindBy(xpath = "(//table[contains(@class,'oe_form_group')]//input)[1]")
    protected WebElement client;

    @FindBy(xpath = "(//table[contains(@class,'oe_form_group')]//input)[2]")
    protected WebElement tin;

    @FindBy(name = "purchase_type")
    protected WebElement purchaseType;

    @FindBy(xpath = "//a[contains(text(),'Añadir un elemento')]")
    protected WebElement addItemPurchaseOrder;

    public SaleOrderEditForm() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.client);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.client);
    }

    public void modifyData(SaleOrder inputData) {
        if (inputData.client != null) {
            this.client.sendKeys(inputData.client);
            this.webDriverTools.pressKey("Enter");
        }
        if (inputData.tin != null) {
            this.tin.sendKeys(inputData.tin);
        }
    }

    public void clickAddItemOrderLine() {
        addItemPurchaseOrder.click();
    }
}
