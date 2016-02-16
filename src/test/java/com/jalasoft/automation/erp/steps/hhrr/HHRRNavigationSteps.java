package com.jalasoft.automation.erp.steps.hhrr;

import com.jalasoft.automation.erp.portal.ui.pages.general.MainMenu;
import com.jalasoft.automation.erp.portal.ui.pages.hhrr.Submenu;
import cucumber.api.java.en.And;

/**
 * Created by Henry Benito on 10/29/2015.
 */
public class HHRRNavigationSteps {

    @And("^I go to \"([^\"]*)\" hhrr submenu$")
    public void I_go_to_hhrr_submenu(String submenu) throws Throwable {
        MainMenu mainMenu = new MainMenu();
        Submenu accountingSubmenu = new Submenu();
        mainMenu.goToMenu("hhrr");
        accountingSubmenu.goToSubmenu(submenu);
    }
}