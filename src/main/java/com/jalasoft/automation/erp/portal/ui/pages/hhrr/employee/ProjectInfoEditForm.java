package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.objects.hhrr.employee.Project;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class ProjectInfoEditForm extends TableOpenERP {
    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Project Codes')]/ancestor::td/following-sibling::td//table")
    protected WebElement table;

    public ProjectInfoEditForm() {
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

    public void addData(List<Project> inputNDAData) {
        try {
            allRecordsWereAdded = false;
            WebElement code;

            for (Project item : inputNDAData) {
                clickAddElement();
                this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
                this.webDriverTools.waitUntilElementPresentAndVisible(this.webDriver.findElement(By.name("full_code")));
                code = this.webDriver.findElement(By.name("full_code"));
                this.webDriverTools.clearAndSendKeys(code, item.code);
                clickFoot();
            }
            allRecordsWereAdded = true;
        } catch (NoSuchElementException nsee) {
            logNotAddedRecords();
        }
    }

    public void removeData(List<Project> expectedData) {
        List<HashMap<String, String>> dataFromUITable;
        Project currentProject;
        HashMap<String, String> currentRow;

        for (int i = 0; i < expectedData.size(); i++) {
            dataFromUITable = this.getData();
            currentProject = expectedData.get(i);

            for (int uit = 0; uit < dataFromUITable.size(); uit++) {
                currentRow = dataFromUITable.get(uit);
                if (currentProject.code.equals(currentRow.get(expectedHeaders.get("code")))) {
                    this.deleteElement(uit);
                    break;
                }
                if (uit == (dataFromUITable.size() - 1)) {
                    logNotRecordFoundInTable();
                }
            }
        }
    }

    public boolean inputDataIsInRow(OdooObject inputRec, HashMap<String,String> tableRow){return false;}
}
