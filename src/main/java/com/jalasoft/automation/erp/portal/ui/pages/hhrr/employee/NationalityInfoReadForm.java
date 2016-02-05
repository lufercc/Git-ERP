package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.NDA;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.Nationality;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class NationalityInfoReadForm extends TableOpenERP {

    @FindBy(xpath = "(//table[contains(@class,'oe_list_content')])[2]")
    protected WebElement table;


    public NationalityInfoReadForm() {
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

    public boolean isInTheTable(List<Nationality> expectedData) {
        List<HashMap> dataFromTable = this.getData();
        Nationality currentNationality;
        HashMap<String,String> currentRow;
        if(expectedData.size()!= dataFromTable.size()) {
            return false;
        }
        while(dataFromTable.size() > 0) {
            int tableSize = dataFromTable.size();
            for(int indexNationalityList = 0; indexNationalityList < expectedData.size(); indexNationalityList++) {
                currentNationality = expectedData.get(indexNationalityList);
                for(int indexList = 0; indexList < tableSize; indexList++) {
                    currentRow = dataFromTable.get(indexList);
                    if (currentNationality.name.equals(currentRow.get("Nombre del país"))) {
                        if (currentNationality.code.equals(currentRow.get("Código de país"))) {
                            dataFromTable.remove(currentRow);
                            break;
                        }
                    }
                    if(indexList == (tableSize - 1))
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
