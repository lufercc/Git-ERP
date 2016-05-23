package com.jalasoft.automation.erp.steps.selog.accounting;

import com.jalasoft.automation.erp.objects.selog.accounting.AssetDeliveryRecord;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.AssetsDeliveryRecordsListView;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.AssetsDeliveryRecordsReadForm;
import cucumber.api.java.en.And;

/**
 * Created by Henry Benito on 11/3/2015.
 */
public class AssetDeliveryRecordsSteps {

    AssetDeliveryRecord assetDeliveryRecordAux;

    public AssetDeliveryRecordsSteps(AssetDeliveryRecord assetDeliveryRecordInput) {
        assetDeliveryRecordAux = assetDeliveryRecordInput;
    }

    @And("^I open to the (\\d+) record displayed for asset delivery records$")
    public void I_open_to_the_record_displayed_for_asset_delivery_records(int rowNumber) throws Throwable {
        AssetsDeliveryRecordsListView assetsDeliveryRecordsListView = new AssetsDeliveryRecordsListView();
        assetsDeliveryRecordsListView.goToRowRecord(rowNumber);
    }

    @And("^get main data from the asset delivery record$")
    public void get_main_data_from_the_asset_delivery_record() throws Throwable {
        AssetsDeliveryRecordsReadForm assetsDeliveryRecordsReadForm = new AssetsDeliveryRecordsReadForm();
        assetDeliveryRecordAux.fillMainData(assetsDeliveryRecordsReadForm.getMainData());
    }
}
