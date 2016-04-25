package com.jalasoft.automation.erp.portal.ui.pages.selog.warehouse;

import com.jalasoft.automation.erp.portal.ui.components.FormReadMode;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.PersonalInfoEmployee;
import com.jalasoft.automation.erp.portal.ui.custom.selog.general.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class ProductReadForm extends FormReadMode {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(xpath = "//ul[contains(@role,'tablist')]/li[not(contains(@class,'invisible'))]/a[contains(text(),'Information')]")
    protected WebElement informationTab;

    @FindBy(xpath = "//ul[contains(@role,'tablist')]/li[not(contains(@class,'invisible'))]/a[contains(text(),'Procurements')]")
    protected WebElement procurementsTab;

    @FindBy(xpath = "//ul[contains(@role,'tablist')]/li[not(contains(@class,'invisible'))]/a[contains(text(),'Inventory')]")
    protected WebElement inventoryTab;

    @FindBy(xpath = "//label[contains(text(),'Sale Price')]/ancestor::td/following-sibling::td/span/span")
    protected WebElement salePrice;

    @FindBy(xpath = "//label[contains(text(),'Purchase Price')]/ancestor::td/following-sibling::td/span/span")
    protected WebElement purchasePrice;

    @FindBy(xpath = "//label[contains(text(),'Cost Price')]/ancestor::td/following-sibling::td/span/span")
    protected WebElement costPrice;

    @FindBy(xpath = "//label[contains(text(),'Quantity On Hand')]/ancestor::td/following-sibling::td/div/span/span")
    protected WebElement quantityOnHand;

    public ProductReadForm() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.dataContainer);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.dataContainer);
    }

    public Product getDataFromUI(Product infoFromStep) {
        fieldsWereRead = new ArrayList<>();
        fieldsWereNotRead = new ArrayList<>();
        allFieldsWereRead = true;

        Product result = new Product();

        if(infoFromStep.salePrice != null) {
            result.salePrice = getSpanValue(salePrice, "salePrice");
        }
        if(infoFromStep.purchasePrice != null) {
            result.purchasePrice = getSpanValue(purchasePrice, "purchasePrice");
        }
        if(infoFromStep.costPrice != null) {
            result.costPrice = getSpanValue(costPrice, "costPrice");
        }
        if(infoFromStep.quantityOnHand != null) {
            result.quantityOnHand = getSpanValue(quantityOnHand, "quantityOnHand");
        }
        logReadStatus();
        return result;
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

        default:
            throw new IllegalArgumentException("Case value '" + tab + "' for tabs is not defined yet. Add it!!!");
        }
        webDriverTools.waitUntilInvisibilityOpenERPProgress();
    }
}
