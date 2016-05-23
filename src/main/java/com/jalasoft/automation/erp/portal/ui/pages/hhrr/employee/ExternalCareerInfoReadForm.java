package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.objects.hhrr.employee.ExternalCareer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class ExternalCareerInfoReadForm extends TableOpenERP {

    @FindBy(xpath = "//div[contains(text(),'External Career Information')]/following-sibling::table[following-sibling::div[contains(text(),'Internal Career Information')]]//table[contains(@class,'oe_list_content')]")
    protected WebElement table;


    public ExternalCareerInfoReadForm() {
        super.table = this.table;
        expectedSpanishHeaders.put("jobTitle","Puesto");
        expectedSpanishHeaders.put("startDate","Fecha inicio");
        expectedSpanishHeaders.put("endDate","Fecha de finalización");
        expectedSpanishHeaders.put("employer","Empleador");
        expectedEnglishHeaders.put("jobTitle","Job Title");
        expectedEnglishHeaders.put("startDate","Start date");
        expectedEnglishHeaders.put("endDate","End date");
        expectedEnglishHeaders.put("employer","Employer");
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
        ExternalCareer inputRecord = (ExternalCareer)inputRec;
        if(inputRecord.jobTitle != null) {
            if (!inputRecord.jobTitle.equals(tableRow.get(expectedHeaders.get("jobTitle")))) {
                return false;
            }
        }
        if(inputRecord.startDate != null) {
            if (!inputRecord.startDate.equals(tableRow.get(expectedHeaders.get("startDate")))){
                return false;
            }
        }
        if(inputRecord.endDate != null) {
            if (!inputRecord.endDate.equals(tableRow.get(expectedHeaders.get("endDate")))) {
                return false;
            }
        }
        if(inputRecord.employer != null) {
            if (!inputRecord.employer.equals(tableRow.get(expectedHeaders.get("employer")))) {
                return false;
            }
        }
        return true;
    }
}
