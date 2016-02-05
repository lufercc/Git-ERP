package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.EmergencyContact;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.Nationality;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class EmergencyContactInfoReadForm extends TableOpenERP {

    @FindBy(xpath = "(//table[contains(@class,'oe_list_content')])[4]")
    protected WebElement table;


    public EmergencyContactInfoReadForm() {
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

    public boolean hasSameContent(List<EmergencyContact> expectedData) {
        List<HashMap> dataFromTable = this.getData();
        EmergencyContact currentEmergencyContact;
        HashMap<String,String> currentRow;
        if(expectedData.size()!= dataFromTable.size()) {
            return false;
        }
        while(dataFromTable.size() > 0) {
            int tableSize = dataFromTable.size();
            for(int indexObjectList = 0; indexObjectList < expectedData.size(); indexObjectList++) {
                currentEmergencyContact = expectedData.get(indexObjectList);
                for(int indexList = 0; indexList < tableSize; indexList++) {
                    currentRow = dataFromTable.get(indexList);
                    if (currentEmergencyContact.name.equals(currentRow.get("Nombre completo")) &&
                        currentEmergencyContact.relationship.equals(currentRow.get("Parentesco")) &&
                        currentEmergencyContact.phone.equals(currentRow.get("Teléfono")) &&
                        currentEmergencyContact.mobile.equals(currentRow.get("Celular"))) {
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
