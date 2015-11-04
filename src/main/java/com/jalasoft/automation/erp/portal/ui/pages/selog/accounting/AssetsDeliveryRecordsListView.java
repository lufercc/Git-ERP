package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by Henry Benito on 10/21/2015.
 */
public class AssetsDeliveryRecordsListView extends PortalUIElement {

    @FindBy(xpath = "//div[contains(@class,'oe_view_manager_current')and(not(contains(@style,'display: none;')))]")
    protected WebElement mainTable;

    public AssetsDeliveryRecordsListView() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.mainTable);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.mainTable);
    }

    public void goToRowRecord(int rowNumberRecord) {
        WebElement cell = null;
        try {
            cell = mainTable.findElement(By.xpath("(//div[contains(@class,'oe_view_manager_current')and(not(contains(@style,'display: none;')))]//div[contains(@class,'oe_view_manager_body')]//tbody/tr)[" + rowNumberRecord + "]"));
        } catch(NullPointerException npe) {
            System.out.println("Row was not found with '" + rowNumberRecord + "' number");
        }

        if (!cell.equals(null)) {
            cell.click();
        }
    }
}
