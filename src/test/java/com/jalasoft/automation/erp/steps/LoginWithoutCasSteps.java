package com.jalasoft.automation.erp.steps;

import com.jalasoft.automation.erp.portal.ui.pages.login.OpenERPLoginPage;
import cucumber.api.java.en.When;

/**
 * Created by Henry Benito on 1/7/2016.
 */
public class LoginWithoutCasSteps {
    OpenERPLoginPage loginPage;
    public LoginWithoutCasSteps(OpenERPLoginPage loginPage){
        this.loginPage = loginPage;
    }

    @When("^I login with \"([^\"]*)\" credentials without cas$")
    public void I_login_with_credentials_without_cas(String credentialType) throws Throwable {
        this.loginPage.login(credentialType);
    }
}