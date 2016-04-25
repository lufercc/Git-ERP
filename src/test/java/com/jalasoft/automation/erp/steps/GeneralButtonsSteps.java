package com.jalasoft.automation.erp.steps;

import com.jalasoft.automation.erp.portal.ui.pages.general.GeneralButtonsBar;
import com.jalasoft.automation.erp.portal.ui.pages.general.GeneralPopupForm;
import com.jalasoft.automation.erp.portal.ui.pages.general.ViewButtonsBar;
import cucumber.api.java.en.And;
import org.testng.Assert;


/**
 * Created by Henry Benito on 10/20/2015.
 */
public class GeneralButtonsSteps {

    @And("^I press \"([^\"]*)\" general button$")
    public void I_press_general_button(String buttonString) throws Throwable {
        GeneralButtonsBar gralButtons = new GeneralButtonsBar();
        gralButtons.clickButton(buttonString);
        Thread.sleep(3000);
    }

    @And("^I press \"([^\"]*)\" button for general popup$")
    public void I_press_button_for_general_popup(String buttonString) throws Throwable {
        GeneralPopupForm gralPopupForm = new GeneralPopupForm();
        gralPopupForm.clickButton(buttonString);
    }

    @And("^I select \"([^\"]*)\" view$")
    public void I_select_view(String viewType) throws Throwable {
        ViewButtonsBar viewButtonsBar = new ViewButtonsBar();
        viewButtonsBar.clickButton(viewType);
    }

    @And("^I am not able to press \"([^\"]*)\" general button$")
    public void I_am_not_able_to_press_general_button(String buttonString) throws Throwable {
        Boolean result;
        try{
            GeneralButtonsBar gralButtons = new GeneralButtonsBar();
            gralButtons.clickButton(buttonString);
            Thread.sleep(3000);
            result = false;
        }catch(Exception nsee)
        {
            result = true;
        }
        Assert.assertTrue(result);
    }
}
