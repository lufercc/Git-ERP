package com.jalasoft.automation.erp.portal.ui.pages.selog.purchase;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class CreateDraftInvoiceForm extends PortalUIElement {

    @FindBy(xpath = "//div[contains(@class,'ui-dialog-content')]//div[contains(@class,'oe_horizontal_separator')]")
    protected WebElement dialogTitle;

    @FindBy(name= "invoice_date")
    protected WebElement invoiceDate;

    @FindBy(xpath = "//div[contains(@class,'ui-dialog-buttonpane')]//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Crear')]")
    protected WebElement createButton;

    public CreateDraftInvoiceForm() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.dialogTitle);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.dialogTitle);
    }

    public void createInvoice() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("MM/dd/yyyy");//dd/MM/yyyy
        Date now = new Date();
        String strToday = sdfDate.format(now);
        invoiceDate.sendKeys(strToday);
        createButton.click();
    }
}
