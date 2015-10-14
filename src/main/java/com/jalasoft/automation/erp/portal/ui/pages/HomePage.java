package com.jalasoft.automation.erp.portal.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Mauricio Cadima on 9/11/2015.
 */
public class HomePage extends BasePage {
    @FindBy(xpath = "//td[@class ='oe_topbar']")
    protected WebElement toolbar;

    public HomePage(){
        waitForLoading();
    }

    @Override
    public boolean isOnPage() {
        return super.getCurrentURL().contains(super.pageTransporter.getHomePageUrl());
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.toolbar);
    }

    @Override
    public boolean isLoaded() {
        return true;
    }
}

