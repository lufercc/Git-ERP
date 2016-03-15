package com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.custom.hhrr.GeneralRecord;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class HHRRInfoEmployee extends GeneralRecord {
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

        if (this.gender != null){
            if(!this.gender.equals(mainData.gender)) {
                logWarning("gender", this.gender);
                return false;
            }
        }
        if (this.maritalStatus != null){
            if(!this.maritalStatus.equals(mainData.maritalStatus)) {
                logWarning("maritalStatus", this.maritalStatus);
                return false;
            }
        }
        if (this.numberChildren != null){
            if(!this.numberChildren.equals(mainData.numberChildren)) {
                logWarning("numberChildren", this.numberChildren);
                return false;
            }
        }
        if (this.startDate != null){
            if(!this.startDate.equals(mainData.startDate)) {
                logWarning("startDate", this.startDate);
                return false;
            }
        }
        if (this.endDate != null){
            if(!this.endDate.equals(mainData.endDate)) {
                logWarning("endDate", this.endDate);
                return false;
            }
        }
        if (this.hireDate != null){
            if(!this.hireDate.equals(mainData.hireDate)) {
                logWarning("hireDate", this.hireDate);
                return false;
            }
        }
        if (this.endHireDate != null){
            if(!this.endHireDate.equals(mainData.endHireDate)) {
                logWarning("endHireDate", this.endHireDate);
                return false;
            }
        }
        if (this.salaryReviewMonth != null){
            if(!this.salaryReviewMonth.equals(mainData.salaryReviewMonth)) {
                logWarning("salaryReviewMonth", this.salaryReviewMonth);
                return false;
            }
        }
        if (this.workingSchedule != null){
            if(!this.workingSchedule.equals(mainData.workingSchedule)) {
                logWarning("workingSchedule", this.workingSchedule);
                return false;
            }
        }
        if (this.holidayGroup != null){
            if(!this.holidayGroup.equals(mainData.holidayGroup)) {
                logWarning("holidayGroup", this.holidayGroup);
                return false;
            }
        }
        if (this.vacationAnniversary != null){
            if(!this.vacationAnniversary.equals(mainData.vacationAnniversary)) {
                logWarning("vacationAnniversary", this.vacationAnniversary);
                return false;
            }
        }
        if (this.internalID != null){
            if(!this.internalID.equals(mainData.internalID)) {
                logWarning("internalID", this.internalID);
                return false;
            }
        }
        return true;
    }
}
