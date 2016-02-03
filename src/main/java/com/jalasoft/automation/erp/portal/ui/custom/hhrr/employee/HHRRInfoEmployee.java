package com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class HHRRInfoEmployee {

    public String gender;
    public String maritalStatus;
    public String numberChildren;
    public String startDate;
    public String endDate;
    public String hireDate;
    public String endHireDate;
    public String salaryReviewMonth;
    public String workingSchedule;
    public String holidayGroup;
    public String vacationAnniversary;
    public String internalID;

    public void fillMainData(HHRRInfoEmployee aux) {
        this.gender = (aux.gender != null) ? aux.gender : null;
        this.maritalStatus = (aux.maritalStatus != null) ? aux.maritalStatus : null;
        this.numberChildren = (aux.numberChildren != null) ? aux.numberChildren : null;
        this.startDate = (aux.startDate != null) ? aux.startDate : null;
        this.endDate = (aux.endDate != null) ? aux.endDate : null;
        this.hireDate = (aux.hireDate != null) ? aux.hireDate : null;
        this.endHireDate = (aux.endHireDate != null) ? aux.endHireDate : null;
        this.salaryReviewMonth = (aux.salaryReviewMonth != null) ? aux.salaryReviewMonth : null;
        this.workingSchedule = (aux.workingSchedule != null) ? aux.workingSchedule : null;
        this.holidayGroup = (aux.holidayGroup != null) ? aux.holidayGroup : null;
        this.vacationAnniversary = (aux.vacationAnniversary != null) ? aux.vacationAnniversary : null;
        this.internalID = (aux.internalID != null) ? aux.internalID : null;
    }

    public boolean contains(HHRRInfoEmployee mainData) {
        if(!this.gender.equals(mainData.gender)) {return false;}
        if(!this.maritalStatus.equals(mainData.maritalStatus)) {return false;}
        if(!this.numberChildren.equals(mainData.numberChildren)) {return false;}
        if(!this.startDate.equals(mainData.startDate)) {return false;}
        if(!this.endDate.equals(mainData.endDate)) {return false;}
        if(!this.hireDate.equals(mainData.hireDate)) {return false;}
        if(!this.endHireDate.equals(mainData.endHireDate)) {return false;}
        if(!this.salaryReviewMonth.equals(mainData.salaryReviewMonth)) {return false;}
        if(!this.workingSchedule.equals(mainData.workingSchedule)) {return false;}
        if(!this.holidayGroup.equals(mainData.holidayGroup)) {return false;}
        if(!this.vacationAnniversary.equals(mainData.vacationAnniversary)) {return false;}
        if(!this.internalID.equals(mainData.internalID)) {return false;}
        return true;
    }
}
