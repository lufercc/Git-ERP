package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.EmergencyContact;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.FamilyMember;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class FamilyInfoReadForm extends TableOpenERP {

    @FindBy(xpath = "(//table[contains(@class,'oe_list_content')])[5]")
    protected WebElement table;


    public FamilyInfoReadForm() {
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

    public boolean isInTheTable(List<FamilyMember> expectedData) {
        List<HashMap> dataFromTable = this.getData();
        FamilyMember currentFamilyMember;
        HashMap<String,String> currentRow;
        if(expectedData.size()!= dataFromTable.size()) {
            return false;
        }
        while(dataFromTable.size() > 0) {
            int tableSize = dataFromTable.size();
            for(int indexObjectList = 0; indexObjectList < expectedData.size(); indexObjectList++) {
                currentFamilyMember = expectedData.get(indexObjectList);
                for(int indexList = 0; indexList < tableSize; indexList++) {
                    currentRow = dataFromTable.get(indexList);
                    if (currentFamilyMember.name.equals(currentRow.get("Nombres"))) {
                        if (currentFamilyMember.lastName.equals(currentRow.get("Apellidos"))) {
                            if (currentFamilyMember.relation.equals(currentRow.get("Parentesco"))) {
                                if (currentFamilyMember.sex.equals(currentRow.get("Sexo"))) {
                                    if (currentFamilyMember.birthDate.equals(currentRow.get("Fecha de nacimiento"))) {
                                        dataFromTable.remove(currentRow);
                                        break;
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
