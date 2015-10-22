package com.jalasoft.automation.erp.steps;

import com.jalasoft.automation.erp.portal.ui.pages.general.GeneralButtonsBar;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class GeneralButtonsSteps {
    @And("^I press \"([^\"]*)\" general button$")
    public void I_press_general_button(String buttonString) throws Throwable {
        // Express the Regexp above with the code you wish you had
        GeneralButtonsBar gralButtons = new GeneralButtonsBar();
        gralButtons.clickButton(buttonString);
    }
}
