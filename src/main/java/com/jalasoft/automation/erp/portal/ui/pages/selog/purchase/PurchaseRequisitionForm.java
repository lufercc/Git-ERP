package com.jalasoft.automation.erp.portal.ui.pages.selog.purchase;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import com.jalasoft.automation.erp.objects.selog.purchase.PurchaseRequisition;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class PurchaseRequisitionForm extends PortalUIElement {

    @FindBy(xpath = "//input[contains(@id,'oe-field-input-')]")
    protected WebElement sourceDocument;

    @FindBy(name = "exclusive")
    protected WebElement requisitionType;

    @FindBy(name = "date_end")
    protected WebElement requisitionDeadline;

    @FindBy(name = "warehouse_id")
    protected WebElement warehouse;

    @FindBy(name = "company_id")
    protected WebElement company;

    @FindBy(xpath = "//td[@class='oe_form_group_cell oe_group_right']//textarea")
    protected WebElement departmentTextArea;

    @FindBy(css = "span.text-label > span.text-label")
    protected WebElement departmentSuggestedLink;

    public PurchaseRequisitionForm() {
        this.waitForLoading();
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.sourceDocument);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.sourceDocument);
    }

    public void modifyData(PurchaseRequisition inputData) {
        if (inputData.sourceDocument != null) {
            this.sourceDocument.sendKeys(inputData.sourceDocument);
        }
        if (inputData.requisitionType != null) {
            this.requisitionType.sendKeys(inputData.requisitionType);
        }
        if (inputData.requisitionDeadline != null) {
            this.requisitionDeadline.sendKeys(inputData.requisitionDeadline);
        }
        if (inputData.warehouse != null) {
            this.warehouse.sendKeys(inputData.warehouse);
        }
        if (inputData.company != null) {
            this.company.sendKeys(inputData.company);
        }
    }

}
