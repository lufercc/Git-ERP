package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.TagFieldOpenERP;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class OtherSupervisorsInfoEditForm extends TagFieldOpenERP {

    @CacheLookup
    @FindBy(xpath = "//label[contains(text(),'Other Supervisors')]/ancestor::td/following-sibling::td/div[contains(@class,'oe_form_field oe_tags')]")
    protected WebElement field;


    public OtherSupervisorsInfoEditForm() {
        super.field = this.field;
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.field);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.field);
    }
}
