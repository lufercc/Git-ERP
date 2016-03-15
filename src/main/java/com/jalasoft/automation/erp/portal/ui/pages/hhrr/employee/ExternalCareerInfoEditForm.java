package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.ExternalCareer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class ExternalCareerInfoEditForm extends TableOpenERP {

    @FindBy(xpath = "//div[contains(text(),'External Career Information')]/following-sibling::table[following-sibling::div[contains(text(),'Internal Career Information')]]//table[contains(@class,'oe_list_content')]")
    protected WebElement table;


    public ExternalCareerInfoEditForm() {
        super.table = this.table;
        expectedSpanishHeaders.put("jobTitle","Puesto");
        expectedSpanishHeaders.put("startDate","Fecha inicio");
        expectedSpanishHeaders.put("endDate","Fecha de finalización");
        expectedSpanishHeaders.put("employer","Empleador");
        expectedEnglishHeaders.put("jobTitle","Job Title");
        expectedEnglishHeaders.put("startDate","Start date");
        expectedEnglishHeaders.put("endDate","End date");
        expectedEnglishHeaders.put("employer","Employer");
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

    public void addData(List<ExternalCareer> inputData) {
        WebElement jobTitle;
        WebElement startDate;
        WebElement endDate;
        WebElement employer;
        WebElement description;

        WebElement addAndContinue;
        WebElement addAndClose;

        for (int i = 0; i < inputData.size(); i++) {
            clickAddElement();

            jobTitle = this.webDriver.findElement(By.xpath("(//div[contains(@class,'oe_popup_form')]//input[contains(@id,'oe-field-input')])[1]"));
            startDate = this.webDriver.findElement(By.name("start_date"));
            endDate = this.webDriver.findElement(By.name("end_date"));
            employer = this.webDriver.findElement(By.xpath("(//div[contains(@class,'oe_popup_form')]//input[contains(@id,'oe-field-input')])[2]"));
            description = this.webDriver.findElement(By.name("description"));

            addAndContinue = this.webDriver.findElement(By.xpath("//div[contains(@class,'ui-dialog-buttonpane')]//button[contains(@class,'oe_abstractformpopup-form-save-new')]"));
            addAndClose = this.webDriver.findElement(By.xpath("(//div[contains(@class,'ui-dialog-buttonpane')]//button[contains(@class,'oe_abstractformpopup-form-save')])[1]"));


            if(inputData.get(i).jobTitle != null) {
                this.webDriverTools.clearAndSendKeys(jobTitle, inputData.get(i).jobTitle);
            }

            if(inputData.get(i).startDate != null) {
                this.webDriverTools.clearAndSendKeys(startDate, inputData.get(i).startDate);
            }

            if(inputData.get(i).endDate != null) {
                this.webDriverTools.clearAndSendKeys(endDate, inputData.get(i).endDate);
            }

            if(inputData.get(i).employer != null) {
                this.webDriverTools.clearAndSendKeys(employer, inputData.get(i).employer);
            }

            if(inputData.get(i).description != null) {
                this.webDriverTools.clearAndSendKeys(description, inputData.get(i).description);
            }

            if (i == (inputData.size() - 1)) {
                addAndClose.click();
            }else {
                addAndContinue.click();
            }

        }
    }

    public void removeData(List<ExternalCareer> inputData) {
        List<HashMap<String, String>> dataFromUITable;
        ExternalCareer currentExpected;
        HashMap<String, String> currentRow;

        for (int i = 0; i < inputData.size(); i++) {
            dataFromUITable = this.getData();
            currentExpected = inputData.get(i);

            for (int uit = 0; uit < dataFromUITable.size(); uit++) {
                currentRow = dataFromUITable.get(uit);
                if (currentExpected.jobTitle.equals(currentRow.get(expectedHeaders.get("jobTitle"))) &&
                    currentExpected.startDate.equals(currentRow.get(expectedHeaders.get("startDate"))) &&
                    currentExpected.endDate.equals(currentRow.get(expectedHeaders.get("endDate"))) &&
                    currentExpected.employer.equals(currentRow.get(expectedHeaders.get("employer")))) {
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
