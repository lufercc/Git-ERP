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

    public abstract void modifyData(OdooObject odooObject);
    public abstract OdooObject getDataFromUI(OdooObject odooObject);

    public List<String> getListAffected(){
        return fieldsAffectedByAction;
    }
    public List<String> getListNonAffected(){
        return fieldsNoAffectedByAction;
    }
    public Boolean allFieldsWereAffected(){
        return allFieldsAffected;
    }
}
