package com.jalasoft.automation.erp.steps.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.Asset;
import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.AssetDeliveryRecord;
import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.SupplierInvoice;
import com.jalasoft.automation.erp.portal.ui.custom.selog.purchase.OrderLine;
import com.jalasoft.automation.erp.portal.ui.pages.general.Search;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.*;
import com.jalasoft.automation.erp.portal.ui.pages.selog.warehouse.InternalMovesListView;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;

import java.util.List;

/**
 * Created by Henry Benito on 11/2/2015.
 */
public class AssetSteps {

    Asset auxAsset;
    AssetDeliveryRecord auxAssetsDeliveryRecordsReadForm;
    SupplierInvoice supplierInvoiceAux;
    OrderLine orderLineDataAux;

    public AssetSteps(SupplierInvoice supplierInvoiceInput,OrderLine orderLineDataInput,Asset assetInput) {
        supplierInvoiceAux = supplierInvoiceInput;
        orderLineDataAux = orderLineDataInput;
        auxAsset = assetInput;
    }

    @And("^I modify the asset with these data$")
    public void I_modify_the_asset_with_these_data(List<Asset> assetData) throws Throwable {
        AssetEditForm assetEditForm = new AssetEditForm();

        for (Asset as : assetData) {
            assetEditForm.modifyData(as);
        }

        Thread.sleep(5000);//TODO Change for implicit wait
    }

    @And("^get main data from the current asset$")
    public void get_main_data_from_the_current_asset() throws Throwable {
        AssetReadForm assetReadForm = new AssetReadForm();
        this.auxAsset.fillMainData(assetReadForm.getMainData());
    }

    //TODO Review if this step could be applied to multiple assets
    @And("^a new record is displayed in assets list view$")
    public void a_new_record_is_displayed_in_assets_list_view() throws Throwable {
        Search openERPSearch = new Search();
        openERPSearch.advancedSearch("Factura",this.supplierInvoiceAux.code);
        AssetsListView assetList = new AssetsListView();
        assetList.clickOnRecord(this.orderLineDataAux.product);
    }

    @And("^I search supplier invoice in the assets$")
    public void I_search_supplier_invoice_in_the_assets() throws Throwable {
        Search openERPSearch = new Search();
        openERPSearch.advancedSearch("Factura",this.supplierInvoiceAux.code);
        AssetsListView assetListView = new AssetsListView();
        assetListView.clickOnRecord(this.auxAsset.code);
    }
}
