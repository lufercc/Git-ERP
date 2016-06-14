package com.jalasoft.automation.erp.portal.ui.components;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.objects.hhrr.employee.FamilyMember;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 1/12/2016.
 */
public abstract class TableOpenERP extends OdooForm {
    protected WebElement table;
    protected int columnsSize;
    protected int rowsSize = -1;
    List<HashMap<String, String>> dataTable;
    protected HashMap<String, String> expectedHeaders;
    protected HashMap<String, String> expectedSpanishHeaders;
    protected HashMap<String, String> expectedEnglishHeaders;
    public List<String> fieldsWereEdited;
    public List<String> fieldsWereNotEdited;
    public Boolean allFieldsWereEdited = true;

    protected boolean allRecordsWereAdded;

    private Logger log;

    public TableOpenERP() {
        expectedSpanishHeaders = new HashMap<>();
        expectedEnglishHeaders = new HashMap<>();
    }

    public List< HashMap<String,String>> getData() {
        List< HashMap<String,String>> result = new ArrayList< HashMap<String,String>>();
        HashMap<String, String> hashMapAux;
        List<String> headersList = getHeaders();
        List<WebElement> tableRecords = table.findElements(By.xpath("./tbody/tr[@data-id]"));
        this.rowsSize = tableRecords.size();
        for (WebElement row : tableRecords) {
            hashMapAux = new HashMap<>();
            List<WebElement> data = row.findElements(By.xpath("./td"));
            for (int i=0 ; i < this.columnsSize ; i++) {
                String auxHeader= headersList.get(i).toString();
                String auxValue= data.get(i).getAttribute("innerHTML");
                hashMapAux.put(auxHeader, auxValue);
            }
            result.add(hashMapAux);
        }
        return result;
    }

    public void getDataFromTable() {
        List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> hashMapAux;
        List<String> headersList = getHeaders();
        List<WebElement> tableRecords = table.findElements(By.xpath("./tbody/tr[@data-id]"));
        this.rowsSize = tableRecords.size();
        for (WebElement row : tableRecords) {
            hashMapAux = new HashMap<>();
            List<WebElement> data = row.findElements(By.xpath("./td"));
            for (int i=0 ; i < this.columnsSize ; i++) {
                String auxHeader= headersList.get(i).toString();
                String auxValue= data.get(i).getAttribute("innerHTML");
                hashMapAux.put(auxHeader, auxValue);
            }
            result.add(hashMapAux);
        }
        this.dataTable = result;
    }

    public boolean hasSameContent(boolean shouldBeAble, List<OdooObject> expectedData) {
        List<HashMap<String,String>> dataFromTable = this.getData();
        HashMap<String,String> currentRow;
        int tableSize;

        if((expectedData.size()!= dataFromTable.size()) && shouldBeAble) {
            return false;
        }

        if (dataFromTable.isEmpty() && !shouldBeAble) {
            return true;
        }
        for(OdooObject currentData : expectedData) {
            tableSize =  dataFromTable.size();
            for(int indexList = 0; indexList < tableSize; indexList++) {
                currentRow = dataFromTable.get(indexList);
                if (shouldBeAble) {
                    if (inputDataIsInRow(currentData,currentRow)) {
                        dataFromTable.remove(currentRow);
                        break;
                    }
                    if (indexList == (tableSize - 1)) {
                        return false;
                    }
                } else {
                    if (inputDataIsInRow(currentData,currentRow)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public abstract boolean inputDataIsInRow(OdooObject inputRec, HashMap<String,String> tableRow);

    public List<String> getHeaders() {
        List<String> result = new ArrayList<>();
        List<WebElement> tableHeaders = table.findElements(By.xpath("./thead/tr[contains(@class,'oe_list_header')]/th/div"));
        this.columnsSize = tableHeaders.size();
        for (WebElement header : tableHeaders) {
            String value = header.getAttribute("innerHTML");
            value = value.replaceAll("\n","");
            value = value.trim();
            result.add(value);
        }
        return result;
    }

    public void clickAddElement() {
        WebElement addElement = table.findElement(By.xpath(".//a[@href='#']"));
        addElement.click();
    }

    public void removeData(List<OdooObject> inputData) {
        List<HashMap<String, String>> dataFromUITable;
        OdooObject currentExpected;
        HashMap<String, String> currentRow;

        for (int i = 0; i < inputData.size(); i++) {
            dataFromUITable = this.getData();
            currentExpected = inputData.get(i);

            for (int uit = 0; uit < dataFromUITable.size(); uit++) {
                currentRow = dataFromUITable.get(uit);
                if (inputDataIsInRow(currentExpected, currentRow)) {
                    this.deleteElement(uit);
                    break;
                }
                if (uit == (dataFromUITable.size() - 1)) {
                    logNotRecordFoundInTable();
                }
            }
        }
    }

    public void deleteAllData() {
        getDataFromTable();
        if (rowsSize > 0) {
            for (int index = 0; index < rowsSize; index++) {
                WebElement deleteElement = table.findElement(By.name("delete"));
                deleteElement.click();
            }
        }
    }

    public void deleteElement(int rowNumber) {
        getDataFromTable();
        if (rowsSize > 0) {
            List<WebElement> deletesButtons = table.findElements(By.name("delete"));
            deletesButtons.get(rowNumber).click();
        }
    }

    public void deleteElementWithConfirmAlert(int rowNumber) {
        getDataFromTable();
        if (rowsSize > 0) {
            List<WebElement> deletesButtons = table.findElements(By.name("delete"));
            deletesButtons.get(rowNumber).click();
            this.webDriverTools.clickOnConfirmationAlertOption("Yes");
        }
    }

    public void clickFoot() {
        WebElement foot = table.findElement(By.xpath("./tfoot"));
        foot.click();
    }

    public void logNotAddedRecords() {
        log = Logger.getLogger(getClass());
        log.warn("Records were not added");
    }

    public void logNotRecordFoundInTable() {
        log = Logger.getLogger(getClass());
        log.warn("No data was found in the table, review input data values");
    }

    public void logNotRecordFoundInTable(String inputRecord) {
        log = Logger.getLogger(getClass());
        log.warn("No data was found in the table, review input data values\n" + inputRecord);
    }


    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.table);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.table);
    }

    public void modifyData(OdooObject odooObject){}
    public OdooObject getDataFromUI(OdooObject odooObject){return null;}
}
