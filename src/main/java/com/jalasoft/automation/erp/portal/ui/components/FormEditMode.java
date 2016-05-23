package com.jalasoft.automation.erp.portal.ui.components;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

import java.util.List;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by Henry Benito on 3/16/2016.
 */
public abstract class FormEditMode extends OdooForm {

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
            fieldsAffectedByAction.add(field);
        } else {
            fieldsNoAffectedByAction.add(field);
            allFieldsAffected = false;
        }
//        try {
//            this.webDriverTools.selectOptionOfDropListElement(element, value);
//            fieldsAffectedByAction.add(field);
//        }catch (NoSuchElementException nsee) {
//            fieldsNoAffectedByAction.add(field);
//            allFieldsAffected = false;
//        }
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

    public void logEditStatus() {
        log = Logger.getLogger(getClass());
        log.info("All fields were updated? ==> " + allFieldsAffected);
        log.info("These fields were updated in the form: " + fieldsAffectedByAction);
        log.info("These fields were NOT updated in the form: " + fieldsNoAffectedByAction);
    }

    public abstract void modifyData(OdooObject input);
    public OdooObject getDataFromUI(OdooObject odooObject) {return null;}
}
