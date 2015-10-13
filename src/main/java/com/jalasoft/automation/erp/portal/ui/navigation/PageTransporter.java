package com.jalasoft.automation.erp.portal.ui.navigation;

import com.jalasoft.automation.core.selenium.WebDriverManager;
import com.jalasoft.automation.erp.portal.PortalAutomationApp;
import com.jalasoft.automation.erp.portal.ui.pages.login.LoginPage;
import org.openqa.selenium.WebDriver;

/**
 * Created by Mauricio Cadima on 9/11/2015.
 */
public class PageTransporter {
    public static String baseURL;
    private static PageTransporter instance;
    private WebDriver webDriver;

    private PageTransporter() {
        PortalAutomationApp.setupFramework();
        this.baseURL = PortalAutomationApp.getInstance().getConfig().getSutUrl();
        this.webDriver = WebDriverManager.getInstance().getWebDriver();
    }

    public static PageTransporter getInstance() {
        if (instance == null) {
            instance = new PageTransporter();
        }
        return instance;
    }

    private void navigateToURL(String url) {
        this.webDriver.navigate().to(url);
    }

    public String getLoginPageUrl() {
        return this.baseURL;
    }

    public String getHomePageUrl(){
        return  this.baseURL;
    }
    public LoginPage navigateToLoginPage() {
        this.navigateToURL(getLoginPageUrl());
        return new LoginPage();
    }
}
