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

    @FindBy(xpath = "(//table[contains(@class,'oe_list_content')])[3]")
    protected WebElement table;


    public EmergencyContactInfoEditForm() {
        super.table = this.table;
        //this.waitForLoading();
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
}
