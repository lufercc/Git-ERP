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

    public boolean hasSameContent(boolean shouldBeAble, List<FamilyMember> expectedData) {
        List<HashMap<String,String>> dataFromTable = this.getData();
        HashMap<String,String> currentRow;

        int tableSize;

        if((expectedData.size()!= dataFromTable.size()) && shouldBeAble) {
            return false;
        }

        if (dataFromTable.isEmpty() && !shouldBeAble) {
            return true;
        }
        for(FamilyMember currentFamilyMember : expectedData) {
            tableSize =  dataFromTable.size();
            for(int indexList = 0; indexList < tableSize; indexList++) {
                currentRow = dataFromTable.get(indexList);
                if (shouldBeAble) {
                    if (inputDataIsInRow(currentFamilyMember,currentRow)) {
                        dataFromTable.remove(currentRow);
                        break;
                    }
                    if (indexList == (tableSize - 1)) {
                        return false;
                    }
                } else {
                    if (inputDataIsInRow(currentFamilyMember,currentRow)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean inputDataIsInRow(FamilyMember inputRecord, HashMap<String,String> tableRow) {
        if(inputRecord.name != null) {
            if (!inputRecord.name.equals(tableRow.get(expectedHeaders.get("name")))) {
                return false;
            }
        }
        if(inputRecord.lastName != null) {
            if (!inputRecord.lastName.equals(tableRow.get(expectedHeaders.get("lastName")))){
                return false;
            }
        }
        if(inputRecord.relation != null) {
            if (!inputRecord.relation.equals(tableRow.get(expectedHeaders.get("relation")))) {
                return false;
            }
        }
        if(inputRecord.sex != null) {
            if (!inputRecord.sex.equals(tableRow.get(expectedHeaders.get("sex")))) {
                return false;
            }
        }
        if(inputRecord.birthDate != null) {
            if (!inputRecord.birthDate.equals(tableRow.get(expectedHeaders.get("birthDate")))) {
                return false;
            }
        }
        return true;
    }
}
