package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.NDA;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class NDAInfoEditForm extends TableOpenERP {

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
        WebElement ndaVersion;
        WebElement signDate;

        for ( NDA item : inputNDAData) {
            clickAddElement();
            this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
            ndaVersion = this.webDriver.findElement(By.name("nda_version"));
            signDate = this.webDriver.findElement(By.name("date_of_signature"));
            this.webDriverTools.selectOptionOfDropListElement(ndaVersion, item.ndaVersion);
            this.webDriverTools.clearAndSendKeys(signDate, item.signDate);
            clickFoot();
        }
    }

    public void removeData(List<NDA> expectedData) {
        List<HashMap<String, String>> dataFromUITable;
        NDA currentNDA;
        HashMap<String, String> currentRow;

        for (int i = 0; i < expectedData.size(); i++) {
            dataFromUITable = this.getData();
            currentNDA = expectedData.get(i);

            for (int uit = 0; uit < dataFromUITable.size(); uit++) {
                currentRow = dataFromUITable.get(uit);
                if (currentNDA.ndaVersion.equals(currentRow.get(expectedHeaders.get("ndaVersion"))) &&
                    currentNDA.signDate.equals(currentRow.get(expectedHeaders.get("signDate")))) {
                    this.deleteElement(uit);
                    break;
                }
                if (uit == (dataFromUITable.size() - 1)) {
                    System.out.println("No data was found in the table,review input data values");
                }
            }
        }
    }
}
