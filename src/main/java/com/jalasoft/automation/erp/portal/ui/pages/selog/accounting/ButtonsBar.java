package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.CreateDraftInvoiceForm;
import com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.ReceiveProductsForm;
import com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.TransferProductsForm;
import org.apache.xpath.SourceTree;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Henry Benito on 10/26/2015.
 */
public class ButtonsBar extends PortalUIElement {

    @FindBy(xpath = "//div[contains(@class,'oe_form_container')]//header")
    protected WebElement container;

    @FindBy(xpath = "//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Validar')]")
    protected WebElement validateButton;

    @FindBy(xpath = "//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Confirmar Activo')]")
    protected WebElement confirmAssetButton;

    @FindBy(xpath = "//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Solicitar Asignación')]")
    protected WebElement requestAssignationButton;

    @FindBy(xpath = "//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Entregar')]")
    protected WebElement deliverButton;

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

        case "confirm asset":
            confirmAssetButton.click();
            break;

        case "request assignation":
            requestAssignationButton.click();
            break;

        case "deliver":
            deliverButton.click();
            break;

        default:
            throw new IllegalArgumentException("Case value '" + buttonString +
                                               "' for accounting buttons is not defined yet!!!");
        }

        this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
    }
}
