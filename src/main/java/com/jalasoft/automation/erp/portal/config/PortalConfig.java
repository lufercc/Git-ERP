package com.jalasoft.automation.erp.portal.config;

import com.jalasoft.automation.core.config.*;

import java.io.File;

/**
 * Created by Mauricio Cadima on 9/11/2015.
 */
public class PortalConfig implements AutomationAppSettings {
    private static final String configFilePath = System.getProperty("user.dir") + File.separator + "config.json";
    private JsonConfigFileReader jsonConfigFileReader;
    private WebDriverConfig webDriverConfig;
    private CredentialsConfig credentialsConfig;

    public PortalConfig() {
        this.jsonConfigFileReader = new JsonConfigFileReader(configFilePath);
        this.webDriverConfig = new DefaultWebDriverConfig(jsonConfigFileReader);
        this.credentialsConfig = new UserCredentialsConfig(jsonConfigFileReader);
    }

    public WebDriverConfig getWebDriverConfig() {
        return this.webDriverConfig;
    }

    public CredentialsConfig getCredentialsConfig() {
        return this.credentialsConfig;
    }

    @Override
    public String getSutUrl() {
        return (jsonConfigFileReader.getConfigValue("GeneralSettings", "sutURL")).toString();
    }


    public String getSutDB() {
        return (jsonConfigFileReader.getConfigValue("GeneralSettings", "db")).toString();
    }

    @Override
    public String getDeviceType() {

        return (jsonConfigFileReader.getConfigValue("GeneralSettings", "deviceType")).toString();

    }
}
