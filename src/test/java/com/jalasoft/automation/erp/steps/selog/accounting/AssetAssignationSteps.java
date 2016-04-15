package com.jalasoft.automation.erp.steps.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.Asset;
import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.DeliverAsset;
import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.RequestAssignation;
import com.jalasoft.automation.erp.portal.ui.pages.general.Search;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;

import java.util.List;

/**
 * Created by Henry Benito on 11/3/2015.
 */
public class AssetAssignationSteps {


    Asset auxAsset;

    public AssetAssignationSteps(Asset assetInput) {
        auxAsset = assetInput;
    }

    @And("^I modify the request assignation popup with these data$")
    public void I_modify_the_request_assignation_popup_with_these_data(List<RequestAssignation> requestAssignationData) throws Throwable {
        for (RequestAssignation ra : requestAssignationData) {
            RequestAssignationPopupForm requestAssignationPopupForm = new RequestAssignationPopupForm();
            requestAssignationPopupForm.modifyDataAndAccept(ra);
            Thread.sleep(2000);
        }
    }

    @And("^I modify the deliver asset popup with these data$")
    public void I_modify_the_deliver_asset_popup_with_these_data(List<DeliverAsset> deliverAssetData) throws Throwable {
        for (DeliverAsset da : deliverAssetData) {
            DeliverAssetPopupForm deliverAssetPopupForm = new DeliverAssetPopupForm();
            deliverAssetPopupForm.modifyDataAndAccept(da);
            Thread.sleep(2000);
        }
    }

    @And("^I send email from popup$")
    public void I_send_email_from_popup() throws Throwable {
        SendMailPopupForm sendMailPopupForm = new SendMailPopupForm();
        sendMailPopupForm.sendMail();
        Thread.sleep(2000);
    }

    @And("^I search asset created in asset assignation$")
    public void I_search_asset_created_in_asset_assignation() throws Throwable {
        Search openERPSearch = new Search();
        openERPSearch.advancedSearch("Asset Code",this.auxAsset.code);
        Thread.sleep(2000);
        AssetsAssignationListView assetsAssignationListView = new AssetsAssignationListView();
        assetsAssignationListView.clickOnRecord(this.auxAsset.code);
    }
}
