package com.jalasoft.automation.erp.steps.selog.warehouse;

import com.jalasoft.automation.erp.portal.ui.custom.selog.purchase.PurchaseOrder;
import com.jalasoft.automation.erp.portal.ui.custom.selog.warehouse.IncomingShipment;
import com.jalasoft.automation.erp.portal.ui.pages.general.MainMenu;
import com.jalasoft.automation.erp.portal.ui.pages.general.Search;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.AssetsAssignationListView;
import com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.IncomingShipmentList;
import com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.InteriorFormButtonsBar;
import com.jalasoft.automation.erp.portal.ui.pages.selog.warehouse.ButtonsBar;
import com.jalasoft.automation.erp.portal.ui.pages.selog.warehouse.IncomingShipmentReadForm;
import com.jalasoft.automation.erp.portal.ui.pages.selog.warehouse.Submenu;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;

/**
 * Created by Henry Benito on 11/3/2015.
 */
public class IncomingShipmentsSteps {

    IncomingShipment incomingShipmentAux;
    PurchaseOrder purchaseOrderAux;
    String searchBy = "Source Document";

    public IncomingShipmentsSteps(IncomingShipment incomingShipmentInput, PurchaseOrder purchaseOrderInput) {
        incomingShipmentAux = incomingShipmentInput;
        purchaseOrderAux = purchaseOrderInput;
    }

    @And("^I go to incoming shipment created from purchase order$")
    public void I_go_to_incoming_shipment_created_from_purchase_order() throws Throwable {
        Search openERPSearch = new Search();
        openERPSearch.advancedSearch(searchBy,this.purchaseOrderAux.code);
        IncomingShipmentList incomingShipmentList = new IncomingShipmentList();
        incomingShipmentList.goToRecord(purchaseOrderAux.code);
    }

    @And("^I search purchase order in incoming shipments$")
    public void I_search_purchase_order_in_incoming_shipments() throws Throwable {
        Search openERPSearch = new Search();
        openERPSearch.advancedSearch(searchBy,this.purchaseOrderAux.code);
        IncomingShipmentList incomingShipmentList = new IncomingShipmentList();
        incomingShipmentList.goToRecord(purchaseOrderAux.code);
    }

    @And("^I press \"([^\"]*)\" incoming shipment button$")
    public void I_press_incoming_shipment_button(String buttonString) throws Throwable {
        com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.ButtonsBar purchaseButtonsBar = new com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.ButtonsBar();
        purchaseButtonsBar.clickButton(buttonString);
        Thread.sleep(2000);
    }

    @And("^I move to \"([^\"]*)\" from incoming shipment$")
    public void I_move_to_from_incoming_shipment(String buttonString) throws Throwable {
        InteriorFormButtonsBar intButtonsBar = new InteriorFormButtonsBar();
        intButtonsBar.clickButton(buttonString);
    }

    @And("^get main data from current incoming shipments$")
    public void get_main_data_from_current_incoming_shipments() throws Throwable {
        IncomingShipmentReadForm incomingShipmentReadForm = new IncomingShipmentReadForm();
        incomingShipmentAux.fillMainData(incomingShipmentReadForm.getMainData());
    }
}
