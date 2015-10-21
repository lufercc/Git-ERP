package com.jalasoft.automation.erp.steps.selog.purchase;

import com.jalasoft.automation.erp.portal.ui.pages.general.MainMenu;
import com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.Submenu;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

/**
 * Created by Henry Benito on 10/15/2015.
 */
public class PurchaseNavigationSteps {
    @And("^I go to \"([^\"]*)\" purchase submenu$")
    public void I_go_to_purchase_submenu(String submenu) throws Throwable {
        // Express the Regexp above with the code you wish you had
        MainMenu mainMenu = new MainMenu();
        Submenu purchaseSubmenu = new Submenu();
        mainMenu.goToMenu("purchases");
        purchaseSubmenu.goToSubmenu(submenu);
    }
}
