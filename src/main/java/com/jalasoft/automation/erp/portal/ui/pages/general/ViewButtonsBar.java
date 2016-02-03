package com.jalasoft.automation.erp.portal.ui.pages.general;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class ViewButtonsBar extends PortalUIElement {

    @FindBy(xpath = "//ul[@class='oe_view_manager_switch oe_button_group oe_right']")
    protected WebElement buttonsContainer;

    @FindBy(xpath = "//a[@class='oe_vm_switch_list']")
    protected WebElement listViewButton;


    public ViewButtonsBar() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.buttonsContainer);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.buttonsContainer);
    }

    public void clickButton(String buttonString) {
        this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
        switch (buttonString.toLowerCase()) {
        case "list":
            listViewButton.click();
            break;
        }
        this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
    }
}
