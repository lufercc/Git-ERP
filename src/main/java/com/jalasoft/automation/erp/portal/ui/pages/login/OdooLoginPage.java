package com.jalasoft.automation.erp.portal.ui.pages.login;

import com.jalasoft.automation.core.config.CredentialsConfig;
import com.jalasoft.automation.core.config.UserCredentials;
import com.jalasoft.automation.erp.portal.PortalAutomationApp;
import com.jalasoft.automation.erp.portal.ui.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Mauricio Cadima on 9/11/2015.
 */
public class OdooLoginPage extends BasePage {

    @FindBy(id = "login")
    protected WebElement userInput;

    @FindBy(id = "password")
    protected WebElement passwordInput;

    protected By errorLabelLocator = By.id("msg");

    @FindBy(xpath = "//button[@type='submit']")
    protected WebElement loginButton;

    protected CredentialsConfig userCredentials;

    public OdooLoginPage() {
        this.waitForLoading();
        this.userCredentials = PortalAutomationApp.getInstance().getConfig().getCredentialsConfig();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.userInput);
    }

    @Override
    public void waitForLoading() {
         super.webDriverTools.waitUntilElementPresentAndVisible(this.userInput);
    }

    @Override
    public boolean isOnPage() {
        return getCurrentURL().equals(super.pageTransporter.getLoginPageUrl());
    }

    public void login(String userName, String password) {
        this.userInput.sendKeys(userName);
        this.passwordInput.sendKeys(password);
        this.loginButton.click();
    }

    public void clickLogin() {
        this.loginButton.click();
    }

    public void login(String credentialType) {
        UserCredentials credentials = this.userCredentials.getCredentialsByType(credentialType);
        if (credentials != null) {
            userInput.sendKeys(credentials.userName);
            passwordInput.sendKeys(credentials.password);
            loginButton.click();
        }
    }

    public boolean isErrorMessageDisplayed(){
        return super.webDriverTools.isElementDisplayed(this.errorLabelLocator);
    }

}
