package com.jalasoft.automation.erp.portal.ui.pages.selog.purchase;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.selog.purchase.PurchaseOrder;
import com.jalasoft.automation.erp.portal.ui.custom.selog.purchase.PurchaseRequisition;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class PurchaseOrderEditForm extends PortalUIElement {

    @FindBy(xpath = "//label[contains(text(),'Proveedor')]")
    protected WebElement supplierLabel;

    @FindBy(xpath = "(//span/div/input)[1]")
    protected WebElement supplier;

    @FindBy(name = "purchase_type")
    protected WebElement purchaseType;

    @FindBy(xpath = "//a[contains(text(),'Añadir un elemento')]")
    protected WebElement addItemPurchaseOrder;

    WebElement valueSelected;

    public PurchaseOrderEditForm() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.supplier);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.supplier);
    }

    public void modifyData(PurchaseOrder inputData) {
        if (inputData.supplier != null) {
            this.supplier.sendKeys(inputData.supplier);
            valueSelected = super.webDriver.findElement(By.linkText(inputData.supplier));
            valueSelected.click();
        }
        if (inputData.purchaseType != null) {
            this.supplier.sendKeys(inputData.purchaseType);
        }

    }

    public void clickAddItemOrderLine() {
        this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
        addItemPurchaseOrder.click();
    }
}
