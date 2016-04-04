package com.jalasoft.automation.erp.portal.ui.pages.general;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class GeneralButtonsBar extends PortalUIElement {
    @CacheLookup
    @FindBy(xpath = "//div[@class='oe_view_manager_buttons']")
    protected WebElement buttonsContainer;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oe_view_manager_buttons']//div[not(contains(@style,'display: none;'))]//button[contains(.,'Create')]")
    protected WebElement createButton;

    @FindBy(xpath = "//div[@class='oe_view_manager_buttons']//div[not(contains(@style,'display: none;'))]//button[contains(.,'Save')]")
    protected WebElement saveButton;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oe_view_manager_buttons']//div[not(contains(@style,'display: none;'))]//button[contains(.,'Edit')]")
    protected WebElement editButton;

    @FindBy(xpath = "//div[@class='oe_view_manager_sidebar']/div[not(contains(@style,'display: none;'))]//button[contains(.,'More')]/span")
    protected WebElement moreButton;

    @FindBy(xpath = "//div[@class='oe_view_manager_sidebar']/div[not(contains(@style,'display: none;'))]//a[contains(.,'Delete')]")
    protected WebElement deleteButton;

    public GeneralButtonsBar() {
        waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return webDriverTools.isElementDisplayed(buttonsContainer);
    }

    @Override
    public void waitForLoading() {
        webDriverTools.waitUntilElementPresentAndVisible(buttonsContainer);
    }

    public void clickButton(String buttonString) {
        webDriverTools.waitUntilInvisibilityOpenERPProgress();
        switch (buttonString.toLowerCase()) {
        case "create":
            webDriverTools.waitUntilInvisibilityOpenERPProgress();
            webDriverTools.waitUntilElementPresentAndVisible(createButton);
            createButton.click();
            break;

        case "save":
            saveButton.click();
            try{
                WebElement warningMessage = this.webDriver.findElement(By.xpath("//div[contains(@class,'ui-notify-message')]"));
                WebElement closeWarningMessage = this.webDriver.findElement(By.xpath("//div[contains(@class,'ui-notify-message')]/a"));
                if(warningMessage.isDisplayed()) {
                    System.out.println(warningMessage.getAttribute("innerHTML"));
                    closeWarningMessage.click();
                }

            } catch (Exception e) {
//                System.out.println("No error message is displayed" + e.getCause());
            }
            break;

        case "edit":
            webDriverTools.waitUntilInvisibilityOpenERPProgress();
            webDriverTools.waitUntilElementPresentAndVisible(editButton);
            editButton.click();
            break;

        case "more":
            moreButton.click();
            break;

        case "delete":
            moreButton.click();
            deleteButton.click();
            this.webDriverTools.clickOnConfirmationAlertOption("Yes");
            break;
        }
        webDriverTools.waitUntilInvisibilityOpenERPProgress();
    }
}
