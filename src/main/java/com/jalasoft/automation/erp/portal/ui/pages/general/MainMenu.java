package com.jalasoft.automation.erp.portal.ui.pages.general;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/15/2015.
 */
public class MainMenu extends PortalUIElement {

    @FindBy(xpath = "//ul[@class='oe_menu']")
    protected WebElement menuContainer;

    @FindBy(xpath = "//ul[@class='oe_menu']//span[contains(text(),'Mensajería')]")
    protected WebElement messagesMenu;

    @FindBy(xpath = "//ul[@class='oe_menu']//span[contains(text(),'Recursos humanos')]")
    protected WebElement hhrrMenu;

    @FindBy(xpath = "//ul[@class='oe_menu']//span[contains(text(),'Evaluación de activos')]")
    protected WebElement assetsMenu;

    @FindBy(xpath = "//ul[@class='oe_menu']//span[contains(text(),'Ventas')]")
    protected WebElement salesMenu;

    @FindBy(xpath = "//ul[@class='oe_menu']//span[contains(text(),'Contabilidad')]")
    protected WebElement accountingMenu;

    @FindBy(xpath = "//ul[@class='oe_menu']//span[contains(text(),'Compras')]")
    protected WebElement purchasesMenu;

    @FindBy(xpath = "//ul[@class='oe_menu']//span[contains(text(),'Almacén')]")
    protected WebElement warehouseMenu;

    //@FindBy(linkText = "Cerrar sesión")
    @FindBy(xpath = "//a[contains(@data-menu,'logout')]")
    protected WebElement logout;

    @FindBy(xpath = "//span[contains(@class,'oe_topbar_avatar')]")
    protected WebElement profileContainer;

    @FindBy(xpath = "//span[contains(@class,'oe_user_menu')]")
    protected WebElement userMenu;



    /**
     * This method is to go to some option in main menu
     * @param menu Menu name as string
     **/
    public void goToMenu(String menu) {
        switch (menu.toLowerCase()) {
        case "hhrr":
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
        this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
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
        super.webDriverTools.waitUntilElementPresentAndVisible(this.menuContainer);
    }

    public void logout() {
        this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
        userMenu.click();
        logout.click();
        this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
    }
}
