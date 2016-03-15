package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.SelectOpenERP;
import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.InternalCareer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class InternalCareerInfoEditForm extends TableOpenERP {

    @FindBy(xpath = "//div[contains(text(),'Internal Career Information')]/following-sibling::table//table[contains(@class,'oe_list_content')]")
    protected WebElement table;

    @FindBy(xpath = "//div[@class='oe_popup_form']//label[contains(text(),'Department')]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement departmentSelect;

    @FindBy(xpath = "//div[@class='oe_popup_form']//label[contains(text(),'Division')]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement divisionSelect;

    @FindBy(xpath = "//div[@class='oe_popup_form']//label[contains(text(),'Job Title')]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement nameSelect;

    @FindBy(xpath = "//div[@class='oe_popup_form']//label[contains(text(),'Project Assignation')]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement projectCodeSelect;

    @FindBy(xpath = "//div[@class='oe_popup_form']//label[contains(text(),'Weight')]/ancestor::td/following-sibling::td/span/input")
    protected WebElement weight;

    @FindBy(xpath = "//div[@class='oe_popup_form']//label[contains(text(),'Manager')]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement managerSelect;

    @FindBy(xpath = "//div[@class='oe_popup_form']//label[contains(text(),'Lead')]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement leadSelect;

    @FindBy(xpath = "//div[@class='oe_popup_form']//label[contains(text(),'Employer')]/ancestor::td/following-sibling::td/span/input")
    protected WebElement employer;

    @FindBy(name = "start_date")
    protected WebElement startDate;

    @FindBy(name = "end_date")
    protected WebElement endDate;

    @FindBy(name = "description")
    protected WebElement description;

    @FindBy(xpath = "//div[contains(@class,'ui-dialog-buttonpane')]//button[contains(@class,'oe_abstractformpopup-form-save-new')]")
    protected WebElement addAndContinue;

    @FindBy(xpath = "(//div[contains(@class,'ui-dialog-buttonpane')]//button[contains(@class,'oe_abstractformpopup-form-save')])[1]")
    protected WebElement addAndClose;

    SelectOpenERP department;
    SelectOpenERP division;
    SelectOpenERP jobTitle;
    SelectOpenERP projectCode;
    SelectOpenERP manager;
    SelectOpenERP lead;

    public InternalCareerInfoEditForm() {
        super.table = this.table;
        expectedSpanishHeaders.put("department","Departamento");
        expectedSpanishHeaders.put("division","División");
        expectedSpanishHeaders.put("jobTitle","Puesto");
        expectedSpanishHeaders.put("projectCode","Código de proyecto");
        expectedSpanishHeaders.put("weight","Peso");
        expectedSpanishHeaders.put("startDate","Fecha inicio");
        expectedSpanishHeaders.put("endDate","Fecha de finalización");
        expectedSpanishHeaders.put("employer","Empleador");
        expectedEnglishHeaders.put("department","Department");
        expectedEnglishHeaders.put("division","Division");
        expectedEnglishHeaders.put("jobTitle","Job Title");
        expectedEnglishHeaders.put("projectCode","Project Code");
        expectedEnglishHeaders.put("weight","Weight");
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

    public void addData(List<InternalCareer> inputData) {
        department = new SelectOpenERP(departmentSelect);
        division = new SelectOpenERP(divisionSelect);
        jobTitle = new SelectOpenERP(nameSelect);
        projectCode = new SelectOpenERP(projectCodeSelect);
        manager = new SelectOpenERP(managerSelect);
        lead = new SelectOpenERP(leadSelect);

        for (int i = 0; i < inputData.size(); i++) {
            clickAddElement();

            if(inputData.get(i).department != null) {
                department.selectItem(inputData.get(i).department);
            }

            if(inputData.get(i).division != null) {
                division.selectItem(inputData.get(i).division);
            }

            if(inputData.get(i).jobTitle!= null) {
                jobTitle.selectItem(inputData.get(i).jobTitle);
            }

            if(inputData.get(i).projectCode != null) {
                projectCode.selectItem(inputData.get(i).projectCode);
            }

            if(inputData.get(i).weight != null) {
                this.webDriverTools.clearAndSendKeys(weight, inputData.get(i).weight);
                employer = this.webDriver.findElement(By.xpath("(//div[contains(@class,'oe_popup_form')]//span[not(contains(@class,'invisible'))]/input[contains(@id,'oe-field-input')])[2]"));
            }

            if(inputData.get(i).manager != null) {
                manager.selectItem(inputData.get(i).manager);
            }

            if(inputData.get(i).lead != null) {
                lead.selectItem(inputData.get(i).lead);
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

    public void removeData(List<InternalCareer> inputData) {
        List<HashMap<String, String>> dataFromUITable;
        InternalCareer currentExpected;
        HashMap<String, String> currentRow;

        for (int i = 0; i < inputData.size(); i++) {
            dataFromUITable = this.getData();
            currentExpected = inputData.get(i);

            for (int uit = 0; uit < dataFromUITable.size(); uit++) {
                currentRow = dataFromUITable.get(uit);
                if (currentExpected.department.equals(currentRow.get(expectedHeaders.get("department"))) &&
                    currentExpected.division.equals(currentRow.get(expectedHeaders.get("division"))) &&
                    currentExpected.jobTitle.equals(currentRow.get(expectedHeaders.get("jobTitle"))) &&
                    currentExpected.projectCode.equals(currentRow.get(expectedHeaders.get("projectCode"))) &&
                    currentExpected.weight.equals(currentRow.get(expectedHeaders.get("weight"))) &&
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
