package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.objects.hhrr.employee.Nationality;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class NationalityInfoReadForm extends TableOpenERP {

    @FindBy(xpath = "//label[contains(text(),'Nationalities')]/ancestor::td/following-sibling::td//table[contains(@class,'oe_list_content')]")
    protected WebElement table;

    public HashMap<String, String> expectedHeaders;
    public HashMap<String, String> expectedSpanishHeaders;


    public NationalityInfoReadForm() {
        super.table = this.table;

        expectedSpanishHeaders = new HashMap<>();
        expectedSpanishHeaders.put("name","Nombre del país");
        expectedSpanishHeaders.put("code","Código de país");
        expectedEnglishHeaders.put("name","Country Name");
        expectedEnglishHeaders.put("code","Country Code");
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
        Nationality inputRecord = (Nationality)inputRec;
        if(inputRecord.name != null) {
            if (!inputRecord.name.equals(tableRow.get(expectedHeaders.get("name")))) {
                return false;
            }
        }
        if(inputRecord.code != null) {
            if (!inputRecord.code.equals(tableRow.get(expectedHeaders.get("code")))){
                return false;
            }
        }
        return true;
    }
}
