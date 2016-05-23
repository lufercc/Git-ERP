package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.objects.selog.accounting.AssetDeliveryRecord;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class AssetsDeliveryRecordsReadForm extends PortalUIElement {

    @FindBy(xpath = "//div[contains(@class,'oe_form_container')]")
    protected WebElement container;

//    @FindBy(xpath = "//div[contains(@class,'oe_form_container')]//div[contains(@class,'oe_title')]//span/span")
    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'No.')]/following-sibling::span/span")
    protected WebElement deliveryRecordID;

    public AssetsDeliveryRecordsReadForm() {}

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.container);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.container);
    }

    public AssetDeliveryRecord getMainData() {
        AssetDeliveryRecord result = new AssetDeliveryRecord();
        result.id = deliveryRecordID.getAttribute("innerHTML");
        System.out.println("Asset Delivery Record ID:" + result.id);
        return result;
    }

}
