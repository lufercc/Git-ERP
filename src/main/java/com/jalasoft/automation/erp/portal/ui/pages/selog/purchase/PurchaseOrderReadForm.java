package com.jalasoft.automation.erp.portal.ui.pages.selog.purchase;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.selog.purchase.PurchaseOrder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class PurchaseOrderReadForm extends PortalUIElement {

    @FindBy(xpath = "(//span/div/input)[1]")
    protected WebElement supplier;

    @FindBy(xpath = "//div[contains(@class,'oe_form_container')]//div[contains(@class,'oe_title')]//span/span")
    protected WebElement purchaseOrderID;

    @FindBy(name = "purchase_type")
    protected WebElement purchaseType;

    @FindBy(xpath = "//a[contains(text(),'Añadir un elemento')]")
    protected WebElement addItemPurchaseOrder;

    public PurchaseOrderReadForm() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.purchaseOrderID);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.purchaseOrderID);
    }

    public void modifyData(PurchaseOrder inputData) {
        if (inputData.supplier != null) {
            this.supplier.sendKeys(inputData.supplier);
        }
        if (inputData.purchaseType != null) {
            this.supplier.sendKeys(inputData.purchaseType);
        }
    }

    public void clickAddItemOrderLine() {
        addItemPurchaseOrder.click();
    }

    public String getData(String fieldString) {
        String result = null;
        switch (fieldString) {
        case "id":
            result = purchaseOrderID.getText();
        }
        return result;
    }

}
