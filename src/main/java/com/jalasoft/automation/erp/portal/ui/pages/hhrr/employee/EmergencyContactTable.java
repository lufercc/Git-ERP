package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.objects.hhrr.employee.EmergencyContact;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class EmergencyContactTable extends TableOpenERP {

    @FindBy(name = "table.hr.emergency.contact")
    protected WebElement table;


    public EmergencyContactTable() {
        super.table = this.table;
        expectedSpanishHeaders.put("name","Nombre completo");
        expectedSpanishHeaders.put("relationship","Parentesco");
        expectedSpanishHeaders.put("phone","Teléfono");
        expectedSpanishHeaders.put("mobile","Celular");
        expectedEnglishHeaders.put("name","Full Name");
        expectedEnglishHeaders.put("relationship","Relationship");
        expectedEnglishHeaders.put("phone","Home Phone");
        expectedEnglishHeaders.put("mobile","Mobile Phone");
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

    public void addData(List<EmergencyContact> inputData) {
        try {
            allRecordsWereAdded = false;
            clickAddElement();
            Thread.sleep(1000);
            EmergencyContactForm emergencyContactForm = new EmergencyContactForm();
            for (int i = 0; i < inputData.size(); i++) {
                emergencyContactForm.modifyData(inputData.get(i));
                if (i == (inputData.size() - 1)) {
                    emergencyContactForm.addAndClose.click();
                } else {
                    emergencyContactForm.addAndContinue.click();
                }
            }
            allRecordsWereAdded = true;
        } catch (NoSuchElementException nsee) {
            logNotAddedRecords();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean inputDataIsInRow(OdooObject inputRec, HashMap<String,String> tableRow) {
        EmergencyContact inputRecord = (EmergencyContact)inputRec;
        if(inputRecord.name != null) {
            if (!inputRecord.name.equals(tableRow.get(expectedHeaders.get("name")))) {
                return false;
            }
        }
        if(inputRecord.relationship != null) {
            if (!inputRecord.relationship.equals(tableRow.get(expectedHeaders.get("relationship")))){
                return false;
            }
        }
        if(inputRecord.phone != null) {
            if (!inputRecord.phone.equals(tableRow.get(expectedHeaders.get("phone")))) {
                return false;
            }
        }
        if(inputRecord.mobile != null) {
            if (!inputRecord.mobile.equals(tableRow.get(expectedHeaders.get("mobile")))) {
                return false;
            }
        }
        return true;
    }
}
