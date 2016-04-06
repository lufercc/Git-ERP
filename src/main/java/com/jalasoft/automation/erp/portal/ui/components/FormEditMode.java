package com.jalasoft.automation.erp.portal.ui.components;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.util.List;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by Henry Benito on 3/16/2016.
 */
public abstract class FormEditMode extends PortalUIElement {
    private Logger log;

    public List<String> fieldsWereEdited;
    public List<String> fieldsWereNotEdited;
    public Boolean allFieldsWereEdited = true;

    public void selectOpenERPItem(SelectOpenERP element, String field, String value) {
        try {
            element.selectItem(value);
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
}
