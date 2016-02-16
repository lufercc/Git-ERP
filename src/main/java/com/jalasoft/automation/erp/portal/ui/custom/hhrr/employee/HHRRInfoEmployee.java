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
        this.gender = aux.gender;
        this.maritalStatus = aux.maritalStatus;
        this.numberChildren = aux.numberChildren;
        this.startDate = aux.startDate;
        this.endDate = aux.endDate;
        this.hireDate = aux.hireDate;
        this.endHireDate = aux.endHireDate;
        this.salaryReviewMonth = aux.salaryReviewMonth;
        this.workingSchedule = aux.workingSchedule;
        this.holidayGroup = aux.holidayGroup;
        this.vacationAnniversary = aux.vacationAnniversary;
        this.internalID = aux.internalID;
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
