package com.jalasoft.automation.erp.steps.selog.purchase;

import com.jalasoft.automation.erp.portal.PortalAutomationApp;
import com.jalasoft.automation.erp.portal.config.PortalConfig;
import com.jalasoft.automation.erp.portal.ui.custom.selog.purchase.OrderLine;
import com.jalasoft.automation.erp.portal.ui.custom.selog.purchase.PurchaseOrder;
import com.jalasoft.automation.erp.portal.ui.pages.general.Search;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.AssetsListView;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.SupplierInvoiceReadForm;
import com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.IncomingShipmentList;
import com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.OrderLineForm;
import com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.PurchaseOrderEditForm;
import com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.PurchaseOrderReadForm;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;

import java.util.List;

/**
 * Created by Henry Benito on 10/22/2015.
 */
public class PurchaseOrdersSteps {
    String purchaseOrderID;
    String supplierInvoiceID;
    List<OrderLine> orderLineData;
    PurchaseOrderEditForm purOrderForm;

    @And("^I create a purchase order with these data$")
    public void I_create_a_purchase_order_with_these_data(List<PurchaseOrder> purchaseOrderData) throws Throwable {
        //purchaseOrderList = purchaseOrderData;
        this.purOrderForm = new PurchaseOrderEditForm();

        for (PurchaseOrder pr : purchaseOrderData)
        {
            purOrderForm.modifyData(pr);
        }
    }

    @And("^I add products to the purchase order$")
    public void I_add_products_to_the_purchase_order(List<OrderLine> orderLineData) throws Throwable {
        this.orderLineData = orderLineData;
        this.purOrderForm = new PurchaseOrderEditForm();
        OrderLineForm orderLineForm;

        for (OrderLine ol : orderLineData)
        {
            purOrderForm.clickAddItemOrderLine();
            orderLineForm = new OrderLineForm();
            orderLineForm.modifyOrderLine(ol);
        }

    }

    @And("^get \"([^\"]*)\" field value for Purchase Order created$")
    public void get_field_value_for_Purchase_Order_created(String fieldString) throws Throwable {
        PurchaseOrderReadForm poReadForm = new PurchaseOrderReadForm();
        this.purchaseOrderID = poReadForm.getData(fieldString);
    }

    //TODO Move this step to IncomingShipmentSteps
    @And("^I go to incoming shipment created from Purchase Order$")
    public void I_go_to_incoming_shipment_created_from_Purchase_Order() throws Throwable {
        Search openERPSearch = new Search();
        openERPSearch.advancedSearch("Documento origen",purchaseOrderID);
        IncomingShipmentList incomingShipmentList = new IncomingShipmentList();
        incomingShipmentList.goToRecord(purchaseOrderID);
    }

    //TODO Move this step to SupplierInvoicesSteps
    @And("^I go to supplier invoice created from incoming shipment$")
    public void I_go_to_supplier_invoice_created_from_incoming_shipment() throws Throwable {
        Search openERPSearch = new Search();
        openERPSearch.advancedSearch("Documento origen",purchaseOrderID);
        IncomingShipmentList incomingShipmentList = new IncomingShipmentList();
        incomingShipmentList.goToRecord(purchaseOrderID);
    }

    @And("^get \"([^\"]*)\" field value for supplier invoice created$")
    public void get_field_value_for_supplier_invoice_created(String fieldString) throws Throwable {
        SupplierInvoiceReadForm poReadForm = new SupplierInvoiceReadForm();
        this.supplierInvoiceID = poReadForm.getData(fieldString);
    }

    //TODO Move this step to AssetSteps
    //TODO Review if this step could be applied to multiple assets
    @And("^a new record is displayed in assets list view$")
    public void a_new_record_is_displayed_in_assets_list_view() throws Throwable {
        Search openERPSearch = new Search();
        openERPSearch.advancedSearch("Factura",this.supplierInvoiceID);
        AssetsListView assetList = new AssetsListView();
        assetList.goToRecord(this.orderLineData.get(0).product);
        Thread.sleep(3000); //TODO Use implicit wait instead thread.sleep
    }
}
