package com.jalasoft.automation.core.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mauricio Cadima on 6/23/2015.
 */
public class WebDriverTools {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private Logger log = Logger.getLogger(getClass());

    public WebDriverTools(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
    }

    /**
     * Switch from original frame to a popup.
     *
     * @param iFrameName Frame name.
     */
    public void switchToFrame(String iFrameName) {
        try {
            this.webDriver.switchTo().frame(iFrameName);
        } catch (NoSuchFrameException e) {
            log.warn(String.format("Exception raised switching to frame:%s, error message: %s", iFrameName, e.getMessage()));
            this.webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrameName));
        }
    }

    /**
     * Switch from original frame to a iframe specified by its locator.
     *
     * @param by it is the iframe locator.
     */
    public void switchToFrame(By by) {
        WebElement frameElement = this.webDriver.findElement(by);
        this.switchToFrame(frameElement);
    }

    /**
     * Switch from original frame to a iframe specified by its WebElement.
     *
     * @param frameElement it is the iframe webelement.
     */
    public void switchToFrame(WebElement frameElement) {
        try {
            this.webDriver.switchTo().frame(frameElement);
        } catch (NoSuchFrameException e) {
            log.warn(String.format("Exception raised switching to frame:%s, error message: %s", frameElement.getAttribute("id"), e.getMessage()));
            this.webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement.getAttribute("id")));
        }
    }

    /**
     * Switch from a popup to the original frame.
     */
    public void switchToDefaultFrame() {
        this.webDriver.switchTo().defaultContent();
    }

    /**
     * Wait until any webElement disappears from UI and DOM page.
     *
     * @param locator WebElement locator.
     */
    public void waitUntilInvisibilityElement(By locator) {
        try {
            this.webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (WebDriverException e) {
            log.warn(String.format("Exception raised waiting for element invisibility: %s", e.getMessage()));
        }
    }

    public void clearAndSendKeys(WebElement webElement, String value) {
        webElement.clear();
        webElement.sendKeys(value);
    }

    /**
     * Method to check the title of page matches with expected title, return True if the title matches, false otherwise.
     *
     * @param expectedTitle
     */
    public boolean isExpectedTitle(String expectedTitle) {
        try {
            return this.webDriverWait.until(ExpectedConditions.titleIs(expectedTitle));
        } catch (WebDriverException e) {
            log.error(String.format("The title \" %s \" is not expected", expectedTitle));
            return false;
        }
    }

    /**
     * Method to verify if a web element is displayed
     *
     * @param webElement
     */
    public boolean isElementDisplayed(WebElement webElement) {
        try {
            return webElement.isDisplayed();
        } catch (WebDriverException e) {
            return false;
        }
    }

    /**
     * Method to verify if a web element is displayed
     *
     * @param locator
     */
    public boolean isElementDisplayed(By locator) {
        boolean isDisplayed = false;
        if (this.isElementPresent(locator)) {
            if (this.isElementDisplayed(this.webDriver.findElement(locator))) {
                isDisplayed = true;
            }
        }
        return isDisplayed;
    }

    /**
     * Method to check on a checkbox
     *
     * @param webElement
     */
    public void checkBox(WebElement webElement) {
        if (!webElement.isSelected()) {
            clickOnElement(webElement);
        }
    }

    /**
     * Method to unCheck on a checkbox
     *
     * @param webElement
     */
    public void unCheckBox(WebElement webElement) {
        if (webElement.isSelected()) {
            clickOnElement(webElement);
        }
    }

    /**
     * Method to clear a web element text
     *
     * @param webElement
     */
    public void clearText(WebElement webElement) {
        webElement.clear();
    }

    /**
     * Method to wait until an element is presented DOM and it is visible
     *
     * @param webElement
     */
    public void waitUntilElementPresentAndVisible(WebElement webElement) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (WebDriverException e) {
            log.error(String.format("Element is not present and visible: %s", e.getCause()));
            throw new WebDriverException("Element is not present and visible: ", e.getCause());
        }
    }

    /**
     * Method to wait until an element is presented DOM and it is visible
     *
     * @param byElement
     */
    public WebElement waitUntilElementPresentAndVisible(By byElement) {
        WebElement webElement = null;
        try {
            webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
        } catch (WebDriverException e) {
            log.error(String.format("Element is not present and visible: %s", e.getCause()));
            throw new WebDriverException("Element is not present and visible: ", e.getCause());
        }
        return webElement;
    }

    /**
     * Method to click on a web element
     *
     * @param webElement
     */
    public void clickOnElement(WebElement webElement) {
        try {
            webElement.click();
            log.info(String.format("The click action was performed on web element: %s", webElement));
        } catch (WebDriverException e) {
            log.error(String.format("Error when trying to click on web element: %s, error message: %s", webElement, e.getCause()));
            throw new WebDriverException(String.format("Error when trying to click on web element: %s, error message: %s", webElement, e.getCause()));
        }
    }

    /**
     * Method to click on a webElement using By locator
     *
     * @param
     */
    public void clickOnElement(By locator) {
        try {
            WebElement webElement = webDriver.findElement(locator);
            this.clickOnElement(webElement);
        } catch (WebDriverException e) {
            log.error(String.format("Error when trying to click on web element's locator: %s, error message: %s", locator, e.getCause()));
            throw new WebDriverException(String.format("Error when trying to click on web element's locator: %s, error message: %s", locator, e.getCause()));
        }

    }

    /**
     * Method to do right click on a web element
     *
     * @param webElement
     */
    public void rightClickOnElement(WebElement webElement) {
        try {
            Actions rightClick = new Actions(this.webDriver);
            rightClick.moveToElement(webElement).perform();
            rightClick.contextClick(webElement).perform();
        } catch (WebDriverException e) {
            log.error(" The element is not displayed: " + e.getMessage());
            throw new WebDriverException("The element was not displayed" + webElement, e);
        }
    }

    /**
     * Method to verify if an element is present in the DOM and return false otherwise
     *
     * @param locator
     * @return
     */
    public boolean isElementPresent(By locator) {
        try {
            WebElement item = this.webDriver.findElement(locator);
            return true;
        } catch (WebDriverException e) {
            log.warn(String.format("Exception raised waiting for element present: %s", e.getMessage()));
            return false;
        }
    }

    /**
     * Method to verify if an element is present in the DOM and return false otherwise
     *
     * @param locator
     * @param timeout
     */
    public boolean isElementPresent(By locator, int timeout) {
        WebDriverManager.getInstance().changeImplicitWaitTime(timeout);
        try {
            this.webDriver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        } finally {
            WebDriverManager.getInstance().restoreImplicitWaitTimeToDefault();
        }
    }

    /**
     * Method to wait the Processing element is displayed
     */
    public void waitUntilElementCompleteProcessing(By byProcessing) {
        waitUntilElementPresent(byProcessing);
    }

    /**
     * Method to wait until an element will be displayed
     */
    public void waitUntilElementPresent(By locator) {
        try {
            this.webDriverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (WebDriverException e) {
            log.error(" The element " + locator + " was not displayed: " + e.getMessage());
            throw new WebDriverException("The element " + locator + " was not displayed", e);
        }
    }

    /**
     * Method to do some action on Alert confirmation message
     *
     * @param optionName The option name to be selected
     */
    public void clickOnConfirmationAlertOption(String optionName) {
        try {
            switch (optionName) {
                case "Yes":
                    this.webDriver.switchTo().alert().accept();
                    break;
                case "No":
                    this.webDriver.switchTo().alert().dismiss();
                    break;
                case "Cancel":
                    this.webDriver.switchTo().alert().dismiss();
                    break;
                case "OK":
                    this.webDriver.switchTo().alert().accept();
                    break;
            }
        } catch (NoAlertPresentException e) {
            log.error(" The confirmation alert was not displayed: " + e.getMessage());
            throw new NoAlertPresentException("The confirmation alert was not displayed", e);
        }
    }

    /**
     * Method to select an option of a drop list web element
     *
     * @param element where the option will be selected
     * @param option  to be selected
     */
    public void selectOptionOfDropListElement(WebElement element, String option) {
        try {
            Select select = new Select(element);
            select.selectByVisibleText(option);
        } catch (WebDriverException e) {
            log.error(" The drop list was not displayed: " + e.getMessage());
            throw new WebDriverException("The drop list was not displayed", e);
        }
    }

    public void dragDropMouse(WebElement fromElement, WebElement toElement) {
        try {
            Actions builder = new Actions(this.webDriver);
            Action dragAndDrop = builder.clickAndHold(fromElement)
                    .moveToElement(toElement)
                    .release(toElement)
                    .build();
            dragAndDrop.perform();
        } catch (Exception e) {
            log.error("The drag and drop action was not done");
        }

    }

    public void pressKey(String keyName) {
        Keys keys = null;
        try {
            switch (keyName) {
                case "Up":
                    keys = Keys.ARROW_UP;
                    break;
                case "Down":
                    keys = Keys.ARROW_DOWN;
                    break;
                case "Left":
                    keys = Keys.ARROW_LEFT;
                    break;
                case "Right":
                    keys = Keys.ARROW_RIGHT;
                    break;
                case "Delete":
                    keys = Keys.DELETE;
                    break;
                case "Enter":
                    keys = Keys.ENTER;
                    break;
                case "Control":
                    keys = Keys.CONTROL;
                    break;
                case "Escape":
                    keys = Keys.ESCAPE;
                    break;
            }

            Actions keyButton = new Actions(this.webDriver);
            keyButton.sendKeys(keys).perform();
        } catch (Exception e) {
            log.error("There is no any key called : " + keyName);
        }
    }

    /**
     * Method to hover the mouse over an element
     *
     * @param element
     */
    public void hoverMouseOnElement(WebElement element) {
        try {
            Actions clickHover = new Actions(this.webDriver);
            clickHover.moveToElement(element).perform();
        } catch (WebDriverException e) {
            log.error("The element was not found");
        }
    }

    /**
     * Method to get a string list given a web element list
     *
     * @param elements Web element list to convert into a string list
     * @return String list
     */
    public List<String> getTextListFromWebElementList(List<WebElement> elements) {
        List<String> textList = new ArrayList<>();
        for (WebElement element : elements) {
            textList.add(element.getText().trim());
        }
        return textList;
    }

    /**
     * Method to get the selected option of a drop list web element
     *
     * @param dropListLocator
     */
    public String getFirstSelectedOptionOfDropList(By dropListLocator) {
        try {
            return new Select(this.webDriver.findElement(dropListLocator)).getFirstSelectedOption().getText();
        } catch (WebDriverException e) {
            log.error(" The drop list was not displayed: " + e.getMessage());
            return null;
        }
    }

    /**
     * Method to retrieve special text from web element, the text content could be in javascript or json code.
     *
     * @param element web element with script or json content.
     * @return text from inner web element.
     */
    public String getTextFromSpecialWebElement(WebElement element) {

        return (String) ((JavascriptExecutor) this.webDriver).executeScript(
                "return jQuery(arguments[0]).text();", element);
    }

    /**
     * Wait until any OpenERP loading webElement disappears from UI and DOM page.
     */
    public void waitUntilInvisibilityOpenERPProgress() {
        try {
            this.webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oe_loading")));
        } catch (WebDriverException e) {
            log.warn(String.format("Exception raised waiting for element invisibility: %s", e.getMessage()));
        }
    }
}