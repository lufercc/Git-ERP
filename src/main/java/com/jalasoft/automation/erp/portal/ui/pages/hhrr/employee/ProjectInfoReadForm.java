package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.objects.hhrr.employee.Project;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class ProjectInfoReadForm extends TableOpenERP {

    @FindBy(xpath = "//label[contains(text(),'Project Codes')]/ancestor::td/following-sibling::td//table")
    protected WebElement table;

    public ProjectInfoReadForm() {
        super.table = this.table;
        expectedSpanishHeaders.put("code","Código de proyecto");
        expectedEnglishHeaders.put("code","Project Code");
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

    public boolean inputDataIsInRow(OdooObject inputRec, HashMap<String,String> tableRow) {
        Project inputRecord = (Project)inputRec;
        if(inputRecord.code != null) {
            if (!inputRecord.code.equals(tableRow.get(expectedHeaders.get("code")))) {
                return false;
            }
        }
        return true;
    }
}
