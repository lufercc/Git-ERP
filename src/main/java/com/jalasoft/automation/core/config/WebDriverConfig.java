package com.jalasoft.automation.core.config;

import java.util.Map;

/**
 * Created by Mauricio on 4/7/2015.
 */
public interface WebDriverConfig {

    String getDriverType();

    String getBrowser();

    long getImplicitWaitTime();

    long getExplicitWaitTime();

    long getWaitSleepTime();

    Map<String, String> getDesiredCapabilities();

    Map<String, String> getRemoteDriverSettings();
}
