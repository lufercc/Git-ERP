package com.jalasoft.automation.erp.portal.ui.components;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by Henry Benito on 3/16/2016.
 */
public abstract class OdooPopupForm extends OdooForm {

    @FindBy(xpath = "//div[contains(@class,'modal-footer')]//span[contains(text(),'Save & New')]")
    public WebElement addAndContinue;

    @FindBy(xpath = "//div[contains(@class,'modal-footer')]//button[contains(@class,'o_formdialog_save')]")
    public WebElement addAndClose;


    public abstract void modifyData(OdooObject odooObject);
    public abstract OdooObject getDataFromUI(OdooObject odooObject);


}
