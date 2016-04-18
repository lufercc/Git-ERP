package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.EmergencyContact;
import com.jalasoft.automation.erp.portal.ui.custom.selog.general.Product;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class SupplierInvoiceProductsReadForm extends TableOpenERP {

    @CacheLookup
    @FindBy(xpath = "//li[contains(@class,'active')]/a[contains(text(),'Invoice')]/ancestor::ul/following-sibling::div//table[contains(@class,'oe_list_content')]")
    protected WebElement table;


    public SupplierInvoiceProductsReadForm() {
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
        return super.webDriverTools.isElementDisplayed(this.table);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.table);
    }

    public boolean hasSameContent(boolean shouldBeAble, List<Product> expectedData) {
        List<HashMap<String,String>> dataFromTable = this.getData();
        HashMap<String,String> currentRow;
        int tableSize;

        if((expectedData.size()!= dataFromTable.size()) && shouldBeAble) {
            return false;
        }

        if(dataFromTable.isEmpty() && !shouldBeAble) {
            return true;
        }
        for(Product product : expectedData) {
            tableSize =  dataFromTable.size();
            for(int indexList = 0; indexList < tableSize; indexList++) {
                currentRow = dataFromTable.get(indexList);
                if (shouldBeAble) {
                    if (inputDataIsInRow(product,currentRow)) {
                        dataFromTable.remove(currentRow);
                        break;
                    }
                    if (indexList == (tableSize - 1)) {
                        logNotRecordFoundInTable();
                        return false;
                    }
                } else {
                    if (inputDataIsInRow(product,currentRow)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean inputDataIsInRow(Product inputRecord, HashMap<String,String> tableRow) {
        if(inputRecord.productID != null) {
            if (!inputRecord.productID.equals(tableRow.get(expectedHeaders.get("product")))) {
                return false;
            }
        }
        if(inputRecord.quantity != null) {
            if (!inputRecord.quantity.equals(tableRow.get(expectedHeaders.get("quantity")))){
                return false;
            }
        }
        if(inputRecord.unitPrice != null) {
            if (!inputRecord.unitPrice.equals(tableRow.get(expectedHeaders.get("unitPrice")))) {
                return false;
            }
        }
        if(inputRecord.amount != null) {
            if (!inputRecord.amount.equals(tableRow.get(expectedHeaders.get("amount")))) {
                return false;
            }
        }
        return true;
    }
}
