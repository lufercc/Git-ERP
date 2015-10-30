package com.jalasoft.automation.erp.steps;

import com.jalasoft.automation.erp.portal.ui.pages.general.StatusBar;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

/**
 * Created by Henry Benito on 10/27/2015.
 */
public class GeneralControlsSteps {

    @And("^search \"([^\"]*)\" with value \"([^\"]*)\"$")
    public void search_with_value(String attribute, String value) throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^it has \"([^\"]*)\" status$")
    public void it_has_status(String statusString) throws Throwable {
        StatusBar statusBar = new StatusBar();
        Assert.assertTrue(statusBar.isInThisStatus(statusString));
    }
}
