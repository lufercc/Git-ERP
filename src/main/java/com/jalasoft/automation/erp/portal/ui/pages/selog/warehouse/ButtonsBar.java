package com.jalasoft.automation.erp.portal.ui.pages.selog.warehouse;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.CreateDraftInvoiceForm;
import com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.ReceiveProductsForm;
import com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.TransferProductsForm;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/26/2015.
 */
public class ButtonsBar extends PortalUIElement {

    @FindBy(xpath = "//div[contains(@class,'oe_form_container')]//header")
    protected WebElement container;

    @FindBy(xpath = "//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Forzar disponibilidad')]")
    protected WebElement forceAvailabilityButton;

    @FindBy(xpath = "//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Confirmar y transferir')]")
    protected WebElement confirmTransferButton;

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
        case "force availability":
            forceAvailabilityButton.click();
            break;

        case "confirm and transfer":
            confirmTransferButton.click();
            TransferProductsForm transferProductsForm = new TransferProductsForm();
            transferProductsForm.transferProducts();
            break;
        }

        this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
    }
}
