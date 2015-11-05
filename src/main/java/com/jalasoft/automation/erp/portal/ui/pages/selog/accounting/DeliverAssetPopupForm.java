package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.DeliverAsset;
import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.RequestAssignation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class DeliverAssetPopupForm extends PortalUIElement {


    @FindBy(css = "//div.ui-dialog.ui-widget.ui-widget-content.ui-corner-all.oe_act_window.ui-draggable.ui-resizable.openerp")
    protected WebElement dialogContainer;

    @FindBy(xpath = "//div[contains(@class,'ui-dialog-content')]//div[contains(@class,'oe_horizontal_separator')]")
    protected WebElement dialogTitle;


    @FindBy(name = "asset_status")
    protected WebElement assetStatus;

    @FindBy(name = "note")
    protected WebElement assetNote;

    @FindBy(xpath = "//div[contains(@class,'ui-dialog-buttonpane')]//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Aceptar')]")
    protected WebElement acceptButton;

    public DeliverAssetPopupForm() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.assetStatus);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.assetStatus);
    }

    public void modifyDataAndAccept(DeliverAsset inputData) {
        if (inputData.assetStatus != null) {
            this.webDriverTools.selectOptionOfDropListElement(this.assetStatus,inputData.assetStatus);
        }
        if (inputData.assetNote != null) {
            this.webDriverTools.clearAndSendKeys(this.assetNote,inputData.assetNote);
        }
        acceptButton.click();
        this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
    }
}
