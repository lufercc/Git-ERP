package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by Henry Benito on 10/21/2015.
 */
public class JournalEntriesListView extends PortalUIElement {

    @FindBy(xpath = "//div[contains(@class,'oe_view_manager_current')and(not(contains(@style,'display: none;')))]")
    protected WebElement mainTable;

    public JournalEntriesListView() {
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

    public void clickOnRecord(String cellValue) {
        WebElement cell = null;
        try {
            cell = mainTable.findElement(By.xpath("//table[contains(@class,'oe_list_content')]//tr/td[contains(.,'" + cellValue + "')]"));
        } catch(NullPointerException npe) {
            System.out.println("Cell was not found with '" + cellValue + "' value");
        }

        if (!cell.equals(null)) {
            cell.click();
        }
    }
}
