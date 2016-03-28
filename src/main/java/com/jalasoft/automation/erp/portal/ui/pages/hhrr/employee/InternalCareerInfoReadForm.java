package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.InternalCareer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class InternalCareerInfoReadForm extends TableOpenERP {

    @FindBy(xpath = "//div[contains(text(),'Internal Career Information')]/following-sibling::table//table[contains(@class,'oe_list_content')]")
    protected WebElement table;


    public InternalCareerInfoReadForm() {
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

    public boolean hasSameContent(boolean shouldBeAble, List<InternalCareer> expectedData) {
        List<HashMap<String,String>> dataFromTable = this.getData();
        HashMap<String,String> currentRow;
        int tableSize;

        if((expectedData.size()!= dataFromTable.size()) && shouldBeAble) {
            return false;
        }

        if(dataFromTable.isEmpty() && !shouldBeAble) {
            return true;
        }

        for(InternalCareer currentInternalCareer : expectedData) {
            tableSize =  dataFromTable.size();
            for(int indexList = 0; indexList < tableSize; indexList++) {
                currentRow = dataFromTable.get(indexList);
                if (shouldBeAble) {
                    if (inputDataIsInRow(currentInternalCareer,currentRow)) {
                        dataFromTable.remove(currentRow);
                        break;
                    }
                    if (indexList == (tableSize - 1)) {
                        return false;
                    }
                } else {
                    if (inputDataIsInRow(currentInternalCareer,currentRow)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean inputDataIsInRow(InternalCareer inputRecord, HashMap<String,String> tableRow) {
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
