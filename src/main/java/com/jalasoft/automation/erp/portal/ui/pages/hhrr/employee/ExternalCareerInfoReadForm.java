package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.ExternalCareer;
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
        expectedSpanishHeaders.put("name","Puesto");
        expectedSpanishHeaders.put("startDate","Fecha inicio");
        expectedSpanishHeaders.put("endDate","Fecha de finalización");
        expectedSpanishHeaders.put("employer","Empleador");
        expectedEnglishHeaders.put("name","Job Title");
        expectedEnglishHeaders.put("startDate","Start date");
        expectedEnglishHeaders.put("endDate","End date");
        expectedEnglishHeaders.put("employer","Employer");
        expectedHeaders = expectedEnglishHeaders;
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

    public boolean hasSameContent(List<ExternalCareer> expectedData) {
        List<HashMap<String,String>> dataFromTable = this.getData();
        ExternalCareer currentExternalCareer;
        HashMap<String,String> currentRow;
        if(expectedData.size()!= dataFromTable.size()) {
            return false;
        }
        while(dataFromTable.size() > 0) {
            int tableSize = dataFromTable.size();
            for(int indexObjectList = 0; indexObjectList < expectedData.size(); indexObjectList++) {
                currentExternalCareer = expectedData.get(indexObjectList);
                for(int indexList = 0; indexList < tableSize; indexList++) {
                    currentRow = dataFromTable.get(indexList);
                    if (currentExternalCareer.name.equals(currentRow.get(expectedHeaders.get("name"))) &&
                        currentExternalCareer.startDate.equals(currentRow.get(expectedHeaders.get("startDate"))) &&
                        currentExternalCareer.endDate.equals(currentRow.get(expectedHeaders.get("endDate"))) &&
                        currentExternalCareer.employeer.equals(currentRow.get(expectedHeaders.get("employer")))) {
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
