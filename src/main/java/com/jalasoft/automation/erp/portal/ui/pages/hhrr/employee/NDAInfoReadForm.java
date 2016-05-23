package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.objects.hhrr.employee.NDA;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class NDAInfoReadForm extends TableOpenERP {

    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'NDA Info')]/following-sibling::table//table[contains(@class,'oe_list_content')]")
    protected WebElement table;

    public NDAInfoReadForm() {
        super.table = this.table;
        expectedSpanishHeaders.put("ndaVersion","Versión NDA");
        expectedSpanishHeaders.put("signDate","Fecha de firma");
        expectedEnglishHeaders.put("ndaVersion","NDA Version");
        expectedEnglishHeaders.put("signDate","Date of Signature");
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
        NDA inputRecord = (NDA)inputRec;
        if(inputRecord.ndaVersion != null) {
            if (!inputRecord.ndaVersion.equals(tableRow.get(expectedHeaders.get("ndaVersion")))) {
                return false;
            }
        }
        if(inputRecord.signDate != null) {
            if (!inputRecord.signDate.equals(tableRow.get(expectedHeaders.get("signDate")))){
                return false;
            }
        }
        return true;
    }
}
