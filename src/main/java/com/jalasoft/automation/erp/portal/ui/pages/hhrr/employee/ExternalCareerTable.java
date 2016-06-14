package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.objects.hhrr.employee.ExternalCareer;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class ExternalCareerTable extends TableOpenERP {

    @FindBy(name = "table.hr.external.career")
    protected WebElement table;

    public ExternalCareerTable() {
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

    public void addData(List<ExternalCareer> inputData) {
        try {
            allRecordsWereAdded = false;
            clickAddElement();
            Thread.sleep(1000);
            ExternalCareerForm externalCareerForm = new ExternalCareerForm();

            for (int i = 0; i < inputData.size(); i++) {
                externalCareerForm.modifyData(inputData.get(i));
                if (i == (inputData.size() - 1)) {
                    externalCareerForm.addAndClose.click();
                } else {
                    externalCareerForm.addAndContinue.click();
                }
            }
            allRecordsWereAdded = true;
        } catch (NoSuchElementException nsee) {
            logNotAddedRecords();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
