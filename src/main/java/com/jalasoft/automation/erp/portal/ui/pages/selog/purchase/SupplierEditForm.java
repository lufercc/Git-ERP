package com.jalasoft.automation.erp.portal.ui.pages.selog.purchase;

import com.jalasoft.automation.erp.portal.ui.components.FormEditMode;
import com.jalasoft.automation.erp.portal.ui.components.SelectOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.PersonalInfoEmployee;
import com.jalasoft.automation.erp.portal.ui.custom.selog.purchase.Supplier;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class SupplierEditForm extends FormEditMode {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(xpath = "//div[contains(@class,'oe_title')]/h1/span/input[contains(@placeholder,'Name')]")
    protected WebElement name;

    @FindBy(name = "is_company")
    protected WebElement isACompany;

    @FindBy(xpath = "//label[contains(text(),'Address')]/ancestor::td/following-sibling::td/div/span/input[contains(@placeholder,'Street')]")
    protected WebElement address;

    @FindBy(xpath = "//ul[contains(@role,'tablist')]/li[not(contains(@class,'invisible'))]/a[contains(text(),'Accounting')]")
    protected WebElement accountingTab;

    @FindBy(xpath = "//label[contains(text(),'TIN')]/ancestor::td/following-sibling::td/div/span/input[contains(@type,'text')]")
    protected WebElement tin;

    @FindBy(xpath = "//ul[contains(@role,'tablist')]/li[not(contains(@class,'invisible'))]/a[contains(text(),'Sales & Purchases')]")
    protected WebElement salesPurchasesTab;

    @FindBy(xpath = "//label[contains(text(),'Sale Pricelist')]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement salePricelist;

    @FindBy(xpath = "//label[contains(text(),'Purchase Pricelist')]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement purchasePricelist;

    public SupplierEditForm() {
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

        case "accounting":
            accountingTab.click();
            break;

        case "sales & purchases":
            salesPurchasesTab.click();
            break;

        default:
            throw new IllegalArgumentException("Case value '" + tab + "' for tabs is not defined yet. Add it!!!");
        }
        webDriverTools.waitUntilInvisibilityOpenERPProgress();
    }

    public void modifyData(Supplier inputData) {
        fieldsWereEdited = new ArrayList<>();
        fieldsWereNotEdited = new ArrayList<>();
        allFieldsWereEdited = true;

        if (inputData.name != null) {
            setInput(name, "name", inputData.name);
        }

        if (inputData.isACompany != null) {
            setCheckbox(isACompany, "isACompany", inputData.isACompany);
        }

        if (inputData.address != null) {
            setInput(address, "address", inputData.address);
        }

        if (inputData.tin != null) {
            setInput(tin, "tin", inputData.tin);
        }

        if (inputData.salePricelist != null) {
            selectOERPItemFromPartialText(salePricelist, "salePricelist", inputData.salePricelist);
        }

        if (inputData.purchasePricelist != null) {
            selectOERPItemFromPartialText(purchasePricelist, "purchasePricelist", inputData.purchasePricelist);
        }

        logEditStatus();
    }
}
