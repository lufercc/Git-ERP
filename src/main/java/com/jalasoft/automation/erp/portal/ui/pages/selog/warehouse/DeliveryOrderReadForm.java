package com.jalasoft.automation.erp.portal.ui.pages.selog.warehouse;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.selog.sales.SaleOrder;
import com.jalasoft.automation.erp.portal.ui.custom.selog.warehouse.DeliveryOrder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class DeliveryOrderReadForm extends PortalUIElement {

    @FindBy(xpath = "//div[contains(@class,'oe_form_container')]//h1/span/span")
    protected WebElement deliveryOrderCode;

    public DeliveryOrderReadForm() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.deliveryOrderCode);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.deliveryOrderCode);
    }

    public DeliveryOrder getMainData() {
        DeliveryOrder result = new DeliveryOrder();
        result.code = deliveryOrderCode.getText();
        return result;
    }

}
