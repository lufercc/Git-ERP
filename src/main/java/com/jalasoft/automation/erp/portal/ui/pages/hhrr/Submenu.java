package com.jalasoft.automation.erp.portal.ui.pages.hhrr;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/16/2015.
 */
public class Submenu extends PortalUIElement{

    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']")
    protected WebElement submenuContainer;

    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']/div[not(contains(@style,'display: none'))]//span[contains(text(),'Employees')]")
    protected WebElement employees;

    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']/div[not(contains(@style,'display: none'))]//span[contains(text(),'My Information')]")
    protected WebElement myInformation;

    protected String defaultSubmenu = "employees";


    public Submenu() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.submenuContainer);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.submenuContainer);
    }

    public void goToSubmenu(String submenu) {
        if(!submenu.equals(defaultSubmenu)) {
            switch (submenu.toLowerCase()) {
            case "employees":
                employees.click();
                break;

            case "my information":
                myInformation.click();
                break;

            default:
                throw new IllegalArgumentException("Case value '" + submenu + "' for hhrr submenu is not defined yet!!!");
            }
        }
        this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
    }
}
