package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.objects.hhrr.employee.FamilyMember;
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
public class FamilyInfoTable extends TableOpenERP {
    @CacheLookup
    @FindBy(name = "table.hr.dependent")
    protected WebElement table;

    @FindBy(xpath = "//table//input[@name='name']")
    protected WebElement name;

    @FindBy(name = "last_name")
    protected WebElement lastName;

    @FindBy(xpath = "//select[@name='relation']")
    protected WebElement relation;

    @FindBy(xpath = "//select[@name='sex']")
    protected WebElement sex;

    @FindBy(xpath = "//input[@name='day_of_birth']")
    protected WebElement birthDate;

    public FamilyInfoTable() {
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

    public void addData(List<FamilyMember> inputData) {
        try {
            allRecordsWereAdded = false;

            for ( FamilyMember item : inputData) {
                clickAddElement();

                if(item.name != null) {
                    this.webDriverTools.clearAndSendKeys(name, item.name);
                }

                if(item.lastName != null) {
                    this.webDriverTools.clearAndSendKeys(lastName, item.lastName);
                }

                if(item.relation != null) {
                    this.webDriverTools.selectOptionOfDropListElement(relation, item.relation);
                }

                if(item.sex != null) {
                    this.webDriverTools.selectOptionOfDropListElement(sex, item.sex);
                }

                if(item.birthDate != null) {
                    this.webDriverTools.clearAndSendKeys(birthDate, item.birthDate);
                }
                clickFoot();
            }
            allRecordsWereAdded = true;
        } catch (NoSuchElementException nsee) {
            logNotAddedRecords();
        }
    }

    public boolean inputDataIsInRow(OdooObject inputRec, HashMap<String,String> tableRow) {
        FamilyMember inputRecord = (FamilyMember)inputRec;
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
