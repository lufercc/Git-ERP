package com.jalasoft.automation.erp.portal.ui.components;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Henry Benito on 3/16/2016.
 */
public abstract class OdooForm extends PortalUIElement {
    protected Logger log;

    public List<String> fieldsAffectedByAction;
    public List<String> fieldsNoAffectedByAction;
    public Boolean allFieldsAffected;

    public List<String> fieldsWereEdited ;
    public List<String> fieldsWereNotEdited;
    public Boolean allFieldsWereEdited;

    public List<String> fieldsWereRead;
    public List<String> fieldsWereNotRead;
    public Boolean allFieldsWereRead;

    public void selectOpenERPItem(SelectOpenERP element, String field, String value) {
        try {
            element.selectItem(value);
            fieldsAffectedByAction.add(field);
        }catch (NoSuchElementException nsee) {
            fieldsNoAffectedByAction.add(field);
            allFieldsAffected = false;
        }
    }

    public void selectOERPItemFromPartialText(WebElement element, String field, String value) {
        try {
            SelectOpenERP aux = new SelectOpenERP(element);
            aux.selectItemFromPartialItem(value);
            fieldsAffectedByAction.add(field);
        }catch (NoSuchElementException nsee) {
            fieldsNoAffectedByAction.add(field);
            allFieldsAffected = false;
        }
    }

    public void selectOpenERPItem(WebElement element, String field, String value) {
        try {
            SelectOpenERP aux = new SelectOpenERP(element);
            aux.selectItem(value);
            fieldsAffectedByAction.add(field);
        }catch (NoSuchElementException nsee) {
            fieldsNoAffectedByAction.add(field);
            allFieldsAffected = false;
        }
    }

    public void selectItem(WebElement element, String field, String value) {
        if(this.webDriverTools.isElementDisplayed(element)) {
            this.webDriverTools.selectOptionOfDropListElement(element, value);
            fieldsAffectedByAction.add(field);
        } else {
            fieldsNoAffectedByAction.add(field);
            allFieldsAffected = false;
        }
    }

    public void setInput(WebElement element, String field, String value) {
        try {
            this.webDriverTools.clearAndSendKeys(element, value);
            fieldsAffectedByAction.add(field);
        }catch (NoSuchElementException nsee) {
            fieldsNoAffectedByAction.add(field);
            allFieldsAffected = false;
        }
    }

    public void setCheckbox(WebElement element, String field, String value) {
        try {
            if (value.equals("true")) {
                this.webDriverTools.checkBox(element);
            }else {
                this.webDriverTools.unCheckBox(element);
            }
            fieldsAffectedByAction.add(field);
        }catch (NoSuchElementException nsee) {
            fieldsNoAffectedByAction.add(field);
            allFieldsAffected = false;
        }
    }

    public List<String> getListAffected(){
        return fieldsAffectedByAction;
    }
    public List<String> getListNonAffected(){
        return fieldsNoAffectedByAction;
    }
    public Boolean allFieldsWereAffected(){
        return allFieldsAffected;
    }

    public void logEditStatus(boolean editAction) {
        String action = (editAction)?"edited":"read";
        log = Logger.getLogger(getClass());
        log.info("All fields were " + action + "? ==> " + allFieldsAffected);
        log.info("These fields were " + action + " in the form: " + fieldsAffectedByAction);
        log.info("These fields were NOT " + action + " in the form: " + fieldsNoAffectedByAction);
    }
    public abstract void modifyData(OdooObject odooObject);
    public abstract OdooObject getDataFromUI(OdooObject odooObject);
}
