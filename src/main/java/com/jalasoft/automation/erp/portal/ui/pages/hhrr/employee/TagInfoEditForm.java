package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.TagFieldOpenERP;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class TagInfoEditForm extends TagFieldOpenERP {

    @FindBy(xpath = "//input[contains(@name,'category_ids')]/ancestor::div[contains(@class,'many2manytags')]")
    protected WebElement field;


    public TagInfoEditForm() {
        super.field = this.field;
//        this.waitForLoading();
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
