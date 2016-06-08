package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.objects.hhrr.employee.Tag;
import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.objects.hhrr.employee.Nationality;
import com.jalasoft.automation.erp.portal.ui.pages.general.PopupSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class NationalityInfoEditForm extends TableOpenERP {

    @FindBy(xpath = ".//table//td//label[contains(text(),'Nationalities')]/following::td")
    protected WebElement field;
    protected int tableSize = 100000;

    public NationalityInfoEditForm() {
        super.table = this.table;
        expectedSpanishHeaders.put("name","Nombre del país");
        expectedSpanishHeaders.put("code","Código de país");
        expectedEnglishHeaders.put("name","Country Name");
        expectedEnglishHeaders.put("code","Country Code");
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

    public void addData(List<Nationality> inputData) {
        try {
            allRecordsWereAdded = false;
            WebElement tagTextField = field.findElement(By.xpath(".//input[contains(@name,'nationality_ids')]"));
            if (webDriverTools.isElementDisplayed(tagTextField)) {
                for (Nationality nationality : inputData) {
                    tagTextField.sendKeys(nationality.name);
                    this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
                    WebElement suggestedValue = webDriver.findElement(By.xpath("//ul[contains(@class,'ui-autocomplete') and contains(@style,'display: block')]//a[contains(text(),'" + nationality.name + "')]"));
                    suggestedValue.click();
                }
                allRecordsWereAdded = true;
            } else {
                logNotAddedRecords();
            }
        } catch (NoSuchElementException nsee) {
            logNotAddedRecords();
        }
    }

    public void removeData(List<Nationality> inputData) {
        List<HashMap<String, String>> dataFromUITable;
        Nationality currentExpected;
        HashMap<String, String> currentRow;

        for (int i = 0; i < inputData.size(); i++) {
            dataFromUITable = this.getData();
            currentExpected = inputData.get(i);

            for (int uit = 0; uit < dataFromUITable.size(); uit++) {
                currentRow = dataFromUITable.get(uit);
                if (currentExpected.name.equals(currentRow.get(expectedHeaders.get("name"))) &&
                    currentExpected.code.equals(currentRow.get(expectedHeaders.get("code")))) {
                    this.deleteElementWithConfirmAlert(uit);
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