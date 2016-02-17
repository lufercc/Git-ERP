package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.FamilyMember;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class FamilyInfoEditForm extends TableOpenERP {

    @FindBy(xpath = "(//table[contains(@class,'oe_list_content')])[4]")
    protected WebElement table;


    public FamilyInfoEditForm() {
        super.table = this.table;
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
    }
}
