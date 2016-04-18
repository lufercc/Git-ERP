package com.jalasoft.automation.erp.portal.ui.custom.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.custom.hhrr.GeneralRecord;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class SupplierInvoice extends GeneralRecord {

    public String supplier;
    public String purchaseTaxType;
    public String code;
    public String supplierInvoiceName;
    public String tin;
    public String number;
    public String supplierReceiptNumber;
    public String authorizationNumber;
    public String controlCode;
    public String verificationTotal;
    public String invoiceDate;
    public String subtotal;
    public String tax;
    public String total;
    public String balance;

    public void fillMainData(SupplierInvoice aux) {
        code = aux.code;
    }

    public boolean contains(boolean shouldContain, SupplierInvoice uiData) {
        if (this.supplierInvoiceName != null) {
            if(supplierInvoiceName.equals(uiData.supplierInvoiceName) != shouldContain) {
                logWarning("supplierInvoiceName", supplierInvoiceName);
                return false;
            }
        }
        if (this.tin != null) {
            if (tin.equals(uiData.tin) != shouldContain) {
                logWarning("tin", tin);
                return false;
            }
        }
        if (this.subtotal != null) {
            if (subtotal.equals(uiData.subtotal) != shouldContain) {
                logWarning("subtotal", subtotal);
                return false;
            }
        }
        if (this.tax != null) {
            if (tax.equals(uiData.tax) != shouldContain) {
                logWarning("tax", tax);
                return false;
            }
        }
        if (this.total != null) {
            if (total.equals(uiData.total) != shouldContain) {
                logWarning("total", total);
                return false;
            }
        }
        if (this.balance != null) {
            if (balance.equals(uiData.balance) != shouldContain) {
                logWarning("balance", balance);
                return false;
            }
        }
        return true;
    }
}
