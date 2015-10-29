package com.jalasoft.automation.erp.portal.ui.pages.selog.purchase;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.selog.purchase.OrderLine;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class OrderLineForm extends PortalUIElement {
    @FindBy(xpath = "(//div[contains(@class,'ui-dialog ui-widget ui-widget-content ui-corner-all oe_act_window ui-draggable ui-resizable openerp')]//input)[1]")
    protected WebElement product;

    @FindBy(xpath = "(//div[contains(@class,'ui-dialog ui-widget ui-widget-content ui-corner-all oe_act_window ui-draggable ui-resizable openerp')]//textarea")
    protected WebElement noteTextArea;

    @FindBy(xpath = "//button[contains(text(),'Agregar y Cerrar')]")
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

    public void modifyOrderLine(OrderLine inputData)
    {
        WebDriverWait wait = new WebDriverWait(webDriver, 5);

        if (inputData.product != null) {
            this.product.sendKeys(inputData.product);
            WebElement productLink = this.webDriver.findElement(By.xpath("//ul[not(contains(@style,\"display: none;\"))]//a[contains(text(),\""+ inputData.product + "\")]"));
            productLink.click();

        }
        saveAndCloseButton.click();
    }

}
