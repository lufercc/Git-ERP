package com.jalasoft.automation.erp.steps.selog.purchase;

import com.jalasoft.automation.erp.portal.ui.pages.general.MainMenu;
import com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.ButtonsBar;
import com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.Submenu;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Date;

/**
 * Created by Henry Benito on 10/15/2015.
 */
public class PurchaseNavigationSteps {
    @And("^I go to \"([^\"]*)\" purchase submenu$")
    public void I_go_to_purchase_submenu(String submenu) throws Throwable {
        MainMenu mainMenu = new MainMenu();
        Submenu purchaseSubmenu = new Submenu();
        mainMenu.goToMenu("purchases");
        purchaseSubmenu.goToSubmenu(submenu);
        Thread.sleep(6000); //TODO Use implicit wait instead thread.sleep
    }

    @And("^I press \"([^\"]*)\" purchase button$")
    public void I_press_purchase_button(String buttonString) throws Throwable {
        // Express the Regexp above with the code you wish you had
        ButtonsBar purchaseButtonsBar = new ButtonsBar();
        purchaseButtonsBar.clickButton(buttonString);
    }
}
