package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.Asset;
import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.SupplierInvoice;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class AssetEditForm extends PortalUIElement {

    @FindBy(xpath = "(//table[contains(@class,'oe_form_group')]//input)[2]")
    protected WebElement assetCategoryParent;

    @FindBy(xpath = "(//table[contains(@class,'oe_form_group')]//input)[16]")
    protected WebElement grossValue;

    public AssetEditForm() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.assetCategoryParent);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.assetCategoryParent);
    }

    public void modifyData(Asset inputData) {
        if (inputData.assetCategoryParent != null) {
            this.assetCategoryParent.sendKeys(inputData.assetCategoryParent);
            this.assetCategoryParent.sendKeys(Keys.RETURN);
        }
        if (inputData.grossValue != null) {
            this.webDriverTools.clearAndSendKeys(this.grossValue,inputData.grossValue);
        }
    }
}
