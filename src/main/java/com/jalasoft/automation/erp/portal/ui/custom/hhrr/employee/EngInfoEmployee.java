package com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.custom.hhrr.GeneralRecord;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class EngInfoEmployee extends GeneralRecord {
    public String department;
    public String division;
    public String jobTitle;
    public String manager;
    public String lead;
    public String visible;
    public String billable;
    public String shadowCategory;
    public String notes;
    public String commitment;
    public String expDateCommit;
    public String active;
    public String consultant;
    public String jce;
    public String reason;
    public String lastEvalDate;
    public String nextEvalDate;

    public void fillMainData(EngInfoEmployee aux) {
        this.department = aux.department;
        this.division = aux.division;
        this.jobTitle = aux.jobTitle;
        this.manager = aux.manager;
        this.lead = aux.lead;
        this.visible = aux.visible;
        this.billable = aux.billable;
        this.shadowCategory = aux.shadowCategory;
        this.notes = aux.notes;
        this.commitment = aux.commitment;
        this.expDateCommit = aux.expDateCommit;
        this.active = aux.active;
        this.consultant = aux.consultant;
        this.jce = aux.jce;
        this.reason = aux.reason;
        this.lastEvalDate = aux.lastEvalDate;
        this.nextEvalDate = aux.nextEvalDate;
    }

    public boolean contains(boolean shouldContain, EngInfoEmployee mainData) {
        if (this.department != null) {
            if(this.department.equals(mainData.department) != shouldContain) {
                logWarning("department", this.department);
                return false;
            }
        }
        if (this.division != null) {
            if(this.division.equals(mainData.division) != shouldContain) {
                logWarning("division", this.division);
                return false;
            }
        }
        if (this.jobTitle != null) {
            if(this.jobTitle.equals(mainData.jobTitle) != shouldContain) {
                logWarning("jobTitle", this.jobTitle);
                return false;
            }
        }
        if (this.manager != null) {
            if(this.manager.equals(mainData.manager) != shouldContain) {
                logWarning("manager", this.manager);
                return false;
            }
        }
        if (this.lead != null) {
            if (this.lead.equals(mainData.lead) != shouldContain) {
                logWarning("lead", this.lead);
                return false;
            }
        }
        if (this.visible != null) {
            if (this.visible.equals(mainData.visible) != shouldContain) {
                logWarning("visible", this.visible);
                return false;
            }
        }
        if (this.billable != null) {
            if (this.billable.equals(mainData.billable) != shouldContain) {
                logWarning("billable", this.billable);
                return false;
            }
        }
        if (this.shadowCategory != null) {
            if (this.shadowCategory.equals(mainData.shadowCategory) != shouldContain) {
                logWarning("shadowCategory", this.shadowCategory);
                return false;
            }
        }
        if (this.notes != null) {
            if (this.notes.equals(mainData.notes) != shouldContain) {
                logWarning("notes", this.notes);
                return false;
            }
        }
        if (this.commitment != null) {
            if (this.commitment.equals(mainData.commitment) != shouldContain) {
                logWarning("commitment", this.commitment);
                return false;
            }
        }
        if (this.expDateCommit != null) {
            if (this.expDateCommit.equals(mainData.expDateCommit) != shouldContain) {
                logWarning("expDateCommit", this.expDateCommit);
                return false;
            }
        }
        if (this.active != null) {
            if (this.active.equals(mainData.active) != shouldContain) {
                logWarning("active", this.active);
                return false;
            }
        }
        if (this.consultant != null) {
            if (this.consultant.equals(mainData.consultant) != shouldContain) {
                logWarning("consultant", this.consultant);
                return false;
            }
        }
        if (this.jce != null) {
            if (this.jce.equals(mainData.jce) != shouldContain) {
                logWarning("jce", this.jce);
                return false;
            }
        }
        if (this.reason != null) {
            if (this.reason.equals(mainData.reason) != shouldContain) {
                logWarning("reason", this.reason);
                return false;
            }
        }
        if (this.lastEvalDate != null) {
            if (this.lastEvalDate.equals(mainData.lastEvalDate) != shouldContain) {
                logWarning("lastEvalDate", this.lastEvalDate);
                return false;
            }
        }
        if (this.nextEvalDate != null) {
            if (this.nextEvalDate.equals(mainData.nextEvalDate) != shouldContain) {
                logWarning("nextEvalDate", this.nextEvalDate);
                return false;
            }
        }
        return true;
    }
}
