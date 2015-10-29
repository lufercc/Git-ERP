package com.jalasoft.automation.erp.portal.ui.pages.general;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

/**
 * Created by Henry Benito on 10/26/2015.
 */
public class StatusBar extends PortalUIElement {
    @FindBy(xpath = "//ul[contains(@class,'oe_form_field_status oe_form_status oe_form_required')]")
    protected WebElement container;

    @FindBy(xpath = "//ul[contains(@class,'oe_form_field_status oe_form_status oe_form_required')]/li[contains(@class,'oe_active')]/span")
    protected WebElement currentStateSpan;

    HashMap<String, String> statusList = new HashMap();
    public StatusBar()
    {
        statusList.put("draft","borrador");
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.container);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.container);
    }

    public String getCurrentStatus()
    {
            return currentStateSpan.getText().toLowerCase();
    }

    public boolean isInThisStatus(String expStatus)
    {
        String currentStatus = getCurrentStatus();
        String expectedStatus = statusList.get(expStatus);
        if(currentStatus.equals(expectedStatus))
            return true;
        return false;
    }
}
