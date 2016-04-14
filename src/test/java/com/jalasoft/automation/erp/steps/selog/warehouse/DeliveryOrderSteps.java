package com.jalasoft.automation.erp.steps.selog.warehouse;

import com.jalasoft.automation.erp.portal.ui.custom.selog.sales.SaleOrder;
import com.jalasoft.automation.erp.portal.ui.custom.selog.warehouse.DeliveryOrder;
import com.jalasoft.automation.erp.portal.ui.pages.general.Search;
import com.jalasoft.automation.erp.portal.ui.pages.selog.warehouse.DeliveryOrderReadForm;
import com.jalasoft.automation.erp.portal.ui.pages.selog.warehouse.DeliveryOrdersListView;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;

/**
 * Created by Henry Benito on 11/10/2015.
 */
public class DeliveryOrderSteps {
    SaleOrder saleOrderAux;
    DeliveryOrder deliveryOrderAux;

    String SearchBy = "Source Document";

    public DeliveryOrderSteps(DeliveryOrder deliveryOrderInput, SaleOrder saleOrderInput) {
        deliveryOrderAux = deliveryOrderInput;
        saleOrderAux = saleOrderInput;
    }

    @And("^I search sale order in delivery orders$")
    public void I_search_sale_order_in_delivery_orders() throws Throwable {
        Search openERPSearch = new Search();
        openERPSearch.advancedSearch(SearchBy,this.saleOrderAux.code);
        DeliveryOrdersListView deliveryOrderListView = new DeliveryOrdersListView();
        deliveryOrderListView.clickOnRecord(this.saleOrderAux.code);
    }

    @And("^get main data from current delivery order$")
    public void get_main_data_from_current_delivery_order() throws Throwable {
        DeliveryOrderReadForm deliveryOrderReadForm = new DeliveryOrderReadForm();
        this.deliveryOrderAux.fillMainData(deliveryOrderReadForm.getMainData());
    }
}
