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

    public abstract void modifyData(OdooObject input);
    public OdooObject getDataFromUI(OdooObject odooObject) {return null;}
}
