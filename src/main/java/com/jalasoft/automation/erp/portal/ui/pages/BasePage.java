package com.jalasoft.automation.erp.portal.ui.pages;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.navigation.PageTransporter;

/**
 * Created by Mauricio Cadima on 9/11/2015.
 */
public abstract class BasePage extends PortalUIElement {

    protected PageTransporter pageTransporter;

    public BasePage() {

    }

    public String getPageTitle() {
        return this.webDriver.getTitle();
    }

    public String getCurrentURL() {
        return this.webDriver.getCurrentUrl();
    }

    public abstract boolean isOnPage();
}
