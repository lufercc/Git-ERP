package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.components.SelectOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.Asset;
import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.SupplierInvoice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class AssetEditForm extends PortalUIElement {

    @FindBy(xpath = "//input[@placeholder='Nombre']")
    protected WebElement name;

    @FindBy(name = "parent_image")
    protected WebElement parentImage;

    @FindBy(xpath = "//span[contains(@class,'oe_form_field_float oe_form_field_monetary oe_form_required')]//input")
    protected WebElement grossValue;

    protected SelectOpenERP assetCategoryParent;

    WebElement valueSelected;

    public AssetEditForm() {
        this.waitForLoading();
        this.assetCategoryParent = new SelectOpenERP(By.xpath("(//table[contains(@class,'oe_form_group')]//input)[2]"));

    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.parentImage);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.parentImage);
    }

    public void modifyData(Asset inputData) {
        if (inputData.assetCategoryParent != null) {
            this.assetCategoryParent.selectItem(inputData.assetCategoryParent);
        }
        if (inputData.grossValue != null) {
            this.webDriverTools.clearAndSendKeys(this.grossValue,inputData.grossValue);
        }
    }
}
