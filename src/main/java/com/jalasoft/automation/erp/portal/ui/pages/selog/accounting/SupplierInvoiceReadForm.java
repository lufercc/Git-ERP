package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.components.FormReadMode;
import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.SupplierInvoice;
import com.jalasoft.automation.erp.portal.ui.custom.selog.purchase.PurchaseOrder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class SupplierInvoiceReadForm extends FormReadMode {

    @FindBy(xpath = "//div[contains(@class,'oe_form_container')]//div[contains(@class,'oe_title')]//span/span")
    protected WebElement supplierInvoiceID;

    @FindBy(xpath = "//label[contains(text(),'Subtotal')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/span")
    protected WebElement subtotal;
    @FindBy(xpath = "//table[contains(@class,'subtotal')]//label[contains(text(),'Tax')]/ancestor::td/following-sibling::td/span/span")
    protected WebElement tax;
    @FindBy(xpath = "//table[contains(@class,'subtotal')]//label[contains(text(),'Amount Not Subject To VAT')]/ancestor::td/following-sibling::td/span/span")
    protected WebElement amountNoVAT;
    @FindBy(xpath = "//table[contains(@class,'subtotal')]//label[contains(text(),'ICE')]/ancestor::td/following-sibling::td/span/span")
    protected WebElement ice;
    @FindBy(xpath = "//table[contains(@class,'subtotal')]//label[contains(text(),'Total')]/ancestor::td/following-sibling::td/span/span")
    protected WebElement total;
    @FindBy(xpath = "//table[contains(@class,'subtotal')]//label[contains(text(),'Balance')]/ancestor::td/following-sibling::td/span/span")
    protected WebElement balance;

    public SupplierInvoiceReadForm() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.subtotal);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.subtotal);
    }

    public SupplierInvoice getMainData() {
        SupplierInvoice result = new SupplierInvoice();
        result.code = supplierInvoiceID.getText();
        return result;
    }

    public SupplierInvoice getDataFromUI(SupplierInvoice infoFromStep) {
        fieldsWereRead = new ArrayList<>();
        fieldsWereNotRead = new ArrayList<>();
        allFieldsWereRead = true;

        SupplierInvoice result = new SupplierInvoice();

        if(infoFromStep.subtotal != null) {
            result.subtotal = getSpanValue(subtotal, "subtotal");
        }
        if(infoFromStep.tax != null) {
            result.tax = getSpanValue(tax, "tax");
        }
        if(infoFromStep.amountNoVAT != null) {
            result.amountNoVAT = getSpanValue(amountNoVAT, "amountNoVAT");
        }
        if(infoFromStep.ice != null) {
            result.ice = getSpanValue(ice, "ice");
        }
        if(infoFromStep.total != null) {
            result.total = getSpanValue(total, "total");
        }
        if(infoFromStep.balance != null) {
            result.balance = getSpanValue(balance, "balance");
        }
        logReadStatus();
        return result;
    }

}
