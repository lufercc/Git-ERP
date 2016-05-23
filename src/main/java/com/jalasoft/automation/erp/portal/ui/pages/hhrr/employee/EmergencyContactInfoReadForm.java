package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.objects.hhrr.employee.EmergencyContact;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class EmergencyContactInfoReadForm extends TableOpenERP {

    @FindBy(xpath = "//div[contains(text(),'Emergency Contacts')]/following-sibling::table//table[contains(@class,'oe_list_content')]")
    protected WebElement table;


    public EmergencyContactInfoReadForm() {
        super.table = this.table;
        expectedSpanishHeaders.put("name","Nombre completo");
        expectedSpanishHeaders.put("relationship","Parentesco");
        expectedSpanishHeaders.put("phone","Teléfono");
        expectedSpanishHeaders.put("mobile","Celular");
        expectedEnglishHeaders.put("name","Full Name");
        expectedEnglishHeaders.put("relationship","Relationship");
        expectedEnglishHeaders.put("phone","Home Phone");
        expectedEnglishHeaders.put("mobile","Mobile Phone");
        expectedHeaders = expectedEnglishHeaders;

    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.table);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.table);
    }

    public boolean inputDataIsInRow(OdooObject inputRec, HashMap<String,String> tableRow) {
        EmergencyContact inputRecord = (EmergencyContact)inputRec;
        if(inputRecord.name != null) {
            if (!inputRecord.name.equals(tableRow.get(expectedHeaders.get("name")))) {
                return false;
            }
        }
        if(inputRecord.relationship != null) {
            if (!inputRecord.relationship.equals(tableRow.get(expectedHeaders.get("relationship")))){
                return false;
            }
        }
        if(inputRecord.phone != null) {
            if (!inputRecord.phone.equals(tableRow.get(expectedHeaders.get("phone")))) {
                return false;
            }
        }
        if(inputRecord.mobile != null) {
            if (!inputRecord.mobile.equals(tableRow.get(expectedHeaders.get("mobile")))) {
                return false;
            }
        }
        return true;
    }
}
