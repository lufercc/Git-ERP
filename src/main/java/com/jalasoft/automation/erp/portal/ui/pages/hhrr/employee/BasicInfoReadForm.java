package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.BasicInfoEmployee;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class BasicInfoReadForm extends PortalUIElement {

    @FindBy(xpath = "//div[@class='oe_title']")
    protected WebElement dataContainer;

    @FindBy(xpath = "//h1//span[contains(@class,'oe_form_char_content')]")
    protected WebElement employeeFullName;

    public BasicInfoReadForm() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.dataContainer);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.dataContainer);
    }

    public BasicInfoEmployee getMainData() {
        BasicInfoEmployee result = new BasicInfoEmployee();
        result.fullName = employeeFullName.getAttribute("innerHTML");
        return result;
    }

}
