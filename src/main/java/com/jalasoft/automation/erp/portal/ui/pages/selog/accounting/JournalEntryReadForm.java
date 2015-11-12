package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.AssetDeliveryRecord;
import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.JournalEntry;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class JournalEntryReadForm extends PortalUIElement {

    @FindBy(xpath = "//div[contains(@class,'oe_form_container')]")
    protected WebElement container;

    @FindBy(xpath = "//div[contains(@class,'oe_form_container')]//div[contains(@class,'oe_title')]//span/span")
    protected WebElement journalEntryCode;

    public JournalEntryReadForm() {}

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.container);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.container);
    }

    public JournalEntry getMainData() {
        JournalEntry result = new JournalEntry();
        result.code = journalEntryCode.getText();
        return result;
    }

}
