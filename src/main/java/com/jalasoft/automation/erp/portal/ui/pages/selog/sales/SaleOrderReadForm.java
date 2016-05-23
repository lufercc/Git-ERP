package com.jalasoft.automation.erp.portal.ui.pages.selog.sales;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.objects.selog.sales.SaleOrder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class SaleOrderReadForm extends PortalUIElement {

    @FindBy(xpath = "//div[contains(@class,'oe_form_container')]//h1//span/span")
    protected WebElement saleOrderCode;

    public SaleOrderReadForm() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.saleOrderCode);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.saleOrderCode);
    }

    public SaleOrder getMainData() {
        SaleOrder result = new SaleOrder();
        result.code = saleOrderCode.getText();
        return result;
    }

}
