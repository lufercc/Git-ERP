package com.jalasoft.automation.erp.portal.ui.pages.selog.sales;

import com.jalasoft.automation.erp.portal.ui.components.FormEditMode;
import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.selog.purchase.PurchaseOrder;
import com.jalasoft.automation.erp.portal.ui.custom.selog.sales.SaleOrder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class SaleOrderEditForm extends FormEditMode {

    @FindBy(xpath = "//label[contains(text(),'Customer')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/div/input")
    protected WebElement client;

    @FindBy(xpath = "//label[contains(text(),'TIN')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/input")
    protected WebElement tin;

    @FindBy(xpath = "//label[contains(text(),'Sale Tax Type')]/ancestor::td[contains(@class,'cell_label')]/following-sibling::td/span/div/input")
    protected WebElement saleTaxType;

    @FindBy(name = "purchase_type")
    protected WebElement purchaseType;

    @FindBy(xpath = "//a[contains(text(),'Add an item')]")
    protected WebElement addItemPurchaseOrder;

    public SaleOrderEditForm() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.client);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.client);
    }

    public void modifyData(SaleOrder inputData) {
        fieldsWereEdited = new ArrayList<>();
        fieldsWereNotEdited = new ArrayList<>();
        allFieldsWereEdited = true;

        if (inputData.client != null) {
            selectOpenERPItem(client, "client", inputData.client);
        }
        if (inputData.tin != null) {
            setInput(tin, "tin", inputData.tin);
        }
        if (inputData.saleTaxType != null) {
            selectOpenERPItem(saleTaxType, "saleTaxType", inputData.saleTaxType);
        }

        logEditStatus();
    }

    public void clickAddItemOrderLine() {
        addItemPurchaseOrder.click();
    }
}
