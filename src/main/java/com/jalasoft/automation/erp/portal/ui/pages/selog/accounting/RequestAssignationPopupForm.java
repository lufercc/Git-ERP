package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.components.SelectOpenERP;
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


//    @FindBy(xpath = "(//div[contains(@class,'ui-dialog ui-widget ui-widget-content')]//input)[1]")
//    protected WebElement evaluationResponsible;
//
//    @FindBy(xpath = "(//div[contains(@class,'ui-dialog ui-widget ui-widget-content')]//input)[2]")
//    protected WebElement depAreaResponsible;
//
//    @FindBy(xpath = "(//div[contains(@class,'ui-dialog ui-widget ui-widget-content')]//input)[3]")
//    protected WebElement custodian;
//
//    @FindBy(xpath = "(//div[contains(@class,'ui-dialog ui-widget ui-widget-content')]//input)[4]")
//    protected WebElement depArea;
//
//    @FindBy(xpath = "(//div[contains(@class,'ui-dialog ui-widget ui-widget-content')]//input)[5]")
//    protected WebElement location;

    @FindBy(xpath = "(//div[contains(@class,'ui-dialog ui-widget ui-widget-content')]//span[contains(@class,'jala-icon-deploy')])[5]")
    protected WebElement locationDeploy;

    @FindBy(xpath = "//div[contains(@class,'ui-dialog-buttonpane')]//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Aceptar')]")
    protected WebElement acceptButton;

    protected SelectOpenERP evaluationResponsible;
    protected SelectOpenERP depAreaResponsible;
    protected SelectOpenERP custodian;
    protected SelectOpenERP depArea;
    protected SelectOpenERP location;

    public RequestAssignationPopupForm() {
        this.waitForLoading();
        this.evaluationResponsible = new SelectOpenERP(By.xpath("(//div[contains(@class,'ui-dialog ui-widget ui-widget-content')]//input)[1]"));
        this.depAreaResponsible = new SelectOpenERP(By.xpath("(//div[contains(@class,'ui-dialog ui-widget ui-widget-content')]//input)[2]"));
        this.custodian = new SelectOpenERP(By.xpath("(//div[contains(@class,'ui-dialog ui-widget ui-widget-content')]//input)[3]"));
        this.depArea = new SelectOpenERP(By.xpath("(//div[contains(@class,'ui-dialog ui-widget ui-widget-content')]//input)[4]"));
        this.location = new SelectOpenERP(By.xpath("(//div[contains(@class,'ui-dialog ui-widget ui-widget-content')]//input)[5]"));
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.dialogTitle);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.dialogTitle);
    }

    public void modifyDataAndAccept(RequestAssignation inputData) {
        if (inputData.evaluationResponsible != null) {
            this.evaluationResponsible.selectItem(inputData.evaluationResponsible);
        }
        if (inputData.depAreaResponsible != null) {
            this.depAreaResponsible.selectItem(inputData.depAreaResponsible);
        }
        if (inputData.custodian != null) {
            this.custodian.selectItem(inputData.custodian);
        }
        if (inputData.depArea != null) {
            this.depArea.selectItem(inputData.depArea);
        }
        if (inputData.location != null) {
//            this.locationDeploy.click();
//            WebElement item = webDriver.findElement(By.xpath("//ul[not(contains(@style,'display: none'))]//a[contains(text(),'" + inputData.location + "')]"));
//            item.click();
            this.location.selectItem(inputData.location);
        }
        acceptButton.click();
        this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
    }
}
