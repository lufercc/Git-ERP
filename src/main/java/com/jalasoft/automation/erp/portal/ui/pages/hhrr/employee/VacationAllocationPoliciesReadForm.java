package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.TagFieldOpenERP;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Susana Taquichiri on 6/6/2016.
 */
public class VacationAllocationPoliciesReadForm extends TagFieldOpenERP{
    @FindBy(xpath = "//input[contains(@name,'vac_alloc_policy_ids')]/ancestor::div[contains(@class,'many2manytags')]")
    protected WebElement field;


    public VacationAllocationPoliciesReadForm() {
        super.field = this.field;

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
