package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.portal.ui.components.SelectOpenERP;
import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.objects.hhrr.employee.InternalCareer;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class InternalCareerTable extends TableOpenERP {

    @FindBy(name = "table.hr.career")
    protected WebElement table;

    public InternalCareerTable() {
        super.table = this.table;
        expectedSpanishHeaders.put("department","Departamento");
        expectedSpanishHeaders.put("division","División");
        expectedSpanishHeaders.put("jobTitle","Puesto");
        expectedSpanishHeaders.put("projectCode","Código de proyecto");
        expectedSpanishHeaders.put("weight","Peso");
        expectedSpanishHeaders.put("startDate","Fecha inicio");
        expectedSpanishHeaders.put("endDate","Fecha de finalización");
        expectedSpanishHeaders.put("employer","Empleador");
        expectedEnglishHeaders.put("department","Department");
        expectedEnglishHeaders.put("division","Division");
        expectedEnglishHeaders.put("jobTitle","Job Title");
        expectedEnglishHeaders.put("projectCode","Project Code");
        expectedEnglishHeaders.put("weight","Weight");
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

    public void addData(List<InternalCareer> inputData) {
        try {
            allRecordsWereAdded = false;
            clickAddElement();
            Thread.sleep(1000);
            InternalCareerForm internalCareerForm = new InternalCareerForm();
            for (int i = 0; i < inputData.size(); i++) {
                internalCareerForm.modifyData(inputData.get(i));
                if (i == (inputData.size() - 1)) {
                    internalCareerForm.addAndClose.click();
                } else {
                    internalCareerForm.addAndContinue.click();
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
        InternalCareer inputRecord = (InternalCareer)inputRec;
        if(inputRecord.department != null) {
            if (!inputRecord.department.equals(tableRow.get(expectedHeaders.get("department")))) {
                return false;
            }
        }
        if(inputRecord.division != null) {
            if (!inputRecord.division.equals(tableRow.get(expectedHeaders.get("division")))){
                return false;
            }
        }
        if(inputRecord.jobTitle != null) {
            if (!inputRecord.jobTitle.equals(tableRow.get(expectedHeaders.get("jobTitle")))) {
                return false;
            }
        }
        if(inputRecord.projectCode != null) {
            if (!inputRecord.projectCode.equals(tableRow.get(expectedHeaders.get("projectCode")))) {
                return false;
            }
        }
        if(inputRecord.weight != null) {
            if (!inputRecord.weight.equals(tableRow.get(expectedHeaders.get("weight")))) {
                return false;
            }
        }
        if(inputRecord.startDate != null) {
            if (!inputRecord.startDate.equals(tableRow.get(expectedHeaders.get("startDate")))) {
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
