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

    @FindBy(xpath = "(//table[contains(@class,'oe_list_content')])[2]")
    protected WebElement table;


    public NDAInfoEditForm() {
        super.table = this.table;
//        this.waitForLoading();
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
            ndaVersion = this.webDriver.findElement(By.name("nda_version"));
            signDate = this.webDriver.findElement(By.name("date_of_signature"));
            this.webDriverTools.selectOptionOfDropListElement(ndaVersion, item.ndaVersion);
            this.webDriverTools.clearAndSendKeys(signDate, item.signDate);
            clickFoot();
        }
    }
}
