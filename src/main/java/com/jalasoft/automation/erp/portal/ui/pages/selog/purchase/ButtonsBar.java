package com.jalasoft.automation.erp.portal.ui.pages.selog.purchase;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/26/2015.
 */
public class ButtonsBar extends PortalUIElement {

    @FindBy(xpath = "//div[contains(@class,'oe_form_container')]//header")
    protected WebElement container;

    @FindBy(xpath = "//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Confirmar pedido')]")
    protected WebElement confirmButton;

    @FindBy(xpath = "//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Recibir')]")
    protected WebElement receiveButton;

    @FindBy(xpath = "//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Confirmar y transferir')]")
    protected WebElement confirmTransferButton;

    @FindBy(xpath = "//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Crear factura/abono')]")
    protected WebElement createInvoiceButton;

    public ButtonsBar() {}

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.container);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.container);
    }

    public void clickButton(String buttonString) {
        switch (buttonString.toLowerCase()) {
        case "confirm":
            confirmButton.click();
            break;

        case "receive":
            receiveButton.click();
            ReceiveProductsForm receiveProductsForm = new ReceiveProductsForm();
            receiveProductsForm.receiveProducts();
            break;

        case "confirm and transfer":
            confirmTransferButton.click();
            TransferProductsForm transferProductsForm = new TransferProductsForm();
            transferProductsForm.transferProducts();
            break;

        case "create invoice":
            createInvoiceButton.click();
            CreateDraftInvoiceForm createDraftInvoiceForm = new CreateDraftInvoiceForm();
            createDraftInvoiceForm.createInvoice();
            break;
        }
        this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
    }
}
