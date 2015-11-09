package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.SupplierInvoice;
import com.jalasoft.automation.erp.portal.ui.custom.selog.purchase.PurchaseOrder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class SupplierInvoiceReadForm extends PortalUIElement {

    @FindBy(xpath = "//div[contains(@class,'oe_form_container')]//div[contains(@class,'oe_title')]//span/span")
    protected WebElement supplierInvoiceID;

    public SupplierInvoiceReadForm() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.supplierInvoiceID);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.supplierInvoiceID);
    }

    public SupplierInvoice getMainData() {
        SupplierInvoice result = new SupplierInvoice();
        result.code = supplierInvoiceID.getText();
        return result;
    }

}
