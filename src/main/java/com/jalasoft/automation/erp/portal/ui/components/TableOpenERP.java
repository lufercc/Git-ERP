package com.jalasoft.automation.erp.portal.ui.components;

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
public class TableOpenERP extends PortalUIElement {
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


    public void selectOpenERPItem(SelectOpenERP element, String field, String value) {
        try {
            element.selectItem(value);
            fieldsWereEdited.add(field);
        }catch (NoSuchElementException nsee) {
            fieldsWereNotEdited.add(field);
            allFieldsWereEdited = false;
        }
    }

    public void selectOpenERPItem(WebElement element, String field, String value) {
        try {
            SelectOpenERP aux = new SelectOpenERP(element);
            aux.selectItem(value);
            fieldsWereEdited.add(field);
        }catch (NoSuchElementException nsee) {
            fieldsWereNotEdited.add(field);
            allFieldsWereEdited = false;
        }
    }

    public void selectItem(WebElement element, String field, String value) {
        if(this.webDriverTools.isElementDisplayed(element)) {
            this.webDriverTools.selectOptionOfDropListElement(element, value);
            fieldsWereEdited.add(field);
        } else {
            fieldsWereNotEdited.add(field);
            allFieldsWereEdited = false;
        }
//        try {
//            this.webDriverTools.selectOptionOfDropListElement(element, value);
//            fieldsWereEdited.add(field);
//        }catch (NoSuchElementException nsee) {
//            fieldsWereNotEdited.add(field);
//            allFieldsWereEdited = false;
//        }
    }

    public void setInput(WebElement element, String field, String value) {
        try {
            this.webDriverTools.clearAndSendKeys(element, value);
            fieldsWereEdited.add(field);
        }catch (NoSuchElementException nsee) {
            fieldsWereNotEdited.add(field);
            allFieldsWereEdited = false;
        }
    }

    public void setCheckbox(WebElement element, String field, String value) {
        try {
            if (value.equals("true")) {
                this.webDriverTools.checkBox(element);
            }else {
                this.webDriverTools.unCheckBox(element);
            }
            fieldsWereEdited.add(field);
        }catch (NoSuchElementException nsee) {
            fieldsWereNotEdited.add(field);
            allFieldsWereEdited = false;
        }
    }

    public void logEditStatus() {
        log = Logger.getLogger(getClass());
        log.info("All fields were updated? ==> " + allFieldsWereEdited);
        log.info("These fields were updated in the form: " + fieldsWereEdited);
        log.info("These fields were NOT updated in the form: " + fieldsWereNotEdited);
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


    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.table);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.table);
    }
}
