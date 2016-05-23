package com.jalasoft.automation.erp.objects.selog.accounting;

import com.jalasoft.automation.erp.objects.ui.custom.hhrr.GeneralRecord;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class SupplierInvoice extends GeneralRecord {

    public String supplier;
    public String purchaseTaxType;
    public String fiscalPosition;
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
    public String amountNoVAT;
    public String ice;
    public String total;
    public String balance;

    public void fillMainData(SupplierInvoice aux) {
        code = aux.code;
    }

    public boolean contains(boolean shouldContain, SupplierInvoice uiData) {
        if (supplierInvoiceName != null) {
            if(supplierInvoiceName.equals(uiData.supplierInvoiceName) != shouldContain) {
                logWarning("supplierInvoiceName", supplierInvoiceName);
                return false;
            }
        }
        if (fiscalPosition != null) {
            if(fiscalPosition.equals(uiData.fiscalPosition) != shouldContain) {
                logWarning("fiscalPosition", fiscalPosition);
                return false;
            }
        }
        if (tin != null) {
            if (tin.equals(uiData.tin) != shouldContain) {
                logWarning("tin", tin);
                return false;
            }
        }
        if (subtotal != null) {
            if (subtotal.equals(uiData.subtotal) != shouldContain) {
                logWarning("subtotal", subtotal);
                return false;
            }
        }
        if (tax != null) {
            if (tax.equals(uiData.tax) != shouldContain) {
                logWarning("tax", tax);
                return false;
            }
        }
        if (total != null) {
            if (total.equals(uiData.total) != shouldContain) {
                logWarning("total", total);
                return false;
            }
        }
        if (balance != null) {
            if (balance.equals(uiData.balance) != shouldContain) {
                logWarning("balance", balance);
                return false;
            }
        }
        return true;
    }
}
