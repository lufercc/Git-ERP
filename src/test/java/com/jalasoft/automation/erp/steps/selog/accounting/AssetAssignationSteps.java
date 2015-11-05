package com.jalasoft.automation.erp.steps.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.DeliverAsset;
import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.RequestAssignation;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.DeliverAssetPopupForm;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.RequestAssignationPopupForm;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.SendMailPopupForm;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.SupplierInvoiceEditForm;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;

import java.util.List;

/**
 * Created by Henry Benito on 11/3/2015.
 */
public class AssetAssignationSteps {
    @And("^I modify the request assignation popup with these data$")
    public void I_modify_the_request_assignation_popup_with_these_data(List<RequestAssignation> requestAssignationData) throws Throwable {
        for (RequestAssignation ra : requestAssignationData) {
            RequestAssignationPopupForm requestAssignationPopupForm = new RequestAssignationPopupForm();
            requestAssignationPopupForm.modifyDataAndAccept(ra);
        }
    }

    @And("^I modify the deliver asset popup with these data$")
    public void I_modify_the_deliver_asset_popup_with_these_data(List<DeliverAsset> deliverAssetData) throws Throwable {
        for (DeliverAsset da : deliverAssetData) {
            DeliverAssetPopupForm deliverAssetPopupForm = new DeliverAssetPopupForm();
            deliverAssetPopupForm.modifyDataAndAccept(da);
        }
    }

    @And("^I send email from popup$")
    public void I_send_email_from_popup() throws Throwable {
        SendMailPopupForm sendMailPopupForm = new SendMailPopupForm();
        sendMailPopupForm.sendMail();
    }
}
