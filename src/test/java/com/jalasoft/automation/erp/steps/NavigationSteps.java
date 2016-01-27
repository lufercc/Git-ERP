package com.jalasoft.automation.erp.steps;

import com.jalasoft.automation.erp.portal.ui.navigation.PageTransporter;
import com.jalasoft.automation.erp.portal.ui.pages.general.MainMenu;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

/**
 * Created by Mauricio Cadima on 9/11/2015.
 */
public class NavigationSteps {

    @Given("^I navigate to login page$")
    public void i_navigate_to_login_page() throws Throwable {
        PageTransporter.getInstance().navigateToLoginPage();
    }

    @And("^I go to \"([^\"]*)\" menu$")
    public void I_go_to_menu(String menu) throws Throwable {
        MainMenu mainMenu = new MainMenu();
        mainMenu.goToMenu(menu);
    }

    @Given("^I navigate to login page without cas$")
    public void I_navigate_to_login_page_without_cas() throws Throwable {
        PageTransporter.getInstance().navigateToOpenERPLoginPage();
    }
}
