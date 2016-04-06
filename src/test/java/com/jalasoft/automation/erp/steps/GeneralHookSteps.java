package com.jalasoft.automation.erp.steps;

import com.jalasoft.automation.erp.portal.ui.pages.general.MainMenu;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.Scenario;

public class GeneralHookSteps {
    @Before
    public void beforeCallingScenario() {
        System.out.println("*********** About to start the scenario.");
    }
    @After
    public void afterRunningScenario(Scenario scenario) {
        System.out.println("*********** Just finished running scenario: "
                + scenario.getStatus());
        MainMenu mainMenu = new MainMenu();
        mainMenu.logout();
    }
}