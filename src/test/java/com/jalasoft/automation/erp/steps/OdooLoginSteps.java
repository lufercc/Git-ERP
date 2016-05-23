package com.jalasoft.automation.erp.steps;

import com.jalasoft.automation.erp.portal.ui.pages.login.OdooLoginPage;

import cucumber.api.java.en.When;

/**
 * Created by Henry Benito on 5/12/2016.
 */
public class OdooLoginSteps {
    OdooLoginPage loginPage;
    public OdooLoginSteps(OdooLoginPage loginPage){
        this.loginPage = loginPage;
    }

    @When("^I login with \"([^\"]*)\" odoo credentials$")
    public void iLoginWithOdooCredentials(String credentialType) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        this.loginPage.login(credentialType);
    }
}
