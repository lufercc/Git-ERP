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

    @FindBy(xpath = "//ul[contains(@class,'oe_form_field_status oe_form_status')]/li[contains(@class,'oe_active')]/span[contains(@class,'label')]")
    protected WebElement currentStateSpan;

    HashMap<String, String> statusList = new HashMap();
    public StatusBar() {
        statusList.put("draft","borrador");
        statusList.put("running","en ejecución");
        statusList.put("evaluation","evaluación");
        statusList.put("assigned","asignado");
        statusList.put("delivered","entregado");
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.container);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.container);
    }

    public String getCurrentStatus() {
            return currentStateSpan.getText().toLowerCase();
    }

    public boolean isInThisStatus(String expStatus) {
        String currentStatus = getCurrentStatus();
        String expectedStatus = statusList.get(expStatus);
        System.out.println("Current: " + currentStatus);
        System.out.println("Expected: " + expectedStatus);
        return (currentStatus.equals(expectedStatus) ? true : false);
    }
}
