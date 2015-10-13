package com.jalasoft.automation.erp.portal.ui.components;

import com.jalasoft.automation.core.error.ErrorInfoCollection;
import com.jalasoft.automation.core.selenium.WebDriverManager;
import com.jalasoft.automation.core.selenium.WebDriverTools;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mauricio Cadima on 9/11/2015.
 */
public abstract class PortalUIElement {
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected WebDriverTools webDriverTools;
    protected Map<String, WebElement> labelToFieldMap;
    private Logger log = Logger.getLogger(getClass());

    public PortalUIElement() {
        this.webDriver = WebDriverManager.getInstance().getWebDriver();
        this.webDriverWait = WebDriverManager.getInstance().getWebDriverWait();
        this.webDriverTools = new WebDriverTools(this.webDriver, this.webDriverWait);
        this.labelToFieldMap = new HashMap<>();
        PageFactory.initElements(this.webDriver, this);
    }

    public abstract void waitForLoading();

    public abstract boolean isLoaded();

    public ErrorInfoCollection getLoadingErrors() {
        return new ErrorInfoCollection();
    }

    public WebDriverTools getWebDriverTools() {
        return this.webDriverTools;
    }

    protected void relateLabelToElement(String label, WebElement element) {
        this.labelToFieldMap.put(label, element);
    }

    public WebElement getElementByLabel(String label) {
        return this.labelToFieldMap.getOrDefault(label, null);
    }

    public Map<String, WebElement> getLabelToFieldMap() {
        return labelToFieldMap;
    }

}
