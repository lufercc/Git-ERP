package com.jalasoft.automation.erp.steps.selog.warehouse;

import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.Asset;
import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.AssetDeliveryRecord;
import com.jalasoft.automation.erp.portal.ui.pages.general.Search;
import com.jalasoft.automation.erp.portal.ui.pages.selog.warehouse.InternalMovesListView;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;

/**
 * Created by Henry Benito on 11/7/2015.
 */
public class InternalMoveSteps {

    Asset auxAsset;
    AssetDeliveryRecord auxAssetDeliveryRecord;
    public InternalMoveSteps(Asset assetInput, AssetDeliveryRecord assetDeliveryRecordInput) {
        auxAsset = assetInput;
        auxAssetDeliveryRecord = assetDeliveryRecordInput;
    }

    @And("^I search internal move created in asset assignation$")
    public void I_search_internal_move_created_in_asset_assignation() throws Throwable {
        Search openERPSearch = new Search();
        openERPSearch.advancedSearch("Documento origen",this.auxAsset.code);
        InternalMovesListView internalMovesListView = new InternalMovesListView();
        internalMovesListView.clickOnRecord(this.auxAsset.code);
    }

    @And("^I search internal move created in asset delivery order$")
    public void I_search_internal_move_created_in_asset_delivery_order() throws Throwable {
        Search openERPSearch = new Search();
        openERPSearch.advancedSearch("Documento origen",this.auxAssetDeliveryRecord.id);
        InternalMovesListView internalMovesListView = new InternalMovesListView();
        internalMovesListView.clickOnRecord(this.auxAsset.code);
    }

    @And("^I search asset in internal moves$")
    public void I_search_asset_in_internal_moves() throws Throwable {
        Search openERPSearch = new Search();
        openERPSearch.advancedSearch("Documento origen",this.auxAsset.code);
        InternalMovesListView internalMovesListView = new InternalMovesListView();
        internalMovesListView.clickOnRecord(this.auxAsset.code);
    }
}
