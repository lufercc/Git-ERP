package com.jalasoft.automation.erp.steps.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.SupplierInvoice;
import com.jalasoft.automation.erp.portal.ui.custom.selog.purchase.PurchaseOrder;
import com.jalasoft.automation.erp.portal.ui.pages.general.Search;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.AssetsListView;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.SupplierInvoiceEditForm;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.SupplierInvoiceReadForm;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.SupplierInvoicesList;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import org.junit.Assert;

import java.util.List;

/**
 * Created by Henry Benito on 10/29/2015.
 */
public class SupplierInvoicesSteps {

    PurchaseOrder purchaseOrderAux;
    SupplierInvoice supplierInvoiceAux;
    String searchBy = "Source Document";

    public SupplierInvoicesSteps(PurchaseOrder purchaseOrderInput, SupplierInvoice supplierInvoiceInput) {
        purchaseOrderAux = purchaseOrderInput;
        supplierInvoiceAux = supplierInvoiceInput;
    }

    @And("^I edit the supplier invoice with these data$")
    public void I_edit_the_supplier_invoice_with_these_data(List<SupplierInvoice> supplierInvoiceData) throws Throwable {
        SupplierInvoiceEditForm supInvoiceForm = new SupplierInvoiceEditForm();
        for (SupplierInvoice si : supplierInvoiceData) {
            supInvoiceForm.modifyData(si);
        }
    }

    @And("^I go to supplier invoice created from incoming shipment$")
    public void I_go_to_supplier_invoice_created_from_incoming_shipment() throws Throwable {
        Search openERPSearch = new Search();
        openERPSearch.advancedSearch(searchBy,purchaseOrderAux.code);
        SupplierInvoicesList supplierInvoicesList = new SupplierInvoicesList();
        supplierInvoicesList.goToRecord(purchaseOrderAux.code);
        Thread.sleep(2000);
    }

    @And("^get main data from current supplier invoice$")
    public void get_main_data_from_current_supplier_invoice() throws Throwable {
        SupplierInvoiceReadForm supplierInvoiceReadForm = new SupplierInvoiceReadForm();
        this.supplierInvoiceAux.fillMainData(supplierInvoiceReadForm.getMainData());
    }
}
