package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.FamilyMember;
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
public class FamilyInfoEditForm extends TableOpenERP {
    @CacheLookup
    @FindBy(xpath = "//div[contains(text(),'Family Information')]/following-sibling::table//table[contains(@class,'oe_list_content')]")
    protected WebElement table;


    public FamilyInfoEditForm() {
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
            WebElement name;
            WebElement lastName;
            WebElement relation;
            WebElement sex;
            WebElement birthDate;

            for ( FamilyMember item : inputData) {
                clickAddElement();

                name = this.webDriver.findElement(By.xpath("(//span[contains(@data-fieldname,'name')]/input)[2]"));
                lastName = this.webDriver.findElement(By.xpath("//span[contains(@data-fieldname,'last_name')]/input"));
                relation = this.webDriver.findElement(By.name("relation"));
                sex = this.webDriver.findElement(By.name("sex"));
                birthDate = this.webDriver.findElement(By.name("day_of_birth"));


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

    public void removeData(List<FamilyMember> inputData) {
        List<HashMap<String, String>> dataFromUITable;
        FamilyMember currentExpected;
        HashMap<String, String> currentRow;

        for (int i = 0; i < inputData.size(); i++) {
            dataFromUITable = this.getData();
            currentExpected = inputData.get(i);

            for (int uit = 0; uit < dataFromUITable.size(); uit++) {
                currentRow = dataFromUITable.get(uit);
                if (currentExpected.name.equals(currentRow.get(expectedHeaders.get("name"))) &&
                    currentExpected.lastName.equals(currentRow.get(expectedHeaders.get("lastName"))) &&
                    currentExpected.relation.equals(currentRow.get(expectedHeaders.get("relation"))) &&
                    currentExpected.sex.equals(currentRow.get(expectedHeaders.get("sex"))) &&
                    currentExpected.birthDate.equals(currentRow.get(expectedHeaders.get("birthDate")))) {
                    this.deleteElement(uit);
                    break;
                }
                if (uit == (dataFromUITable.size() - 1)) {
                    logNotRecordFoundInTable();
                }
            }
        }
    }
}
