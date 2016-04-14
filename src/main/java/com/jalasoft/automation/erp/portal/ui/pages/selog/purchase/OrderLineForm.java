package com.jalasoft.automation.erp.portal.ui.pages.selog.purchase;

import com.jalasoft.automation.erp.portal.ui.components.FormEditMode;
import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.selog.purchase.OrderLine;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class OrderLineForm extends FormEditMode {

    @FindBy(xpath = "(//div[contains(@class,'ui-dialog ui-widget ui-widget-content ui-corner-all oe_act_window ui-draggable ui-resizable openerp')]//input)[1]")
    protected WebElement product;

    @FindBy(xpath = "(//div[contains(@class,'ui-dialog ui-widget ui-widget-content ui-corner-all oe_act_window ui-draggable ui-resizable openerp')]//textarea")
    protected WebElement noteTextArea;

    @FindBy(xpath = "//label[contains(text(),'Unit Price')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement unitPrice;

    @FindBy(xpath = "//button[contains(text(),'Add & Close')]")
    protected WebElement saveAndCloseButton;

    public OrderLineForm() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.product);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.product);
    }

    public void modifyOrderLine(OrderLine inputData) {
        fieldsWereEdited = new ArrayList<>();
        fieldsWereNotEdited = new ArrayList<>();
        allFieldsWereEdited = true;
        if (inputData.product != null) {
            webDriverTools.waitUntilElementPresentAndVisible(product);
            selectOpenERPItem(product, "product", inputData.product);
        }
        if (inputData.unitPrice != null) {
            webDriverTools.waitUntilElementPresentAndVisible(unitPrice);
            setInput(unitPrice,"unitPrice", inputData.unitPrice);
        }
        saveAndCloseButton.click();
        logEditStatus();
    }

}
