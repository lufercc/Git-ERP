package com.jalasoft.automation.core.config;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mauricio Cadima on 9/11/2015.
 */
public class DefaultWebDriverConfig implements WebDriverConfig {

    private ConfigFileReader configFileReader;
    private Map<String, String> desiredCapabilities;
    private Map<String, String> remoteDriverSettings;

    public DefaultWebDriverConfig(ConfigFileReader configFileReader) {
        this.configFileReader = configFileReader;
        this.desiredCapabilities = new HashMap<String, String>();
        if (this.configFileReader.isSubSectionDefined("webDriver", "desiredCapabilities")) {
            this.desiredCapabilities.putAll(this.configFileReader.getConfigSubSection("webDriver", "desiredCapabilities"));
        }
        this.remoteDriverSettings = new HashMap<String, String>();
        if (this.configFileReader.isSubSectionDefined("webDriver", "remoteDriverSettings")) {
            this.remoteDriverSettings.putAll(this.configFileReader.getConfigSubSection("webDriver", "remoteDriverSettings"));
        }
    }

    @Override
    public String getDriverType() {
        return configFileReader.getConfigValue("webDriver", "driverType");
    }

    @Override
    public String getBrowser() {
        return configFileReader.getConfigValue("webDriver", "browser");
    }

    @Override
    public long getImplicitWaitTime() {
        return Long.parseLong(configFileReader.getConfigValue("webDriver", "implicitWaitTime"));
    }

    @Override
    public long getExplicitWaitTime() {
        return Long.parseLong(configFileReader.getConfigValue("webDriver", "explicitWaitTime"));
    }

    @Override
    public long getWaitSleepTime() {
        return Long.parseLong(configFileReader.getConfigValue("webDriver", "waitSleepTime"));
    }

    @Override
    public Map<String, String> getDesiredCapabilities() {
        return this.desiredCapabilities;
    }

    @Override
    public Map<String, String> getRemoteDriverSettings() {
        return this.remoteDriverSettings;
    }
}
