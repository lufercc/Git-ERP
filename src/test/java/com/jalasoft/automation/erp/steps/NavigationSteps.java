package com.jalasoft.automation.erp.steps;

import com.jalasoft.automation.erp.portal.ui.navigation.PageTransporter;
import cucumber.api.java.en.Given;

/**
 * Created by Mauricio Cadima on 9/11/2015.
 */
public class NavigationSteps {

    @Given("^I navigate to login page$")
    public void i_navigate_to_login_page() throws Throwable {
        PageTransporter.getInstance().navigateToLoginPage();
    }
}
