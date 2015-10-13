package com.jalasoft.automation.erp.portal;

import com.jalasoft.automation.core.selenium.WebDriverManager;
import com.jalasoft.automation.core.app.AutomationApp;
import com.jalasoft.automation.erp.portal.config.PortalConfig;
import com.jalasoft.automation.erp.portal.ui.navigation.PageTransporter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Created by Mauricio Cadima on 9/11/2015.
 */
public class PortalAutomationApp implements AutomationApp {
    private static PortalAutomationApp instance = null;
    private Logger log = Logger.getLogger(getClass());
    private PortalConfig config = null;
    private boolean initialized;

    private PortalAutomationApp() {
        this.initialized = false;
        this.initialize();
    }

    public static PortalAutomationApp getInstance() {
        if (instance == null) {
            instance = new PortalAutomationApp();
        }
        return instance;
    }

    public static void setupFramework() {
        PortalAutomationApp app = getInstance();
        if (!app.initialized) {
            try {
                app.startUp();
            } catch (Exception ex) {
                app.log.error(String.format("Exception initializing framework: %s", ex.getMessage()));
            }
        }
    }

    private void initialize() {
        PropertyConfigurator.configure("log.properties");
        this.config = new PortalConfig();
        PageTransporter.baseURL = this.config.getSutUrl();
    }

    public PortalConfig getConfig() {
        return this.config;
    }

    @Override
    public void startUp() throws Exception {
        WebDriverManager.getInstance().initializeWebDriver(this.config.getWebDriverConfig());
        this.initialized = true;
    }

    @Override
    public void shutDown() {
        WebDriverManager.getInstance().quitDriver();
        this.initialized = false;
    }

}
