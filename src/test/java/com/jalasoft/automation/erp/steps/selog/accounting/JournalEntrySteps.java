package com.jalasoft.automation.erp.steps.selog.accounting;

import com.jalasoft.automation.erp.portal.ui.custom.selog.accounting.JournalEntry;
import com.jalasoft.automation.erp.portal.ui.custom.selog.warehouse.DeliveryOrder;
import com.jalasoft.automation.erp.portal.ui.pages.general.Search;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.JournalEntriesListView;
import com.jalasoft.automation.erp.portal.ui.pages.selog.accounting.JournalEntryReadForm;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;

/**
 * Created by Henry Benito on 11/10/2015.
 */
public class JournalEntrySteps {
    JournalEntry journalEntryAux;
    DeliveryOrder deliveryOrderAux;
    String searchBy = "Reference";

    public JournalEntrySteps(JournalEntry journalEntryInput, DeliveryOrder deliveryOrderInput) {
        journalEntryAux = journalEntryInput;
        deliveryOrderAux = deliveryOrderInput;
    }

    @And("^I search delivery order in journal entries$")
    public void I_search_delivery_order_in_journal_entries() throws Throwable {
        Search openERPSearch = new Search();
        openERPSearch.advancedSearch(searchBy, this.deliveryOrderAux.code);
        JournalEntriesListView journalEntriesListView = new JournalEntriesListView();
        journalEntriesListView.clickOnRecord(this.deliveryOrderAux.code);
    }

    @And("^get main data from current journal entry$")
    public void get_main_data_from_current_journal_entry() throws Throwable {
        JournalEntryReadForm journalEntryReadForm = new JournalEntryReadForm();
        journalEntryAux.fillMainData(journalEntryReadForm.getMainData());
    }

    @And("^I search incoming shipments in journal entries$")
    public void I_search_incoming_shipments_in_journal_entries() throws Throwable {
        Search openERPSearch = new Search();
        openERPSearch.advancedSearch(searchBy, this.deliveryOrderAux.code);
        JournalEntriesListView journalEntriesListView = new JournalEntriesListView();
        journalEntriesListView.clickOnRecord(this.deliveryOrderAux.code);
    }
}
