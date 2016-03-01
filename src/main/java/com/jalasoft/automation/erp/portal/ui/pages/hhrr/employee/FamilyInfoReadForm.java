package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.FamilyMember;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class FamilyInfoReadForm extends TableOpenERP {

    @FindBy(xpath = "//div[contains(text(),'Family Information')]/following-sibling::table//table[contains(@class,'oe_list_content')]")
    protected WebElement table;


    public FamilyInfoReadForm() {
        super.table = this.table;
        this.waitForLoading();
        expectedSpanishHeaders.put("name","Nombres");
        expectedSpanishHeaders.put("lastName","Apellidos");
        expectedSpanishHeaders.put("relation","Parentesco");
        expectedSpanishHeaders.put("sex","Sexo");
        expectedSpanishHeaders.put("birthDate","Fecha de nacimiento");
        expectedEnglishHeaders.put("name","Names");
        expectedEnglishHeaders.put("lastName","Last Name");
        expectedEnglishHeaders.put("relation","Relationship");
        expectedEnglishHeaders.put("sex","Sex");
        expectedEnglishHeaders.put("birthDate","Date of Birth");
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

    public boolean hasSameContent(List<FamilyMember> expectedData) {
        List<HashMap<String,String>> dataFromTable = this.getData();
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
                    if (currentFamilyMember.name.equals(currentRow.get(expectedHeaders.get("name"))) &&
                        currentFamilyMember.lastName.equals(currentRow.get(expectedHeaders.get("lastName"))) &&
                        currentFamilyMember.relation.equals(currentRow.get(expectedHeaders.get("relation"))) &&
                        currentFamilyMember.sex.equals(currentRow.get(expectedHeaders.get("sex"))) &&
                        currentFamilyMember.birthDate.equals(currentRow.get(expectedHeaders.get("birthDate")))) {
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
