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

    public boolean isInTheTable(List<InternalCareer> expectedData) {
        List<HashMap> dataFromTable = this.getData();
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
                    if (currentInternalCareer.department.equals(currentRow.get("Departamento"))) {
                        if (currentInternalCareer.division.equals(currentRow.get("División"))) {
                            if (currentInternalCareer.name.equals(currentRow.get("Puesto"))) {
                                if (currentInternalCareer.projectCode.equals(currentRow.get("Código de proyecto"))) {
                                    if (currentInternalCareer.weight.equals(currentRow.get("Peso"))) {
                                        if (currentInternalCareer.startDate.equals(currentRow.get("Fecha inicio"))) {
                                            if (currentInternalCareer.endDate.equals(currentRow.get("Fecha de finalización"))) {
                                                if (currentInternalCareer.employeer.equals(currentRow.get("Empleador"))) {
                                                    dataFromTable.remove(currentRow);
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
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
