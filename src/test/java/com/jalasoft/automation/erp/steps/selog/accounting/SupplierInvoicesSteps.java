package com.jalasoft.automation.erp.steps.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.SupplierInvoice;
import com.jalasoft.automation.erp.portal.ui.custom.selog.general.Product;
import com.jalasoft.automation.erp.portal.ui.custom.selog.general.Tax;
import com.jalasoft.automation.erp.portal.ui.custom.selog.purchase.PurchaseOrder;
import com.jalasoft.automation.erp.portal.ui.pages.general.Search;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
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
        Thread.sleep(3000);
    }

    @And("^I go to supplier invoice created from incoming shipment$")
    public void I_go_to_supplier_invoice_created_from_incoming_shipment() throws Throwable {
        Search openERPSearch = new Search();
        openERPSearch.advancedSearch(searchBy,purchaseOrderAux.code);
        Thread.sleep(3000);
        SupplierInvoicesList supplierInvoicesList = new SupplierInvoicesList();
        supplierInvoicesList.goToRecord(purchaseOrderAux.code);
    }

    @And("^get main data from current supplier invoice$")
    public void get_main_data_from_current_supplier_invoice() throws Throwable {
        SupplierInvoiceReadForm supplierInvoiceReadForm = new SupplierInvoiceReadForm();
        this.supplierInvoiceAux.fillMainData(supplierInvoiceReadForm.getMainData());
    }

    @And("^I verify if he has supplier invoice data on edit mode$")
    public void I_verify_if_he_has_supplier_invoice_data_on_edit_mode(List<SupplierInvoice> supplierInvoiceData) throws Throwable {
        Boolean auxResult = false;
        SupplierInvoiceEditForm supInvoiceForm = new SupplierInvoiceEditForm();
        for (SupplierInvoice si : supplierInvoiceData) {
            auxResult = si.contains(true, supInvoiceForm.getDataFromUI(si));
        }
        Assert.assertTrue(auxResult);
    }

    @Then("^I verify these fields are or not displayed on supplier invoice form$")
    public void I_verify_these_fields_are_or_not_displayed_on_supplier_invoice_form(List<SupplierInvoice> supplierInvoiceData) throws Throwable {
        Boolean auxResult = false;
        SupplierInvoiceEditForm supInvoiceForm = new SupplierInvoiceEditForm();
        for (SupplierInvoice si : supplierInvoiceData) {
            auxResult = supInvoiceForm.areDisplayed(si);
        }
        Assert.assertTrue(auxResult);
    }

    @And("^I add products with this data to supplier invoice$")
    public void I_add_products_with_this_data_to_supplier_invoice(List<Product> inputData) throws Throwable {
        SupplierInvoiceProductsEditForm supplierInvoiceProductsEditForm = new SupplierInvoiceProductsEditForm();
        supplierInvoiceProductsEditForm.addData(inputData);
    }

    @Then("^I verify products data( is not|)? on supplier invoice$")
    public void I_verify_products_data_on_supplier_invoice(String hasOrNot, List<Product> expectedData) throws Throwable {
        Boolean result= false;
        Boolean shouldBeAble = false;
        if (hasOrNot.isEmpty()) {
            shouldBeAble = true;
        }

        SupplierInvoiceProductsReadForm supplierInvoiceProductsReadForm = new SupplierInvoiceProductsReadForm();

        result = supplierInvoiceProductsReadForm.hasSameContent(shouldBeAble, expectedData);
        Assert.assertTrue(result);
    }

    @Then("^I verify taxes data( is not|)? on supplier invoice$")
    public void I_verify_taxes_data_on_supplier_invoice(String hasOrNot, List<Tax> expectedData) throws Throwable {
        Boolean result= false;
        Boolean shouldBeAble = false;
        if (hasOrNot.isEmpty()) {
            shouldBeAble = true;
        }

        SupplierInvoiceTaxesReadForm supplierInvoiceTaxesReadForm = new SupplierInvoiceTaxesReadForm();

        result = supplierInvoiceTaxesReadForm.hasSameContent(shouldBeAble, expectedData);
        Assert.assertTrue(result);
    }

    @Then("^I verify if he has supplier invoice data$")
    public void I_verify_if_he_has_supplier_invoice_data(List<SupplierInvoice> supplierInvoiceData) throws Throwable {
        Boolean auxResult = false;
        SupplierInvoiceReadForm supInvoiceForm = new SupplierInvoiceReadForm();
        for (SupplierInvoice si : supplierInvoiceData) {
            auxResult = si.contains(true, supInvoiceForm.getDataFromUI(si));
        }
        Assert.assertTrue(auxResult);
    }
}
