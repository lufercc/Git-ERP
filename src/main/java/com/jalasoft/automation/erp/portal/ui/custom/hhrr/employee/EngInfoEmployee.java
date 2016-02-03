package com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class EngInfoEmployee {

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
        this.department = (aux.department != null) ? aux.department : null;
        this.division = (aux.division != null) ? aux.division : null;
        this.jobTitle = (aux.jobTitle != null) ? aux.jobTitle : null;
        this.manager = (aux.manager != null) ? aux.manager : null;
        this.lead = (aux.lead != null) ? aux.lead : null;
        this.visible = (aux.visible != null) ? aux.visible : null;
        this.billable = (aux.billable != null) ? aux.billable : null;
        this.shadowCategory = (aux.shadowCategory != null) ? aux.shadowCategory : null;
        this.notes = (aux.notes != null) ? aux.notes : null;
        this.commitment = (aux.commitment != null) ? aux.commitment : null;
        this.active = (aux.active != null) ? aux.active : null;
        this.consultant = (aux.consultant != null) ? aux.consultant : null;
        this.jce = (aux.jce != null) ? aux.jce : null;
        this.reason = (aux.reason != null) ? aux.reason : null;
        this.lastEvalDate = (aux.lastEvalDate != null) ? aux.lastEvalDate : null;
        this.nextEvalDate = (aux.nextEvalDate != null) ? aux.nextEvalDate : null;
    }

    public boolean contains(EngInfoEmployee mainData) {
        if(!this.department.equals(mainData.department)) {return false;}
        if(!this.division.equals(mainData.division)) {return false;}
        if(!this.jobTitle.equals(mainData.jobTitle)) {return false;}
        if(!this.manager.equals(mainData.manager)) {return false;}
        if(!this.lead.equals(mainData.lead)) {return false;}
        mainData.visible = (mainData.visible == null) ? "false" : "true";
        if(!this.visible.equals(mainData.visible)) {return false;}
        mainData.billable = (mainData.billable == null) ? "false" : "true";
        if(!this.billable.equals(mainData.billable)) {return false;}
        if(!this.shadowCategory.equals(mainData.shadowCategory)) {return false;}
        if(!this.notes.equals(mainData.notes)) {return false;}
        mainData.commitment = (mainData.commitment == null) ? "false" : "true";
        if(!this.commitment.equals(mainData.commitment)) {return false;}
        mainData.active = (mainData.active == null) ? "false" : "true";
        if(!this.active.equals(mainData.active)) {return false;}
        mainData.consultant = (mainData.consultant == null) ? "false" : "true";
        if(!this.consultant.equals(mainData.consultant)) {return false;}
        mainData.jce = (mainData.jce == null) ? "false" : "true";
        if(!this.jce.equals(mainData.jce)) {return false;}
        if(!this.reason.equals(mainData.reason)) {return false;}
        if(!this.lastEvalDate.equals(mainData.lastEvalDate)) {return false;}
        if(!this.nextEvalDate.equals(mainData.nextEvalDate)) {return false;}
        return true;
    }
}
