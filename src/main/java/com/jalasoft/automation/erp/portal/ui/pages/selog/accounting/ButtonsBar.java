package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

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

    @FindBy(xpath = "//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Validar')]")
    protected WebElement validateButton;

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
        case "validate":
            validateButton.click();
            break;
        }
    }
}
