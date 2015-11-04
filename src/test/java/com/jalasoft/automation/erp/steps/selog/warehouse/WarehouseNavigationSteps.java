package com.jalasoft.automation.erp.steps.selog.warehouse;

import com.jalasoft.automation.erp.portal.ui.pages.general.MainMenu;
import com.jalasoft.automation.erp.portal.ui.pages.selog.warehouse.ButtonsBar;
import com.jalasoft.automation.erp.portal.ui.pages.selog.warehouse.Submenu;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;

/**
 * Created by Henry Benito on 11/3/2015.
 */
public class WarehouseNavigationSteps {
    @And("^I go to \"([^\"]*)\" warehouse submenu$")
    public void I_go_to_warehouse_submenu(String submenuString) throws Throwable {
        MainMenu mainMenu = new MainMenu();
        Submenu warehouseSubmenu = new Submenu();
        mainMenu.goToMenu("warehouse");
        warehouseSubmenu.goToSubmenu(submenuString);
    }

    @And("^I press \"([^\"]*)\" warehouse button$")
    public void I_press_warehouse_button(String buttonString) throws Throwable {
        ButtonsBar warehouseButtonsBar = new ButtonsBar();
        warehouseButtonsBar.clickButton(buttonString);
    }
}
