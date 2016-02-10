package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.portal.ui.components.TagFieldOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.NDA;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.Tag;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class TagInfoReadForm extends TagFieldOpenERP {

    @FindBy(xpath = "(//div[contains(@class,'oe_form_field oe_tags')])[1]")
    protected WebElement field;


    public TagInfoReadForm() {
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
