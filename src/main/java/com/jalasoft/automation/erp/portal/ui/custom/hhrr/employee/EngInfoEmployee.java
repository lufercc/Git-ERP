package com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee;

import org.apache.log4j.Logger;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class EngInfoEmployee {
    private Logger log;

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
        this.active = aux.active;
        this.consultant = aux.consultant;
        this.jce = aux.jce;
        this.reason = aux.reason;
        this.lastEvalDate = aux.lastEvalDate;
        this.nextEvalDate = aux.nextEvalDate;
    }

    public boolean contains(EngInfoEmployee mainData) {
        log = Logger.getLogger(getClass());

        if (this.department != null){
            if(!this.department.equals(mainData.department)) {
                logWarning("department", this.department);
                return false;
            }
        }

        if (this.division != null){
            if(!this.division.equals(mainData.division)) {
                logWarning("division",this.division);
                return false;
            }
        }
        if (this.jobTitle != null){
            if(!this.jobTitle.equals(mainData.jobTitle)) {
                logWarning("jobTitle",this.jobTitle);
                return false;
            }
        }
        if (this.manager != null){
            if(!this.manager.equals(mainData.manager)) {
                logWarning("manager",this.manager);
                return false;
            }
        }
        if (this.lead != null){
            if(!this.lead.equals(mainData.lead)) {
                logWarning("lead",this.lead);
                return false;
            }
        }
        if (this.visible != null){
            if(!this.visible.equals(mainData.visible)) {
                logWarning("visible",this.visible);
                return false;
            }
        }
        if (this.billable != null){
            if(!this.billable.equals(mainData.billable)) {
                logWarning("billable",this.billable);
                return false;
            }
        }

        if (this.shadowCategory != null){
            if(!this.shadowCategory.equals(mainData.shadowCategory)) {
                logWarning("shadowCategory",this.shadowCategory);
                return false;
            }
        }
        if (this.notes != null){
            if(!this.notes.equals(mainData.notes)) {
                logWarning("notes",this.notes);
                return false;
            }
        }
        if (this.commitment != null){
            if(!this.commitment.equals(mainData.commitment)) {
                logWarning("commitment",this.commitment);
                return false;
            }
        }
        if (this.active != null){
            if(!this.active.equals(mainData.active)) {
                logWarning("active",this.active);
                return false;
            }
        }
        if (this.consultant != null){
            if(!this.consultant.equals(mainData.consultant)) {
                logWarning("consultant",this.consultant);
                return false;
            }
        }
        if (this.jce != null){
            if(!this.jce.equals(mainData.jce)) {
                logWarning("jce",this.jce);
                return false;
            }
        }
        if (this.reason != null){
            if(!this.reason.equals(mainData.reason)) {
                logWarning("reason",this.reason);
                return false;
            }
        }
        if (this.lastEvalDate != null){
            if(!this.lastEvalDate.equals(mainData.lastEvalDate)) {
                logWarning("lastEvalDate",this.lastEvalDate);
                return false;
            }
        }
        if (this.nextEvalDate != null){
            if(!this.nextEvalDate.equals(mainData.nextEvalDate)) {
                logWarning("nextEvalDate",this.nextEvalDate);
                return false;
            }
        }
        return true;
    }

    public void logWarning(String field, String fieldValue) {
        log.warn("This expected field: '" + field + "=" + fieldValue + "' was not found in the UI");
    }
}
