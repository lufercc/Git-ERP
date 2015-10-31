package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.SupplierInvoice;
import com.jalasoft.automation.erp.portal.ui.custom.selog.purchase.PurchaseOrder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class SupplierInvoiceEditForm extends PortalUIElement {

    @FindBy(xpath = "(//table[contains(@class,'oe_form_group')]//input)[6]")
    protected WebElement tin;

    @FindBy(xpath = "(//table[contains(@class,'oe_form_group')]//input)[9]")
    protected WebElement number;

    @FindBy(xpath = "(//table[contains(@class,'oe_form_group')]//input)[10]")
    protected WebElement authorizationNumber;

    @FindBy(xpath = "(//table[contains(@class,'oe_form_group')]//input)[11]")
    protected WebElement controlCode;


    public SupplierInvoiceEditForm() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.tin);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.tin);
    }

    public void modifyData(SupplierInvoice inputData) {
        if (inputData.tin != null) {
            this.tin.sendKeys(inputData.tin);
        }
        if (inputData.number != null) {
            this.number.sendKeys(inputData.number);
        }
        if (inputData.authorizationNumber != null) {
            this.authorizationNumber.sendKeys(inputData.authorizationNumber);
        }
        if (inputData.controlCode != null) {
            this.controlCode.sendKeys(inputData.controlCode);
        }
    }
}
