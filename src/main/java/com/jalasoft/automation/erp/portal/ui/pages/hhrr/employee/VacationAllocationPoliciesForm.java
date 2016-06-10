package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.TagFieldOpenERP;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Susana Taquichiri on 6/6/2016.
 */
public class VacationAllocationPoliciesForm extends TagFieldOpenERP {
    @CacheLookup
    @FindBy(name = "vac_alloc_policy_ids")
    protected WebElement inputField;

    @FindBy(xpath = "//span[@name='vac_alloc_policy_ids']")
    protected List<WebElement> tags;


    public VacationAllocationPoliciesForm() {
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