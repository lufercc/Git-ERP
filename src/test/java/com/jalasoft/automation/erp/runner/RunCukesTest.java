package com.jalasoft.automation.erp.runner;

import com.jalasoft.automation.erp.portal.PortalAutomationApp;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.rmi.RemoteException;

/**
 * Created by Mauricio Cadima on 9/11/2015.
 */

@CucumberOptions(
        tags = {"@testhr"},
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"},
        glue = {"com.jalasoft.automation.erp.steps"},
        features = {"src/test/resources/com/jalasoft/automation/erp/features/"},
        monochrome = true)
public class RunCukesTest extends AbstractTestNGCucumberTests {

    private static Logger log = Logger.getLogger("RunCukesTest");

    @BeforeTest
    public void beforeAll() {
        try {
            PortalAutomationApp.getInstance().startUp();
        } catch (Exception ex) {
            log.error("Exception executing before all", ex);
        }
    }

    @AfterTest
    public void afterAll() throws RemoteException {
        try {
            PortalAutomationApp.getInstance().shutDown();
        } catch (Exception ex) {
            log.error("Exception executing after all", ex);
        }
    }
}

