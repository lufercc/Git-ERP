package com.jalasoft.automation.erp.steps.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.Asset;
import com.jalasoft.automation.erp.portal.ui.pages.general.Search;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.AssetEditForm;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.AssetReadForm;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.AssetsAssignationListView;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;

import java.util.List;

/**
 * Created by Henry Benito on 11/2/2015.
 */
public class AssetSteps {

    Asset auxAsset;

    @And("^I modify the asset with these data$")
    public void I_modify_the_asset_with_these_data(List<Asset> assetData) throws Throwable {
        AssetEditForm assetEditForm = new AssetEditForm();

        for (Asset as : assetData) {
            assetEditForm.modifyData(as);
        }

        Thread.sleep(5000);//TODO Change for implicit wait
    }

    @And("^get main data from the asset created$")
    public void get_main_data_from_the_asset_created() throws Throwable {
        AssetReadForm assetReadForm = new AssetReadForm();
        this.auxAsset = assetReadForm.getMainData();
    }

    @And("^I search asset created in asset assignation$")
    public void I_search_asset_created_in_asset_assignation() throws Throwable {
        Search openERPSearch = new Search();
        openERPSearch.advancedSearch("Código de activo",this.auxAsset.code);
        AssetsAssignationListView assetsAssignationListView = new AssetsAssignationListView();
        assetsAssignationListView.clickOnRecord(this.auxAsset.code);
    }

    @And("^I search internal move created in asset assignation$")
    public void I_search_internal_move_created_in_asset_assignation() throws Throwable {
        Search openERPSearch = new Search();
        openERPSearch.advancedSearch("Documento origen",this.auxAsset.code);
        AssetsAssignationListView assetsAssignationListView = new AssetsAssignationListView();
        assetsAssignationListView.clickOnRecord(this.auxAsset.code);
    }
}
