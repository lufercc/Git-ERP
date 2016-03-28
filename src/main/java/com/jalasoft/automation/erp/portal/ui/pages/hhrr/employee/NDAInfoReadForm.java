package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.NDA;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class NDAInfoReadForm extends TableOpenERP {

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'NDA Info')]/following-sibling::table//table[contains(@class,'oe_list_content')]")
    protected WebElement table;

    public NDAInfoReadForm() {
        super.table = this.table;
        expectedSpanishHeaders.put("ndaVersion","Versión NDA");
        expectedSpanishHeaders.put("signDate","Fecha de firma");
        expectedEnglishHeaders.put("ndaVersion","NDA Version");
        expectedEnglishHeaders.put("signDate","Date of Signature");
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

    public boolean hasSameContent(boolean shouldBeAble, List<NDA> expectedData) {
        List<HashMap<String,String>> dataFromTable = this.getData();
        HashMap<String,String> currentRow;
        int tableSize;

        if((expectedData.size()!= dataFromTable.size()) && shouldBeAble) {
            return false;
        }

        if (dataFromTable.isEmpty() && !shouldBeAble) {
            return true;
        }
        for(NDA currentNDA : expectedData) {
            tableSize =  dataFromTable.size();
            for(int indexList = 0; indexList < tableSize; indexList++) {
                currentRow = dataFromTable.get(indexList);
                if (shouldBeAble) {
                    if (inputDataIsInRow(currentNDA,currentRow)) {
                        dataFromTable.remove(currentRow);
                        break;
                    }
                    if (indexList == (tableSize - 1)) {
                        return false;
                    }
                } else {
                    if (inputDataIsInRow(currentNDA,currentRow)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean inputDataIsInRow(NDA inputRecord, HashMap<String,String> tableRow) {
        if(inputRecord.ndaVersion != null) {
            if (!inputRecord.ndaVersion.equals(tableRow.get(expectedHeaders.get("ndaVersion")))) {
                return false;
            }
        }
        if(inputRecord.signDate != null) {
            if (!inputRecord.signDate.equals(tableRow.get(expectedHeaders.get("signDate")))){
                return false;
            }
        }
        return true;
    }
}
