package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.ExternalCareer;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.InternalCareer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class InternalCareerInfoReadForm extends TableOpenERP {

    @FindBy(xpath = "(//table[contains(@class,'oe_list_content')])[8]")
    protected WebElement table;


    public InternalCareerInfoReadForm() {
        super.table = this.table;
        expectedSpanishHeaders.put("department","Departamento");
        expectedSpanishHeaders.put("division","División");
        expectedSpanishHeaders.put("name","Puesto");
        expectedSpanishHeaders.put("projectCode","Código de proyecto");
        expectedSpanishHeaders.put("weight","Peso");
        expectedSpanishHeaders.put("startDate","Fecha inicio");
        expectedSpanishHeaders.put("endDate","Fecha de finalización");
        expectedSpanishHeaders.put("employeer","Empleador");
        expectedHeaders = expectedSpanishHeaders;
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.table);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.table);
    }

    public boolean hasSameContent(List<InternalCareer> expectedData) {
        List<HashMap<String,String>> dataFromTable = this.getData();
        InternalCareer currentInternalCareer;
        HashMap<String,String> currentRow;
        if(expectedData.size()!= dataFromTable.size()) {
            return false;
        }
        while(dataFromTable.size() > 0) {
            int tableSize = dataFromTable.size();
            for(int indexObjectList = 0; indexObjectList < expectedData.size(); indexObjectList++) {
                currentInternalCareer = expectedData.get(indexObjectList);
                for(int indexList = 0; indexList < tableSize; indexList++) {
                    currentRow = dataFromTable.get(indexList);
                    if (currentInternalCareer.department.equals(currentRow.get(expectedHeaders.get("department"))) &&
                        currentInternalCareer.division.equals(currentRow.get(expectedHeaders.get("division"))) &&
                        currentInternalCareer.name.equals(currentRow.get(expectedHeaders.get("name"))) &&
                        currentInternalCareer.projectCode.equals(currentRow.get(expectedHeaders.get("projectCode"))) &&
                        currentInternalCareer.weight.equals(currentRow.get(expectedHeaders.get("weight"))) &&
                        currentInternalCareer.startDate.equals(currentRow.get(expectedHeaders.get("startDate"))) &&
                        currentInternalCareer.endDate.equals(currentRow.get(expectedHeaders.get("endDate"))) &&
                        currentInternalCareer.employeer.equals(currentRow.get(expectedHeaders.get("employeer")))) {
                            dataFromTable.remove(currentRow);
                            break;
                    }
                    if(indexList == (tableSize - 1)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
