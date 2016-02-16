package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.NDA;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class NDAInfoReadForm extends TableOpenERP {

    @FindBy(xpath = "(//table[contains(@class,'oe_list_content')])[3]")
    protected WebElement table;

    public NDAInfoReadForm() {
        super.table = this.table;
        expectedSpanishHeaders.put("ndaVersion","Versión NDA");
        expectedSpanishHeaders.put("signDate","Fecha de firma");
        expectedHeaders = expectedSpanishHeaders;
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.table);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.table);
    }

    public boolean hasSameContent(List<NDA> expectedNDAData) {
        List<HashMap<String,String>> dataFromTable = this.getData();
        NDA currentNDA;
        HashMap<String,String> currentRow;
        if(expectedNDAData.size()!= dataFromTable.size()) {
            return false;
        }
        while(dataFromTable.size() > 0) {
            int tableSize = dataFromTable.size();
            for(int indexNDAList = 0; indexNDAList < expectedNDAData.size(); indexNDAList++) {
                currentNDA = expectedNDAData.get(indexNDAList);
                for(int indexList = 0; indexList < tableSize; indexList++) {
                    currentRow = dataFromTable.get(indexList);
                    if (currentNDA.ndaVersion.equals(currentRow.get(expectedHeaders.get("ndaVersion"))) &&
                        currentNDA.signDate.equals(currentRow.get(expectedHeaders.get("signDate")))) {
                            dataFromTable.remove(currentRow);
                            break;
                    }
                    if(indexList == (tableSize - 1)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
