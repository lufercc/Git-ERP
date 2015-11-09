package com.jalasoft.automation.erp.steps.selog.warehouse;

import com.jalasoft.automation.erp.portal.ui.custom.selog.purchase.PurchaseOrder;
import com.jalasoft.automation.erp.portal.ui.pages.general.MainMenu;
import com.jalasoft.automation.erp.portal.ui.pages.general.Search;
import com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.IncomingShipmentList;
import com.jalasoft.automation.erp.portal.ui.pages.selog.warehouse.ButtonsBar;
import com.jalasoft.automation.erp.portal.ui.pages.selog.warehouse.Submenu;
import cucumber.api.java.en.And;

/**
 * Created by Henry Benito on 11/3/2015.
 */
public class IncomingShipmentsSteps {

    PurchaseOrder purchaseOrderAux;
    public IncomingShipmentsSteps(PurchaseOrder purchaseOrderInput) {
        this.purchaseOrderAux = purchaseOrderInput;
    }

    @And("^I go to incoming shipment created from purchase order$")
    public void I_go_to_incoming_shipment_created_from_purchase_order() throws Throwable {
        Search openERPSearch = new Search();
        openERPSearch.advancedSearch("Documento origen",this.purchaseOrderAux.code);
        IncomingShipmentList incomingShipmentList = new IncomingShipmentList();
        incomingShipmentList.goToRecord(this.purchaseOrderAux.code);
    }
}
