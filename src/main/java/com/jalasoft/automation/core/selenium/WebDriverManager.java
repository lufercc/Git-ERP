package com.jalasoft.automation.core.selenium;

import com.jalasoft.automation.core.config.WebDriverConfig;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Dimension;
import com.jalasoft.automation.erp.portal.PortalAutomationApp;

import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private static WebDriverManager instance = null;
    private Logger log = Logger.getLogger(getClass());
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private String browser = "Firefox";
    private long implicitWaitTime;
    private long explicitWaitTime;
    private long waitSleepTime;
    private WebDriverConfig webDriverConfig;

    private String deviceType= PortalAutomationApp.getInstance().getConfig().getDeviceType();

    private WebDriverManager() {

    }

    public static WebDriverManager getInstance() {
        if (instance == null || instance.webDriver == null) {
            instance = new WebDriverManager();
        }
        return instance;
    }

    public WebDriver getWebDriver() {
        return this.webDriver;
    }

    public WebDriverWait getWebDriverWait() {
        return this.webDriverWait;
    }

    public void quitDriver() {
        try {
            log.info("Quit Driver");
            this.webDriver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        webDriver = null;
    }

    public void initializeWebDriver(WebDriverConfig webDriverConfig) throws Exception {
        log.info("Initializing web driver");
        this.webDriverConfig = webDriverConfig;
        this.implicitWaitTime = this.webDriverConfig.getImplicitWaitTime();
        this.explicitWaitTime = this.webDriverConfig.getExplicitWaitTime();
        this.waitSleepTime = this.webDriverConfig.getWaitSleepTime();
        if (webDriverConfig.getDriverType().equalsIgnoreCase("remote")) {
            this.setupRemoteDriver(webDriverConfig);
        } else {
            this.setupBrowserDriver(webDriverConfig);
        }
        this.setupDriverDeviceType(this.deviceType);
        this.setupDriverTimeouts();
    }

    /**
     * Method to change the implicit wait time value
     *
     * @param timeout
     */
    public void changeImplicitWaitTime(int timeout) {
        this.implicitWaitTime = timeout;
        this.setupDriverDeviceType(this.deviceType);
        this.setupDriverTimeouts();
    }

    /**
     * Method to restore the implicit wait time to default value
     */
    public void restoreImplicitWaitTimeToDefault() {
        this.implicitWaitTime = this.webDriverConfig.getImplicitWaitTime();
        this.setupDriverDeviceType(this.deviceType);
        this.setupDriverTimeouts();
    }

    private DesiredCapabilities getDesiredCapabilities(WebDriverConfig webDriverConfig) {
        DesiredCapabilities caps = new DesiredCapabilities(webDriverConfig.getDesiredCapabilities());
        return caps;
    }

    private void setupRemoteDriver(WebDriverConfig webDriverConfig) throws Exception {
        log.info("setup remote driver");
        DesiredCapabilities caps = this.getDesiredCapabilities(webDriverConfig);
        Map<String, String> settings = webDriverConfig.getRemoteDriverSettings();
        String userName = settings.get("remoteUser");
        String automateKey = settings.get("remoteAutomateKey");
        String urls = String.format("http://%s:%s@hub.browserstack.com/wd/hub", userName, automateKey);
        this.webDriver = new RemoteWebDriver(new URL(urls), caps);
    }

    private void setupBrowserDriver(WebDriverConfig webDriverConfig) {
        this.browser = webDriverConfig.getBrowser();
        log.info(String.format("setup driver for browser:{%s}", this.browser));
        DesiredCapabilities capabilities = this.getDesiredCapabilities(webDriverConfig);
        switch (this.browser.toLowerCase()) {
            case "chrome":
                webDriver = new ChromeDriver(capabilities);
                System.setProperty("webdriver.chrome.webDriver", "drivers/chromedriver.exe");
                break;
            case "ie":
                webDriver = new InternetExplorerDriver(capabilities);
                System.setProperty("webdriver.ie.webDriver", "drivers/IEDriverServer.exe");
                break;
            case "safari":
                webDriver = new SafariDriver(capabilities);
                break;
            case "firefox":
            default:
                webDriver = new FirefoxDriver(capabilities);
                break;
        }
    }

    private void setupDriverTimeouts() {

        log.info(String.format("initializing driver timeouts implicit wait time:{%d}, explicit wait time:{%d} ", this.implicitWaitTime, this.explicitWaitTime));
        webDriver.manage().timeouts().implicitlyWait(this.implicitWaitTime, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, this.explicitWaitTime, this.waitSleepTime);
    }

    private void setupDriverDeviceType(String deviceType){
        switch (deviceType.toLowerCase()) {
            case "computer":
                webDriver.manage().window().maximize();
                break;
            case "mobile":
                Dimension dimensionCellphone = new Dimension(386, 645);
                webDriver.manage().window().setSize(dimensionCellphone);
                break;
            case "tablet":
                Dimension dimensionTablet = new Dimension(768, 1024);
                webDriver.manage().window().setSize(dimensionTablet);
                break;
        }
    }
}
