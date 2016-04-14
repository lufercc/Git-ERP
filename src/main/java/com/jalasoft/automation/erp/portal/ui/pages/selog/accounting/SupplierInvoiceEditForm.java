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

    @FindBy(xpath = "//label[contains(text(),'Supplier TIN')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement tin;

    @FindBy(xpath = "//label[contains(text(),'Supplier Invoice Number')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement number;

    @FindBy(xpath = "//label[contains(text(),'Authorization Number')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement authorizationNumber;

    @FindBy(xpath = "//label[contains(text(),'Control Code')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement controlCode;

    @FindBy(xpath = "//label[contains(text(),'Verification Total')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement verificationTotal;


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
        logEditStatus();
    }
}
