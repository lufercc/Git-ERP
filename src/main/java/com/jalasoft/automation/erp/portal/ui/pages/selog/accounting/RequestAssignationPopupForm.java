package com.jalasoft.automation.erp.portal.ui.pages.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.components.FormEditMode;
import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.portal.ui.components.SelectOpenERP;
import com.jalasoft.automation.erp.objects.selog.accounting.RequestAssignation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class RequestAssignationPopupForm extends FormEditMode {


    @FindBy(css = "//div.ui-dialog.ui-widget.ui-widget-content.ui-corner-all.oe_act_window.ui-draggable.ui-resizable.openerp")
    protected WebElement dialogContainer;

    @FindBy(xpath = "//div[contains(@class,'ui-dialog-content')]//div[contains(@class,'oe_horizontal_separator')]")
    protected WebElement dialogTitle;


    @FindBy(xpath = "//label[contains(text(),'Evaluation Responsible')]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement evaluationResponsible;

    @FindBy(xpath = "//label[contains(text(),'Department / Area Responsible')]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement depAreaResponsible;

    @FindBy(xpath = "//label[contains(text(),'Custodian')]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement custodian;

    @FindBy(xpath = "//label[contains(text(),'Department / Area') and not(contains(text(),'Responsible'))]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement depArea;

    @FindBy(xpath = "//label[contains(text(),'Location') and not(contains(text(),'Asset'))]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement location;

    @FindBy(xpath = "//label[contains(text(),'Asset Location')]/ancestor::td/following-sibling::td/span/div/input")
    protected WebElement locationDeploy;

    @FindBy(xpath = "//div[contains(@class,'ui-dialog-buttonpane')]//button[not(contains(@class,'oe_form_invisible'))]/span[contains(text(),'Accept')]")
    protected WebElement acceptButton;

    public RequestAssignationPopupForm() {
        waitForLoading();
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
        fieldsWereEdited = new ArrayList<>();
        fieldsWereNotEdited = new ArrayList<>();
        allFieldsWereEdited = true;
        if (inputData.evaluationResponsible != null) {
            selectOpenERPItem(evaluationResponsible, "evaluationResponsible", inputData.evaluationResponsible);
        }
        if (inputData.depAreaResponsible != null) {
            selectOpenERPItem(depAreaResponsible, "depAreaResponsible", inputData.depAreaResponsible);
        }
        if (inputData.custodian != null) {
            selectOpenERPItem(custodian, "custodian", inputData.custodian);
        }
        if (inputData.depArea != null) {
            selectOpenERPItem(depArea, "depArea", inputData.depArea);
        }
        if (inputData.location != null) {
            selectOpenERPItem(location, "location", inputData.location);
        }
        acceptButton.click();
        webDriverTools.waitUntilInvisibilityOpenERPProgress();
        logEditStatus();
    }
}
