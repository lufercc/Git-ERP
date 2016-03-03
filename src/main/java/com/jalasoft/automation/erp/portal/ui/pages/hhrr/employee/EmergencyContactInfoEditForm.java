package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.EmergencyContact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class EmergencyContactInfoEditForm extends TableOpenERP {

    @FindBy(xpath = "//div[contains(text(),'Emergency Contacts')]/following-sibling::table//table[contains(@class,'oe_list_content')]")
    protected WebElement table;


    public EmergencyContactInfoEditForm() {
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
        WebElement name;
        WebElement relationship;
        WebElement phone;
        WebElement mobile;

        for ( EmergencyContact item : inputData) {
            clickAddElement();
            name = this.webDriver.findElement(By.xpath("//span[contains(@data-fieldname,'name')]/input"));
            relationship = this.webDriver.findElement(By.xpath("//span[contains(@data-fieldname,'relationship')]/input"));
            phone = this.webDriver.findElement(By.xpath("//span[contains(@data-fieldname,'phone')]/input"));
            mobile = this.webDriver.findElement(By.xpath("//span[contains(@data-fieldname,'mobile')]/input"));

            if(item.name != null) {
                this.webDriverTools.clearAndSendKeys(name, item.name);
            }

            if(item.relationship != null) {
                this.webDriverTools.clearAndSendKeys(relationship, item.relationship);
            }

            if(item.phone != null) {
                this.webDriverTools.clearAndSendKeys(phone, item.phone);
            }

            if(item.mobile != null) {
                this.webDriverTools.clearAndSendKeys(mobile, item.mobile);
            }

            clickFoot();
        }
    }

    public void removeData(List<EmergencyContact> inputData) {
        List<HashMap<String, String>> dataFromUITable;
        EmergencyContact currentExpected;
        HashMap<String, String> currentRow;

        for (int i = 0; i < inputData.size(); i++) {
            dataFromUITable = this.getData();
            currentExpected = inputData.get(i);

            for (int uit = 0; uit < dataFromUITable.size(); uit++) {
                currentRow = dataFromUITable.get(uit);
                if (currentExpected.name.equals(currentRow.get(expectedHeaders.get("name"))) &&
                    currentExpected.relationship.equals(currentRow.get(expectedHeaders.get("relationship"))) &&
                    currentExpected.phone.equals(currentRow.get(expectedHeaders.get("phone"))) &&
                    currentExpected.mobile.equals(currentRow.get(expectedHeaders.get("mobile")))) {
                    this.deleteElement(uit);
                    break;
                }
                if (uit == (dataFromUITable.size() - 1)) {
                    System.out.println("No data was found in the table " + getClass().getName() + ",review input data values");
                }
            }
        }
    }
}
