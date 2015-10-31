package com.jalasoft.automation.erp.steps.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.ButtonsBar;
import com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.InteriorFormButtonsBar;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;

/**
 * Created by Henry Benito on 10/28/2015.
 */
public class IncomingShipmentsSteps {

    @And("^I press \"([^\"]*)\" incoming shipment button$")
    public void I_press_incoming_shipment_button(String buttonString) throws Throwable {
        ButtonsBar purchaseButtonsBar = new ButtonsBar();
        purchaseButtonsBar.clickButton(buttonString);

    }

    @And("^I move to \"([^\"]*)\" from incoming shipment$")
    public void I_move_to_from_incoming_shipment(String buttonString) throws Throwable {
        InteriorFormButtonsBar intButtonsBar = new InteriorFormButtonsBar();
        intButtonsBar.clickButton(buttonString);
    }
}
