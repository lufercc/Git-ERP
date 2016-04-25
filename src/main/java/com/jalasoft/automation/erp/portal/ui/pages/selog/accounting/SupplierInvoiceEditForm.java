package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.components.FormEditMode;
import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.SupplierInvoice;
import com.jalasoft.automation.erp.portal.ui.custom.selog.purchase.PurchaseOrder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class SupplierInvoiceEditForm extends FormEditMode {

    @FindBy(xpath = "//label[contains(text(),'Supplier')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/div/input")
    protected WebElement supplier;

    @FindBy(xpath = "//label[contains(text(),'Purchase Tax Type')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/div/input")
    protected WebElement purchaseTaxType;

    @FindBy(xpath = "//label[contains(text(),'Fiscal Position')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/div/input")
    protected WebElement fiscalPosition;

    @FindBy(xpath = "//label[contains(text(),'Supplier Invoice Name')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement supplierInvoiceName;

    @FindBy(xpath = "//label[contains(text(),'Supplier TIN')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement tin;

    @FindBy(xpath = "//label[contains(text(),'Supplier Invoice Number')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement number;

    @FindBy(xpath = "//label[contains(text(),'Supplier Receipt Number')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement supplierReceiptNumber;

    @FindBy(xpath = "//label[contains(text(),'Authorization Number')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement authorizationNumber;

    @FindBy(xpath = "//label[contains(text(),'Control Code')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement controlCode;

    @FindBy(xpath = "//label[contains(text(),'Verification Total')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement verificationTotal;

    @FindBy(name = "date_invoice")
    protected WebElement invoiceDate;

    @FindBy(xpath = "//label[contains(text(),'Amount Not Subject To VAT')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement amountNoVAT;

    @FindBy(xpath = "//label[contains(text(),'ICE')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement ice;

    public SupplierInvoiceEditForm() {}

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.tin);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.tin);
    }

    public void modifyData(SupplierInvoice inputData) {
        fieldsWereEdited = new ArrayList<>();
        fieldsWereNotEdited = new ArrayList<>();
        allFieldsWereEdited = true;
        if (inputData.supplier != null) {
            webDriverTools.waitUntilElementPresentAndVisible(supplier);
            selectOpenERPItem(supplier, "supplier", inputData.supplier);
        }
        if (inputData.purchaseTaxType != null) {
            webDriverTools.waitUntilElementPresentAndVisible(purchaseTaxType);
            selectOpenERPItem(purchaseTaxType, "purchaseTaxType", inputData.purchaseTaxType);
        }
        if (inputData.tin != null) {
            webDriverTools.waitUntilElementPresentAndVisible(tin);
            setInput(tin,"tin",inputData.tin);
        }
        if (inputData.number != null) {
            webDriverTools.waitUntilElementPresentAndVisible(number);
            setInput(number, "number", inputData.number);
        }
        if (inputData.authorizationNumber != null) {
            webDriverTools.waitUntilElementPresentAndVisible(authorizationNumber);
            setInput(authorizationNumber, "authorizationNumber", inputData.authorizationNumber);
        }
        if (inputData.controlCode != null) {
            webDriverTools.waitUntilElementPresentAndVisible(controlCode);
            setInput(controlCode, "controlCode", inputData.controlCode);
        }
        if (inputData.verificationTotal != null) {
            webDriverTools.waitUntilElementPresentAndVisible(verificationTotal);
            setInput(verificationTotal, "verificationTotal", inputData.verificationTotal);
        }
        if (inputData.supplierReceiptNumber != null) {
            webDriverTools.waitUntilElementPresentAndVisible(supplierReceiptNumber);
            setInput(supplierReceiptNumber, "supplierReceiptNumber", inputData.supplierReceiptNumber);
        }
        if (inputData.invoiceDate != null) {
            webDriverTools.waitUntilElementPresentAndVisible(invoiceDate);
            setInput(invoiceDate, "invoiceDate", inputData.invoiceDate);
        }
        if (inputData.amountNoVAT != null) {
            webDriverTools.waitUntilElementPresentAndVisible(amountNoVAT);
            setInput(amountNoVAT, "amountNoVAT", inputData.amountNoVAT);
        }
        if (inputData.ice != null) {
            webDriverTools.waitUntilElementPresentAndVisible(ice);
            setInput(ice, "ice", inputData.ice);
        }

        logEditStatus();
    }

    public SupplierInvoice getDataFromUI(SupplierInvoice infoFromStep) {

        SupplierInvoice result = new SupplierInvoice();

        if(infoFromStep.supplierInvoiceName != null) {
            result.supplierInvoiceName = supplierInvoiceName.getAttribute("value").replace("<br>", "");
        }
        if(infoFromStep.tin != null) {
            result.tin = tin.getAttribute("value").replace("<br>", "");
        }

        if(infoFromStep.fiscalPosition != null) {
            result.fiscalPosition = fiscalPosition.getAttribute("value").replace("<br>", "");
        }
        return result;
    }

    public boolean areDisplayed(SupplierInvoice infoFromStep) {
        if(infoFromStep.tin != null) {
            if (!Boolean.valueOf(infoFromStep.tin).equals(webDriverTools.isElementDisplayed(tin))) {
                return false;
            }
        }
        if(infoFromStep.number != null) {
            if (!Boolean.valueOf(infoFromStep.number).equals(webDriverTools.isElementDisplayed(number))) {
                return false;
            }
        }
        if(infoFromStep.authorizationNumber != null) {
            if (!Boolean.valueOf(infoFromStep.authorizationNumber).equals(webDriverTools.isElementDisplayed(authorizationNumber))) {
                return false;
            }
        }
        if(infoFromStep.controlCode != null) {
            if (!Boolean.valueOf(infoFromStep.controlCode).equals(webDriverTools.isElementDisplayed(controlCode))) {
                return false;
            }
        }
        if(infoFromStep.supplierReceiptNumber != null) {
            if (!Boolean.valueOf(infoFromStep.supplierReceiptNumber).equals(webDriverTools.isElementDisplayed(supplierReceiptNumber))) {
                return false;
            }
        }
        return true;
    }
}
