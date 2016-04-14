package com.jalasoft.automation.erp.steps.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.pages.general.MainMenu;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.ButtonsBar;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.ExtraGeneralButtonsBar;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.InteriorFormButtonsBar;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.Submenu;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;

import java.util.concurrent.TimeUnit;

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
    }

    @And("^I press \"([^\"]*)\" accounting button$")
    public void I_press_accounting_button(String buttonString) throws Throwable {
        ButtonsBar accountingButtonsBar = new ButtonsBar();
        accountingButtonsBar.clickButton(buttonString);
        Thread.sleep(2000);
    }

    @And("^I press \"([^\"]*)\" accounting internal button$")
    public void I_press_accounting_internal_button(String buttonString) throws Throwable {
        InteriorFormButtonsBar intButtonsBar = new InteriorFormButtonsBar();
        intButtonsBar.clickButton(buttonString);
    }

    @And("^I press \"([^\"]*)\" extra general accounting button$")
    public void I_press_extra_general_accounting_button(String buttonString) throws Throwable {
        ExtraGeneralButtonsBar extraGralButtons = new ExtraGeneralButtonsBar();
        extraGralButtons.clickButton(buttonString);
    }
}
