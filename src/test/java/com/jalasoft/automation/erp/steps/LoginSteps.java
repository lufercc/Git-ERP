package com.jalasoft.automation.erp.steps;

import com.jalasoft.automation.erp.portal.ui.pages.HomePage;
import com.jalasoft.automation.erp.portal.ui.pages.general.MainMenu;
import com.jalasoft.automation.erp.portal.ui.pages.login.LoginPage;
import com.jalasoft.automation.erp.portal.ui.pages.login.OpenERPLoginPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

/**
 * Created by Mauricio Cadima on 9/11/2015.
 */
public class LoginSteps {

    LoginPage loginPage;
    public LoginSteps(LoginPage loginPage){
        this.loginPage = loginPage;
    }

    @When("^I login with \"([^\"]*)\" credentials$")
    public void i_login_with_credentials(String credentialType) throws Throwable {
        this.loginPage.login(credentialType);
    }

    @Then("^Not error message is displayed$")
    public void not_error_message_is_displayed() throws Throwable {
        Assert.assertFalse(loginPage.isErrorMessageDisplayed(), "Error message displayed");
    }

    @Then("^I am on the home page$")
    public void i_am_on_the_the_home_page() throws Throwable {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.isOnPage(), "Home page not loaded.");
    }

    @And("^I logout$")
    public void I_logout() throws Throwable {
        MainMenu mainMenu = new MainMenu();
        mainMenu.logout();
        Thread.sleep(3000);
    }
}
