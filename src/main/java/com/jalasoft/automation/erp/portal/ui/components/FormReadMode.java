package com.jalasoft.automation.erp.portal.ui.components;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.util.List;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by Henry Benito on 3/16/2016.
 */
public abstract class FormReadMode extends OdooForm {

    public String getSpanValue(WebElement element, String field) {
        String stringResult;
        try {
            stringResult = element.getAttribute("innerHTML").replace("<br>", "");
            fieldsWereRead.add(field);
        }catch (NoSuchElementException nsee) {
            fieldsWereNotRead.add(field);
            allFieldsWereRead = false;
            stringResult = null;
        }
        return stringResult;
    }

    public String getCheckValue(WebElement element, String field) {
        String stringResult;
        try {
            stringResult = element.getAttribute("checked");
            stringResult = (stringResult == null) ? "false" : "true";
            fieldsWereRead.add(field);
        }catch (NoSuchElementException nsee) {
            fieldsWereNotRead.add(field);
            allFieldsWereRead = false;
            stringResult = null;
        }
        return stringResult;
    }

    public void logReadStatus() {
        log = Logger.getLogger(getClass());
        log.info("All fields were read? ==> " + allFieldsWereRead);
        log.info("These fields were read in the form: " + fieldsWereRead);
        log.info("These fields were NOT read in the form: " + fieldsWereNotRead);
    }

    public void modifyData(OdooObject input){};
    public abstract OdooObject getDataFromUI(OdooObject odooObject);
}
