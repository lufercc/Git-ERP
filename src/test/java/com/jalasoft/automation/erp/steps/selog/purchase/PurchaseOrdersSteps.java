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
    OrderLine orderLineDataAux;
    PurchaseOrder purchaseOrderAux;
    PurchaseOrderEditForm purOrderForm;

    public PurchaseOrdersSteps(PurchaseOrder purchaseOrderInput, OrderLine orderLineDataInput) {
        this.purchaseOrderAux = purchaseOrderInput;
        orderLineDataAux = orderLineDataInput;
    }

    @And("^I create a purchase order with these data$")
    public void I_create_a_purchase_order_with_these_data(List<PurchaseOrder> purchaseOrderData) throws Throwable {
        //purchaseOrderList = purchaseOrderData;
        this.purOrderForm = new PurchaseOrderEditForm();

        for (PurchaseOrder pr : purchaseOrderData) {
            purOrderForm.modifyData(pr);
        }
    }

    @And("^I add products to the purchase order$")
    public void I_add_products_to_the_purchase_order(List<OrderLine> orderLineData) throws Throwable {

        this.purOrderForm = new PurchaseOrderEditForm();
        OrderLineForm orderLineForm;

        for (OrderLine ol : orderLineData) {
            orderLineDataAux.fillMainData(ol);
            purOrderForm.clickAddItemOrderLine();
            orderLineForm = new OrderLineForm();
            orderLineForm.modifyOrderLine(ol);
        }
    }

    @And("^get \"([^\"]*)\" field value for Purchase Order created$")
    public void get_field_value_for_Purchase_Order_created(String fieldString) throws Throwable {
        PurchaseOrderReadForm poReadForm = new PurchaseOrderReadForm();
        this.purchaseOrderAux.fillMainData(poReadForm.getMainData());
        this.purchaseOrderID = poReadForm.getData(fieldString);
    }

    @And("^get main data from current purchase order$")
    public void get_main_data_from_current_purchase_order() throws Throwable {
        PurchaseOrderReadForm poReadForm = new PurchaseOrderReadForm();
        this.purchaseOrderAux.fillMainData(poReadForm.getMainData());
    }
}
