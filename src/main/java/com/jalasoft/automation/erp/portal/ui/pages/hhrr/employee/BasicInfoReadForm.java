package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.portal.ui.components.FormReadMode;
import com.jalasoft.automation.erp.objects.hhrr.employee.BasicInfoEmployee;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class BasicInfoReadForm extends FormReadMode {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(xpath = "//h1//span[contains(@class,'oe_form_char_content')]")
    protected WebElement fullName;

    public BasicInfoReadForm() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.dataContainer);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.dataContainer);
    }

    public BasicInfoEmployee getDataFromUI(OdooObject infoFromStepObj) {
        fieldsWereRead = new ArrayList<>();
        fieldsWereNotRead = new ArrayList<>();
        allFieldsWereRead = true;
        BasicInfoEmployee infoFromStep = (BasicInfoEmployee)infoFromStepObj;
        BasicInfoEmployee result = new BasicInfoEmployee();
        if(infoFromStep.fullName != null) {result.fullName = getSpanValue(fullName, "fullName");}
        logReadStatus();
        return result;
    }

}
