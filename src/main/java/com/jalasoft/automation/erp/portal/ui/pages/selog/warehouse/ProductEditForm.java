package com.jalasoft.automation.erp.portal.ui.pages.selog.warehouse;

import com.jalasoft.automation.erp.portal.ui.components.FormEditMode;
import com.jalasoft.automation.erp.portal.ui.custom.selog.general.Product;
import com.jalasoft.automation.erp.portal.ui.custom.selog.purchase.Supplier;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class ProductEditForm extends FormEditMode {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(xpath = "//label[contains(text(),'Product Name')]/ancestor::div/following-sibling::h1/span/input[contains(@type,'text')]")
    protected WebElement name;

    @FindBy(xpath = "//label[contains(text(),'Category')]/following-sibling::h2/span/div/input[contains(@type,'text')]")
    protected WebElement category;

    @CacheLookup
    @FindBy(xpath = "//ul[contains(@role,'tablist')]/li[not(contains(@class,'invisible'))]/a[contains(text(),'Information')]")
    protected WebElement informationTab;

    @CacheLookup
    @FindBy(xpath = "//ul[contains(@role,'tablist')]/li[not(contains(@class,'invisible'))]/a[contains(text(),'Procurements')]")
    protected WebElement procurementsTab;

    @CacheLookup
    @FindBy(xpath = "//ul[contains(@role,'tablist')]/li[not(contains(@class,'invisible'))]/a[contains(text(),'Inventory')]")
    protected WebElement inventoryTab;

    @CacheLookup
    @FindBy(xpath = "//ul[contains(@role,'tablist')]/li[not(contains(@class,'invisible'))]/a[contains(text(),'Accounting')]")
    protected WebElement accountingTab;

    @FindBy(name = "type")
    protected WebElement productType;

    @FindBy(xpath = "//label[contains(text(),'Sale Price')]/ancestor::td/following-sibling::td/span/input[contains(@type,'text')]")
    protected WebElement salePrice;

    @FindBy(xpath = "//label[contains(text(),'Unit of Measure')]/ancestor::td/following-sibling::td/span/div/input[contains(@type,'text')]")
    protected WebElement unitMeasure;

    @FindBy(xpath = "//label[contains(text(),'Purchase Price')]/ancestor::td/following-sibling::td/span/input[contains(@type,'text')]")
    protected WebElement purchasePrice;

    @FindBy(xpath = "//label[contains(text(),'Cost Price')]/ancestor::td/following-sibling::td/div/button")
    protected WebElement costPriceButton;

    @FindBy(xpath = "//label[contains(text(),'Quantity On Hand')]/ancestor::td/following-sibling::td/div/button")
    protected WebElement quantityOnHandButton;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@class,'dialog') and contains(@role,'dialog')]")
    protected WebElement dialogWindow;

    @FindBy(xpath = "//div[contains(@class,'dialog')]//label[contains(text(),'Cost Price')]/ancestor::td/following-sibling::td/span/input[contains(@type,'text')]")
    protected WebElement costPrice;

    @CacheLookup
    @FindBy(xpath = "//div[contains(@class,'dialog')]//label[contains(text(),'New Quantity on Hand')]/ancestor::td/following-sibling::td/span/input[contains(@type,'text')]")
    protected WebElement quantityOnHand;

    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Expense Account')]/ancestor::td/following-sibling::td/span/div/input[contains(@type,'text')]")
    protected WebElement expenseAccount;


    @CacheLookup
    @FindBy(xpath = "//div[contains(@class,'dialog')]//button/span[contains(text(),'Apply')]")
    protected WebElement applyDialogButton;





    public ProductEditForm() {
        waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.dataContainer);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.dataContainer);
    }

    public void selectTab(String tab) {
        switch (tab.toLowerCase()) {
        case "basic":
            break;

        case "information":
            informationTab.click();
            break;

        case "procurements":
            procurementsTab.click();
            break;

        case "inventory":
            inventoryTab.click();
            break;

        case "accounting":
            accountingTab.click();
            break;

        default:
            throw new IllegalArgumentException("Case value '" + tab + "' for tabs is not defined yet. Add it!!!");
        }
        webDriverTools.waitUntilInvisibilityOpenERPProgress();
    }

    public void modifyData(Product inputData) {
        fieldsWereEdited = new ArrayList<>();
        fieldsWereNotEdited = new ArrayList<>();
        allFieldsWereEdited = true;

        if (inputData.name != null) {
            setInput(name, "name", inputData.name);
        }

        if (inputData.category != null) {
            selectOERPItemFromPartialText(category, "category", inputData.category);
        }

        if (inputData.productType != null) {
            selectItem(productType, "productType", inputData.productType);
        }
        if (inputData.salePrice != null) {
            setInput(salePrice, "salePrice", inputData.salePrice);
        }

        if (inputData.unitMeasure != null) {
            setInput(unitMeasure, "unitMeasure", inputData.unitMeasure);
        }

        if (inputData.purchasePrice != null) {
            setInput(purchasePrice, "purchasePrice", inputData.purchasePrice);
        }

        if (inputData.costPrice != null) {
            costPriceButton.click();
            setInput(costPrice, "costPrice", inputData.costPrice);
            applyDialogButton.click();
        }

        if (inputData.quantityOnHand != null) {
            quantityOnHandButton.click();
            setInput(quantityOnHand, "quantityOnHand", inputData.quantityOnHand);
            applyDialogButton.click();
        }

        if (inputData.expenseAccount != null) {
            setInput(expenseAccount, "expenseAccount", inputData.expenseAccount);
        }
        logEditStatus();
    }
}
