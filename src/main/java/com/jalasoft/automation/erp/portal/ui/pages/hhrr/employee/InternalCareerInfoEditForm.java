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

    @FindBy(xpath = "(//table[contains(@class,'oe_list_content')])[7]")
    protected WebElement table;

    @FindBy(xpath = "(//div[@class='oe_popup_form']//span[contains(@class,'oe_form_field_many2one')and(not(contains(@class,'invisible')))]/div/input)[1]")
    protected WebElement departmentSelect;

    @FindBy(xpath = "(//div[@class='oe_popup_form']//span[contains(@class,'oe_form_field_many2one')and(not(contains(@class,'invisible')))]/div/input)[2]")
    protected WebElement divisionSelect;

    @FindBy(xpath = "(//div[@class='oe_popup_form']//span[contains(@class,'oe_form_field_many2one')and(not(contains(@class,'invisible')))]/div/input)[3]")
    protected WebElement nameSelect;

    @FindBy(xpath = "(//div[@class='oe_popup_form']//span[contains(@class,'oe_form_field_many2one')and(not(contains(@class,'invisible')))]/div/input)[4]")
    protected WebElement projectCodeSelect;

    @FindBy(xpath = "(//div[contains(@class,'oe_popup_form')]//span[not(contains(@class,'invisible'))]/input[contains(@id,'oe-field-input')])[1]")
    protected WebElement weight;

    @FindBy(xpath = "(//div[@class='oe_popup_form']//span[contains(@class,'oe_form_field_many2one')and(not(contains(@class,'invisible')))]/div/input)[5]")
    protected WebElement managerSelect;

    @FindBy(xpath = "(//div[@class='oe_popup_form']//span[contains(@class,'oe_form_field_many2one')and(not(contains(@class,'invisible')))]/div/input)[6]")
    protected WebElement leadSelect;

    @FindBy(xpath = "(//div[contains(@class,'oe_popup_form')]//span[not(contains(@class,'invisible'))]/input[contains(@id,'oe-field-input')])[1]")
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
    SelectOpenERP name;
    SelectOpenERP projectCode;
    SelectOpenERP manager;
    SelectOpenERP lead;

    public InternalCareerInfoEditForm() {
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

    public void addData(List<InternalCareer> inputData) {
        department = new SelectOpenERP(departmentSelect);
        division = new SelectOpenERP(divisionSelect);
        name = new SelectOpenERP(nameSelect);
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

            if(inputData.get(i).name!= null) {
                name.selectItem(inputData.get(i).name);
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

            if(inputData.get(i).employeer != null) {
                this.webDriverTools.clearAndSendKeys(employer, inputData.get(i).employeer);
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
}
