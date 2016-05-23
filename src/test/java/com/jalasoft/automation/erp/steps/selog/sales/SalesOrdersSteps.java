package com.jalasoft.automation.erp.steps.selog.sales;

import com.jalasoft.automation.erp.objects.selog.purchase.OrderLine;
import com.jalasoft.automation.erp.objects.selog.sales.SaleOrder;
import com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.OrderLineForm;
import com.jalasoft.automation.erp.portal.ui.pages.selog.sales.SaleOrderEditForm;
import com.jalasoft.automation.erp.portal.ui.pages.selog.sales.SaleOrderReadForm;
import cucumber.api.java.en.And;

import java.util.List;

/**
 * Created by Henry Benito on 11/9/2015.
 */
public class SalesOrdersSteps {
    OrderLine orderLineDataAux;
    SaleOrder saleOrderAux;

    public SalesOrdersSteps(SaleOrder saleOrderInput, OrderLine orderLineDataInput) {
        saleOrderAux = saleOrderInput;
        orderLineDataAux = orderLineDataInput;
    }

    @And("^I modify the sale order with these data$")
    public void I_modify_the_sale_order_with_these_data(List<SaleOrder> saleOrderData) throws Throwable {
        for (SaleOrder item : saleOrderData) {
            SaleOrderEditForm deliverAssetPopupForm = new SaleOrderEditForm();
            deliverAssetPopupForm.modifyData(item);
        }
    }

    @And("^I add products to the sales order$")
    public void I_add_products_to_the_sales_order(List<OrderLine> orderLineData) throws Throwable {
        SaleOrderEditForm saleOrderEditForm = new SaleOrderEditForm();
        OrderLineForm orderLineForm;

        for (OrderLine ol : orderLineData) {
            this.orderLineDataAux.fillMainData(ol);
            saleOrderEditForm.clickAddItemOrderLine();
            orderLineForm = new OrderLineForm();
            orderLineForm.modifyOrderLine(ol);
        }
    }

    @And("^get main data from current sale order$")
    public void get_main_data_from_current_sale_order() throws Throwable {
        SaleOrderReadForm saleOrderReadForm = new SaleOrderReadForm();
        this.saleOrderAux.fillMainData(saleOrderReadForm.getMainData());
    }
}
