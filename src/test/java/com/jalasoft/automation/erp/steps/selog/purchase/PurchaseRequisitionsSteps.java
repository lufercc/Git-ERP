package com.jalasoft.automation.erp.steps.selog.purchase;

import com.jalasoft.automation.erp.portal.ui.custom.selog.purchase.PurchaseRequisition;
import com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.PurchaseRequisitionForm;
import com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.PurchaseRequisitionList;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class PurchaseRequisitionsSteps {
    List<PurchaseRequisition> purchaseRequisitionList;
    @When("^I create a purchase requisition with these data$")
    public void I_create_a_purchase_requisition_with_these_data(List<PurchaseRequisition> purchaseRequisitionData) throws Throwable {
        purchaseRequisitionList = purchaseRequisitionData;
        PurchaseRequisitionForm purReqForm = new PurchaseRequisitionForm();

        for (PurchaseRequisition pr : purchaseRequisitionData)
        {
            purReqForm.modifyData(pr);
        }
    }

    @And("^I add products for previous purchase requisition$")
    public void I_add_products_for_previous_purchase_requisition() throws Throwable {
        // Express the Regexp above with the code you wish you had
        throw new PendingException();
    }

    @Then("^a new record is displayed in purchase requisition list view$")
    public void a_new_record_is_displayed_in_purchase_requisition_list_view() throws Throwable {
        PurchaseRequisitionList purReqList = new PurchaseRequisitionList();
        for (PurchaseRequisition pr : purchaseRequisitionList)
        {
            purReqList.isCellPresent(pr.sourceDocument);
        }
    }
}
