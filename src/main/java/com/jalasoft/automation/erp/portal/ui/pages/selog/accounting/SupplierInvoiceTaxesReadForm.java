package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.selog.general.Product;
import com.jalasoft.automation.erp.portal.ui.custom.selog.general.Tax;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class SupplierInvoiceTaxesReadForm extends TableOpenERP {

    @CacheLookup
    @FindBy(xpath = "//li[contains(@class,'active')]/a[contains(text(),'Invoice')]/ancestor::ul/following-sibling::div/div[contains(@page_name,'Invoice')]//table[contains(@class,'oe_list_content')]")
    protected WebElement table;


    public SupplierInvoiceTaxesReadForm() {
        super.table = this.table;
        expectedEnglishHeaders.put("taxDescription", "Tax Description");
        expectedEnglishHeaders.put("taxAccount", "Tax Account");
        expectedEnglishHeaders.put("analyticDistribution", "Analytic Distribution");
        expectedEnglishHeaders.put("base", "Base");
        expectedEnglishHeaders.put("taxAmount","Tax Amount");
        expectedEnglishHeaders.put("includeJournalEntry","Include Journal Entry");
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

    public boolean hasSameContent(boolean shouldBeAble, List<Tax> expectedData) {
        List<HashMap<String,String>> dataFromTable = this.getData();
        HashMap<String,String> currentRow;
        int tableSize;

        if((expectedData.size()!= dataFromTable.size()) && shouldBeAble) {
            return false;
        }

        if(dataFromTable.isEmpty() && !shouldBeAble) {
            return true;
        }
        for(Tax tax : expectedData) {
            tableSize =  dataFromTable.size();
            for(int indexList = 0; indexList < tableSize; indexList++) {
                currentRow = dataFromTable.get(indexList);
                if (shouldBeAble) {
                    if (inputDataIsInRow(tax,currentRow)) {
                        dataFromTable.remove(currentRow);
                        break;
                    }
                    if (indexList == (tableSize - 1)) {
                        logNotRecordFoundInTable();
                        return false;
                    }
                } else {
                    if (inputDataIsInRow(tax,currentRow)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean inputDataIsInRow(Tax inputRecord, HashMap<String,String> tableRow) {
        if(inputRecord.taxDescription != null) {
            if (!inputRecord.taxDescription.equals(tableRow.get(expectedHeaders.get("taxDescription")))) {
                return false;
            }
        }
        if(inputRecord.taxAccount != null) {
            if (!inputRecord.taxAccount.equals(tableRow.get(expectedHeaders.get("taxAccount")))){
                return false;
            }
        }
        if(inputRecord.analyticDistribution != null) {
            if (!inputRecord.analyticDistribution.equals(tableRow.get(expectedHeaders.get("analyticDistribution")))) {
                return false;
            }
        }
        if(inputRecord.base != null) {
            if (!inputRecord.base.equals(tableRow.get(expectedHeaders.get("base")))) {
                return false;
            }
        }
        if(inputRecord.taxAmount != null) {
            if (!inputRecord.taxAmount.equals(tableRow.get(expectedHeaders.get("taxAmount")))) {
                return false;
            }
        }
        return true;
    }
}
