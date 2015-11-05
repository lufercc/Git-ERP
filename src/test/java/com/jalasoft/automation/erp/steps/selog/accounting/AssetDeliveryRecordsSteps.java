package com.jalasoft.automation.erp.steps.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.AssetsDeliveryRecordsListView;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;

/**
 * Created by Henry Benito on 11/3/2015.
 */
public class AssetDeliveryRecordsSteps {

    @And("^I open to the (\\d+) record displayed for asset delivery records$")
    public void I_open_to_the_record_displayed_for_asset_delivery_records(int rowNumber) throws Throwable {
        AssetsDeliveryRecordsListView assetsDeliveryRecordsListView = new AssetsDeliveryRecordsListView();
        assetsDeliveryRecordsListView.goToRowRecord(rowNumber);
    }
}
