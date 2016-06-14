package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.objects.hhrr.employee.NDA;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class NDAInfoEditForm extends TableOpenERP {
    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'NDA Info')]/following-sibling::table//table[contains(@class,'oe_list_content')]")
    protected WebElement table;

    public NDAInfoEditForm() {
        super.table = this.table;
        expectedSpanishHeaders.put("ndaVersion","Versión NDA");
        expectedSpanishHeaders.put("signDate","Fecha de firma");
        expectedEnglishHeaders.put("ndaVersion","NDA Version");
        expectedEnglishHeaders.put("signDate","Date of Signature");
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

    public void addData(List<NDA> inputNDAData) {
        try {
            allRecordsWereAdded = false;
            WebElement ndaVersion;
            WebElement signDate;

            for (NDA item : inputNDAData) {
                clickAddElement();
                this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
                this.webDriverTools.waitUntilElementPresentAndVisible(this.webDriver.findElement(By.name("nda_version")));
                ndaVersion = this.webDriver.findElement(By.name("nda_version"));
                signDate = this.webDriver.findElement(By.name("date_of_signature"));
                this.webDriverTools.selectOptionOfDropListElement(ndaVersion, item.ndaVersion);
                this.webDriverTools.clearAndSendKeys(signDate, item.signDate);
                clickFoot();
            }
            allRecordsWereAdded = true;
        } catch (NoSuchElementException nsee) {
            logNotAddedRecords();
        }
    }

    public boolean inputDataIsInRow(OdooObject inputRec, HashMap<String,String> tableRow){return false;}
}
