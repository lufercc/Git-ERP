package com.jalasoft.automation.erp.portal.ui.pages.general;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.DeliverAsset;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class GeneralPopupForm extends PortalUIElement {


    @FindBy(css = "//div.ui-dialog.ui-widget.ui-widget-content.ui-corner-all.oe_act_window.ui-draggable.ui-resizable.openerp")
    protected WebElement dialogContainer;

    @FindBy(xpath = "//div[contains(@class,'ui-dialog-content')]//div[contains(@class,'oe_horizontal_separator')]")
    protected WebElement dialogTitle;

    @FindBy(xpath = "//div[contains(@class,'ui-dialog-buttonpane')]//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Ok')]")
    protected WebElement okButton;

    public GeneralPopupForm() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.okButton);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.okButton);
    }

    public void clickButton(String buttonString) {
        switch (buttonString.toLowerCase()) {
            case "ok":
                okButton.click();
                break;
        }
    }
}
