package com.jalasoft.automation.erp.portal.ui.pages.general;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/15/2015.
 */
public class MainMenu extends PortalUIElement {

    @FindBy(xpath = "//ul[@class='oe_menu']")
    protected WebElement menuContainer;

    @FindBy(xpath = "//ul[@class='oe_menu']//span[contains(text(),'Mensajería')]")
    protected WebElement messagesMenu;

    @FindBy(xpath = "//ul[@class='oe_menu']//span[contains(text(),'Evaluación de activos')]")
    protected WebElement assetsMenu;

    @FindBy(xpath = "//ul[@class='oe_menu']//span[contains(text(),'Contabilidad')]")
    protected WebElement accountingMenu;

    @FindBy(xpath = "//ul[@class='oe_menu']//span[contains(text(),'Compras')]")
    protected WebElement purchasesMenu;

    @FindBy(linkText = "Cerrar sesión")
    protected WebElement logout;

    @FindBy(xpath = "//span[contains(@class,'oe_topbar_name')]")
    protected WebElement profileContainer;


    /**
     * This method is to go to some option in main menu
     * @param menu Menu name as string
     **/
    public void goToMenu(String menu)
    {
        switch (menu.toLowerCase())
        {
            case "purchases":
                purchasesMenu.click();
                break;
            case "accounting":
                accountingMenu.click();
                break;
        }
    }
    public MainMenu() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.menuContainer);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.purchasesMenu);
    }

    public void logout()
    {
        profileContainer.click();
        logout.click();
    }
}
