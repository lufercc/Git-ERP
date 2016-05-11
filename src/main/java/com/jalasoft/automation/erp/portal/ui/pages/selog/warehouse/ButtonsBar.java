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

    @FindBy(xpath = "//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Force Availability')]")
    protected WebElement forceAvailabilityButton;

    @FindBy(xpath = "//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Confirm & Transfer')]")
    protected WebElement confirmTransferButton;

    @FindBy(xpath = "//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Deliver')]")
    protected WebElement deliverButton;

    public ButtonsBar() {}

    @Override
    public boolean isLoaded() {
        return webDriverTools.isElementDisplayed(container);
    }

    @Override
    public void waitForLoading() {
        webDriverTools.waitUntilElementPresentAndVisible(container);
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

        case "deliver":
            deliverButton.click();
            DeliverProductsPopupForm deliverProductsPopupForm = new DeliverProductsPopupForm();
            deliverProductsPopupForm.deliverProducts();
            break;

        default:
            throw new IllegalArgumentException("Case value '" + buttonString + "' for button is not defined yet!!!");
        }

        webDriverTools.waitUntilInvisibilityOpenERPProgress();
    }
}
