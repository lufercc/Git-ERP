package com.jalasoft.automation.erp.portal.ui.pages.hhrr;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/16/2015.
 */
public class Submenu extends PortalUIElement{
    @CacheLookup
    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']")
    protected WebElement submenuContainer;

    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']/div[not(contains(@style,'display: none'))]//span[contains(text(),'Employees')]")
    protected WebElement employees;

    @FindBy(xpath = "//div[@class='oe_secondary_menus_container']/div[not(contains(@style,'display: none'))]//span[contains(text(),'My Information')]")
    protected WebElement myInformation;

    protected String defaultSubmenu = "departments";


    public Submenu() {
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.submenuContainer);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.submenuContainer);
    }

    public void goToSubmenu(String submenu, boolean shouldGo) {
        if(!submenu.equals(defaultSubmenu) || !shouldGo) {
            switch (submenu.toLowerCase()) {
            case "employees":
                webDriverTools.waitUntilElementPresentAndVisible(employees);
                employees.click();
                break;

            case "my information":
                webDriverTools.waitUntilElementPresentAndVisible(myInformation);
                myInformation.click();
                break;

            default:
                throw new IllegalArgumentException("Case value '" + submenu + "' for hhrr submenu is not defined yet!!!");
            }
        }
        webDriverTools.waitUntilInvisibilityOpenERPProgress();
    }
}
