package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.RequestAssignation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class RequestAssignationPopupForm extends PortalUIElement {


    @FindBy(css = "//div.ui-dialog.ui-widget.ui-widget-content.ui-corner-all.oe_act_window.ui-draggable.ui-resizable.openerp")
    protected WebElement dialogContainer;

    @FindBy(xpath = "//div[contains(@class,'ui-dialog-content')]//div[contains(@class,'oe_horizontal_separator')]")
    protected WebElement dialogTitle;


    @FindBy(xpath = "(//div[contains(@class,'ui-dialog ui-widget ui-widget-content')]//input)[1]")
    protected WebElement evaluationResponsible;

    @FindBy(xpath = "(//div[contains(@class,'ui-dialog ui-widget ui-widget-content')]//input)[2]")
    protected WebElement depAreaResponsible;

    @FindBy(xpath = "(//div[contains(@class,'ui-dialog ui-widget ui-widget-content')]//input)[3]")
    protected WebElement custodian;

    @FindBy(xpath = "(//div[contains(@class,'ui-dialog ui-widget ui-widget-content')]//input)[4]")
    protected WebElement depArea;

    @FindBy(xpath = "(//div[contains(@class,'ui-dialog ui-widget ui-widget-content')]//input)[5]")
    protected WebElement location;

    @FindBy(xpath = "(//div[contains(@class,'ui-dialog ui-widget ui-widget-content')]//span[contains(@class,'jala-icon-deploy')])[5]")
    protected WebElement locationDeploy;

    @FindBy(xpath = "//div[contains(@class,'ui-dialog-buttonpane')]//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Aceptar')]")
    protected WebElement acceptButton;

    public RequestAssignationPopupForm() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.evaluationResponsible);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.evaluationResponsible);
    }

    public void modifyDataAndAccept(RequestAssignation inputData) {
        if (inputData.evaluationResponsible != null) {
            this.webDriverTools.clearAndSendKeys(this.evaluationResponsible,inputData.evaluationResponsible);
            this.webDriverTools.pressKey("Enter");
        }
        if (inputData.depAreaResponsible != null) {
            this.webDriverTools.clearAndSendKeys(this.depAreaResponsible,inputData.depAreaResponsible);
            this.webDriverTools.pressKey("Enter");
        }
        if (inputData.custodian != null) {
            this.webDriverTools.clearAndSendKeys(this.custodian,inputData.custodian);
            this.webDriverTools.pressKey("Enter");
        }
        if (inputData.depArea != null) {
            this.webDriverTools.clearAndSendKeys(this.depArea,inputData.depArea);
            this.webDriverTools.pressKey("Enter");
        }
        if (inputData.location != null) {
            this.locationDeploy.click();
            WebElement item = webDriver.findElement(By.xpath("//ul[not(contains(@style,'display: none'))]//a[contains(text(),'" + inputData.location + "')]"));
            item.click();
        }
        acceptButton.click();
        this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
    }
}
