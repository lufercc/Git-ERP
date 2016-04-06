package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.Project;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class ProjectInfoReadForm extends TableOpenERP {

    @FindBy(xpath = "//label[contains(text(),'Project Codes')]/ancestor::td/following-sibling::td//table")
    protected WebElement table;

    public ProjectInfoReadForm() {
        super.table = this.table;
        expectedSpanishHeaders.put("code","Código de proyecto");
        expectedEnglishHeaders.put("code","Project Code");
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

    public boolean hasSameContent(boolean shouldBeAble, List<Project> expectedData) {
        List<HashMap<String,String>> dataFromTable = this.getData();
        HashMap<String,String> currentRow;
        int tableSize;

        if((expectedData.size()!= dataFromTable.size()) && shouldBeAble) {
            return false;
        }

        if (dataFromTable.isEmpty() && !shouldBeAble) {
            return true;
        }

        for(Project currentProject : expectedData) {
            tableSize =  dataFromTable.size();
            for(int indexList = 0; indexList < tableSize; indexList++) {
                currentRow = dataFromTable.get(indexList);
                if (shouldBeAble) {
                    if (inputDataIsInRow(currentProject,currentRow)) {
                        dataFromTable.remove(currentRow);
                        break;
                    }
                    if (indexList == (tableSize - 1)) {
                        return false;
                    }
                } else {
                    if (inputDataIsInRow(currentProject,currentRow)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean inputDataIsInRow(Project inputRecord, HashMap<String,String> tableRow) {
        if(inputRecord.code != null) {
            if (!inputRecord.code.equals(tableRow.get(expectedHeaders.get("code")))) {
                return false;
            }
        }
        return true;
    }
}
