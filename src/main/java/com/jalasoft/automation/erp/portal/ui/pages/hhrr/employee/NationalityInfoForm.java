package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.TagFieldOpenERP;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class NationalityInfoForm extends TagFieldOpenERP {
    @CacheLookup
    @FindBy(name = "nationality_ids")
    protected WebElement inputField;

    @FindBy(xpath = "//span[@name='nationality_ids']")
    protected List<WebElement> tags;


    public NationalityInfoForm() {
        super.inputField = this.inputField;
        super.tags = this.tags;
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.inputField);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.inputField);
    }
}
