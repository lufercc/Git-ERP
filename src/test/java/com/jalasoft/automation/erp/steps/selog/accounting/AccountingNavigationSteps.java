package com.jalasoft.automation.erp.steps.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.pages.general.MainMenu;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.ButtonsBar;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.Submenu;
import cucumber.api.java.en.And;

/**
 * Created by Henry Benito on 10/29/2015.
 */
public class AccountingNavigationSteps {

    @And("^I go to \"([^\"]*)\" accounting submenu$")
    public void I_go_to_accounting_submenu(String submenu) throws Throwable {
        MainMenu mainMenu = new MainMenu();
        Submenu accountingSubmenu = new Submenu();
        mainMenu.goToMenu("accounting");
        accountingSubmenu.goToSubmenu(submenu);
        Thread.sleep(6000); //TODO Use implicit wait instead thread.sleep
    }

    @And("^I press \"([^\"]*)\" accounting button$")
    public void I_press_accounting_button(String buttonString) throws Throwable {
        ButtonsBar accountingButtonsBar = new ButtonsBar();
        accountingButtonsBar.clickButton(buttonString);
    }
}
