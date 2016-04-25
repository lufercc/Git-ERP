package com.jalasoft.automation.erp.steps.selog.purchase;

import com.jalasoft.automation.erp.portal.ui.custom.selog.purchase.Supplier;
import com.jalasoft.automation.erp.portal.ui.pages.selog.purchase.SupplierEditForm;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;

import java.util.List;

/**
 * Created by Henry Benito on 4/19/2016.
 */
public class SupplierSteps {
    @And("^I edit the supplier with these \"([^\"]*)\" data$")
    public void I_edit_the_supplier_with_these_data(String tab, List<Supplier> inputData) throws Throwable {
        SupplierEditForm supplierEditForm = new SupplierEditForm();
        supplierEditForm.selectTab(tab);
        for (Supplier s : inputData) {
            supplierEditForm.modifyData(s);
        }
    }
}
