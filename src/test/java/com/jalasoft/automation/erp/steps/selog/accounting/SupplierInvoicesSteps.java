package com.jalasoft.automation.erp.steps.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.SupplierInvoice;
import com.jalasoft.automation.erp.portal.ui.pages.general.Search;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.AssetsListView;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.SupplierInvoiceEditForm;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.SupplierInvoiceReadForm;
import cucumber.api.java.en.And;
import org.junit.Assert;

import java.util.List;

/**
 * Created by Henry Benito on 10/29/2015.
 */
public class SupplierInvoicesSteps {

    SupplierInvoiceEditForm supInvoiceForm;

    @And("^I edit the supplier invoice with these data$")
    public void I_edit_the_supplier_invoice_with_these_data(List<SupplierInvoice> supplierInvoiceData) throws Throwable {
        this.supInvoiceForm = new SupplierInvoiceEditForm();
        for (SupplierInvoice si : supplierInvoiceData) {
            supInvoiceForm.modifyData(si);
        }
    }
}
