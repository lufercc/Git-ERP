package com.jalasoft.automation.erp.portal.ui.pages.general;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class GeneralButtonsBar extends PortalUIElement {

    @FindBy(xpath = "//div[@class='oe_view_manager_buttons']")
    protected WebElement buttonsContainer;

    @FindBy(xpath = "//div[@class='oe_view_manager_buttons']//div[not(contains(@style,'display: none;'))]//button[contains(.,'Create')]")
    protected WebElement createButton;

    @FindBy(xpath = "//div[@class='oe_view_manager_buttons']//div[not(contains(@style,'display: none;'))]//button[contains(.,'Save')]")
    protected WebElement saveButton;

    @FindBy(xpath = "//div[@class='oe_view_manager_buttons']//div[not(contains(@style,'display: none;'))]//button[contains(.,'Edit')]")
    protected WebElement editButton;

    @FindBy(xpath = "//div[@class='oe_view_manager_sidebar']/div[not(contains(@style,'display: none;'))]//button[contains(.,'More')]/span")
    protected WebElement moreButton;

    @FindBy(xpath = "//div[@class='oe_view_manager_sidebar']/div[not(contains(@style,'display: none;'))]//a[contains(.,'Delete')]")
    protected WebElement deleteButton;

    public GeneralButtonsBar() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.buttonsContainer);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.buttonsContainer);
    }

    public void clickButton(String buttonString) {
        this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
        switch (buttonString.toLowerCase()) {
        case "create":
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
            this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
            this.webDriverWait.withMessage("Algo");
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
        this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
    }
}
