package com.jalasoft.automation.erp.portal.ui.pages.selog.purchase;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by Henry Benito on 10/21/2015.
 */
public class PurchaseRequisitionList extends PortalUIElement {
    //@FindBy(css = "table.oe_list_content")
    //@FindBy(xpath = "//table[contains(@class,'oe_list_content')]")
    @FindBy(xpath = "//div[contains(@class,'oe_view_manager_body')]")
    protected WebElement mainTable;

    @FindBy(xpath = "//ul[@class='oe_menu']//span[contains(text(),'Compras')]")
    protected WebElement purchasesMenu;

    //@FindBy(css = "th.oe_list_header_char.oe_sortable > div")
    @FindBy(xpath = "//div[contains(text(),'Referencia de solicitud')]")
    protected WebElement firstHeader;

    public PurchaseRequisitionList() {
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

    public boolean isCellPresent(String cellValue)
    {
        WebElement cell = null;
        try {
            cell = mainTable.findElement(By.xpath("//tr/td[contains(.,'" + cellValue + "')]"));
        }catch(NullPointerException npe)
        {
            System.out.println("Cell was not found with '" + cellValue + "' value");
        }

        if(!cell.equals(null))
        {
            return true;
        }
        return false;
    }
}
