package com.jalasoft.automation.erp.steps.selog.sales;

import com.jalasoft.automation.erp.portal.ui.pages.general.MainMenu;
import com.jalasoft.automation.erp.portal.ui.pages.selog.sales.ButtonsBar;
import com.jalasoft.automation.erp.portal.ui.pages.selog.sales.Submenu;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;

/**
 * Created by Henry Benito on 11/9/2015.
 */
public class SalesNavigationSteps {
    @And("^I go to \"([^\"]*)\" sales submenu$")
    public void I_go_to_sales_submenu(String submenuString) throws Throwable {
        MainMenu mainMenu = new MainMenu();
        Submenu salesSubmenu = new Submenu();
        mainMenu.goToMenu("sales");
        salesSubmenu.goToSubmenu(submenuString);
    }

    @And("^I press \"([^\"]*)\" sales button$")
    public void I_press_sales_button(String buttonString) throws Throwable {
        ButtonsBar purchaseButtonsBar = new ButtonsBar();
        purchaseButtonsBar.clickButton(buttonString);
        Thread.sleep(2000);
    }
}
