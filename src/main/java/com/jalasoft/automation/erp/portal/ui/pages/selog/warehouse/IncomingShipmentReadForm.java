package com.jalasoft.automation.erp.portal.ui.pages.selog.warehouse;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.JournalEntry;
import com.jalasoft.automation.erp.portal.ui.custom.selog.warehouse.IncomingShipment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class IncomingShipmentReadForm extends PortalUIElement {

    @FindBy(xpath = "//div[contains(@class,'oe_form_container')]")
    protected WebElement container;

    @FindBy(xpath = "//div[contains(@class,'oe_selog_sheet_wider')]//h1/span/span[contains(@class,'content')]")
    protected WebElement incomingShipmentCode;

    public IncomingShipmentReadForm() {}

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.container);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.container);
    }

    public IncomingShipment getMainData() {
        IncomingShipment result = new IncomingShipment();
        result.code = incomingShipmentCode.getText();
        return result;
    }

}
