package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.NDA;
import com.jalasoft.automation.erp.portal.ui.custom.selog.general.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class SupplierInvoiceProductsEditForm extends TableOpenERP {
    @CacheLookup
    @FindBy(xpath = "//li[contains(@class,'active')]/a[contains(text(),'Invoice')]/ancestor::ul/following-sibling::div//table[contains(@class,'oe_list_content')]")
    protected WebElement table;

    @FindBy(xpath = "//span[@data-fieldname='product_id']/div/input")
    protected WebElement productID;
    @FindBy(xpath = "//div[@data-fieldname='name']/textarea")
    protected WebElement description;

    @FindBy(xpath = "//span[@data-fieldname='quantity']/input")
    protected WebElement quantity;

    public SupplierInvoiceProductsEditForm() {
        super.table = this.table;
        expectedEnglishHeaders.put("product", "Product");
        expectedEnglishHeaders.put("description", "Description");
        expectedEnglishHeaders.put("account", "Account");
        expectedEnglishHeaders.put("analyticDistribution", "Analytic Distribution");
        expectedEnglishHeaders.put("assetCategory","Asset Category");
        expectedEnglishHeaders.put("quantity","Quantity");
        expectedEnglishHeaders.put("unitMeasure","Unit of Measure");
        expectedEnglishHeaders.put("unitPrice","Unit Price");
        expectedEnglishHeaders.put("discount","Discount (%)");
        expectedEnglishHeaders.put("taxes","Taxes");
        expectedEnglishHeaders.put("amount","Amount");
        expectedHeaders = expectedEnglishHeaders;
    }

    @Override
    public boolean isLoaded() {
        return webDriverTools.isElementDisplayed(table);
    }

    @Override
    public void waitForLoading() {
        webDriverTools.waitUntilElementPresentAndVisible(table);
    }

    public void addData(List<Product> inputData) {
        try {
            allRecordsWereAdded = false;

            for (int i = 0; i < inputData.size(); i++) {

                clickAddElement();

                fieldsWereEdited = new ArrayList<>();
                fieldsWereNotEdited = new ArrayList<>();
                allFieldsWereEdited = true;
                if (inputData.get(i).productID != null) {
                    selectOpenERPItem(productID, "productID", inputData.get(i).productID);
                }

                if (inputData.get(i).quantity != null) {
                    setInput(quantity, "quantity", inputData.get(i).quantity);
                }
                clickFoot();
                logEditStatus();
            }
            allRecordsWereAdded = true;
        } catch (NoSuchElementException nsee) {
            logNotAddedRecords();
        }
    }
}
