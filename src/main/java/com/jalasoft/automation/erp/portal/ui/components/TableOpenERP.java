package com.jalasoft.automation.erp.portal.ui.components;

import org.openqa.selenium.By;
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
    protected int rowsSize;

    protected HashMap<String, String> expectedHeaders;
    protected HashMap<String, String> expectedSpanishHeaders;

    public TableOpenERP() {
        expectedSpanishHeaders = new HashMap<>();
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

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.table);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.table);
    }
}
