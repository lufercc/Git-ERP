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

    public boolean hasSameContent(List<Project> expectedData) {
        List<HashMap<String,String>> dataFromTable = this.getData();
        Project currentProject;
        HashMap<String,String> currentRow;
        if(expectedData.size()!= dataFromTable.size()) {
            return false;
        }
        while(dataFromTable.size() > 0) {
            int tableSize = dataFromTable.size();
            for(int indexObjectList = 0; indexObjectList < expectedData.size(); indexObjectList++) {
                currentProject = expectedData.get(indexObjectList);
                for(int indexList = 0; indexList < tableSize; indexList++) {
                    currentRow = dataFromTable.get(indexList);
                    if (currentProject.code.equals(currentRow.get(expectedHeaders.get("code")))) {
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
