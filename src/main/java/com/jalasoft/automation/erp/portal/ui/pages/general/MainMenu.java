package com.jalasoft.automation.erp.portal.ui.pages.general;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/15/2015.
 */
public class MainMenu extends PortalUIElement {

    @CacheLookup
    @FindBy(id = "oe_main_menu_placeholder")
    protected WebElement menuContainer;

    @FindBy(xpath = "//ul[@class='oe_menu']//span[contains(text(),'Messaging')]")
    protected WebElement messagesMenu;

    @FindBy(xpath = "//ul[@class='oe_menu']//span[contains(text(),'Human Resources')]")
    protected WebElement hhrrMenu;

    @FindBy(xpath = "//div[@id='oe_main_menu_placeholder']//span[contains(text(),'Employees')]")
    protected WebElement employeesMenu;

    @FindBy(xpath = "//ul[@class='oe_menu']//span[contains(text(),'Evaluación de activos')]")
    protected WebElement assetsMenu;

    @FindBy(xpath = "//ul[@class='oe_menu']//span[contains(text(),'Sales')]")
    protected WebElement salesMenu;

    @FindBy(xpath = "//ul[@class='oe_menu']//span[contains(text(),'Accounting')]")
    protected WebElement accountingMenu;

    @FindBy(xpath = "//ul[@class='oe_menu']//span[contains(text(),'Purchases')]")
    protected WebElement purchasesMenu;

    @FindBy(xpath = "//ul[@class='oe_menu']//span[contains(text(),'Warehouse')]")
    protected WebElement warehouseMenu;

    @FindBy(xpath = "//div[@id='oe_main_menu_placeholder']//a[contains(@data-menu,'logout')]")
    protected WebElement logout;

    @FindBy(xpath = "//div[@id='oe_main_menu_placeholder']/ul[contains(@class,'oe_user_menu_placeholder')]")
    protected WebElement profileContainer;

    @CacheLookup
    @FindBy(xpath = "//div[@id='oe_main_menu_placeholder']/ul[contains(@class,'oe_user_menu_placeholder')]")
    protected WebElement userMenu;

    @CacheLookup
    @FindBy(xpath = "//span[contains(@class,'oe_topbar_name')]")
    protected WebElement userName;



    public MainMenu() {}

    /**
     * This method is to go to some option in main menu
     * @param menu Menu name as string
     **/
    public void goToMenu(String menu) {
        webDriverTools.waitUntilInvisibilityOpenERPProgress();
        switch (menu.toLowerCase()) {
        case "employees":
            webDriverTools.waitUntilElementPresentAndVisible(menuContainer);
            employeesMenu.click();
            break;
        case "hhrr":
            webDriverTools.waitUntilElementPresentAndVisible(hhrrMenu);
            hhrrMenu.click();
            break;

        case "purchases":
            purchasesMenu.click();
            break;

        case "accounting":
            accountingMenu.click();
            break;

        case "warehouse":
            warehouseMenu.click();
            break;

        case "sales":
            salesMenu.click();
            break;

        default:
            throw new IllegalArgumentException("Case value '" + menu + "' for main menu is not defined yet. Add it!!!");
        }
        webDriverTools.waitUntilInvisibilityOpenERPProgress();
    }

    @Override
    public boolean isLoaded() {
        return webDriverTools.isElementDisplayed(menuContainer);
    }

    @Override
    public void waitForLoading() {
        webDriverTools.waitUntilElementPresentAndVisible(menuContainer);
    }

    public void logout() {
        webDriverTools.waitUntilInvisibilityOpenERPProgress();
        webDriverTools.waitUntilElementPresentAndVisible(userName);
        webDriverTools.waitUntilInvisibilityOpenERPProgress();
        userName.click();
        logout.click();
        webDriverTools.waitUntilInvisibilityOpenERPProgress();
        try{
            webDriverTools.clickOnConfirmationAlertOption("Yes");
        } catch (Exception e) {

        }
    }
}
