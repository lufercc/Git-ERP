package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.components.FormEditMode;
import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.DeliverAsset;
import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.RequestAssignation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class DeliverAssetPopupForm extends FormEditMode {


    @FindBy(css = "//div.ui-dialog.ui-widget.ui-widget-content.ui-corner-all.oe_act_window.ui-draggable.ui-resizable.openerp")
    protected WebElement dialogContainer;

    @FindBy(xpath = "//div[contains(@class,'ui-dialog-content')]//div[contains(@class,'oe_horizontal_separator')]")
    protected WebElement dialogTitle;


    @FindBy(name = "asset_status")
    protected WebElement assetStatus;

    @FindBy(name = "note")
    protected WebElement assetNote;

    @FindBy(xpath = "//div[contains(@class,'ui-dialog-buttonpane')]//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Accept')]")
    protected WebElement acceptButton;

    public DeliverAssetPopupForm() {
        waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return webDriverTools.isElementDisplayed(assetStatus);
    }

    @Override
    public void waitForLoading() {
        webDriverTools.waitUntilElementPresentAndVisible(assetStatus);
    }

    public void modifyDataAndAccept(DeliverAsset inputData) {
        fieldsWereEdited = new ArrayList<>();
        fieldsWereNotEdited = new ArrayList<>();
        allFieldsWereEdited = true;
        if (inputData.assetStatus != null) {
            selectItem(assetStatus,"assetStatus",inputData.assetStatus);
        }
        if (inputData.assetNote != null) {
            setInput(assetNote, "assetNote", inputData.assetNote);
        }
        acceptButton.click();
        webDriverTools.waitUntilInvisibilityOpenERPProgress();
        logEditStatus();
    }
}
