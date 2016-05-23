package com.jalasoft.automation.erp.objects.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class HHRRInfoEmployee extends OdooObject {
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

    public boolean matchWith(boolean shouldContain, OdooObject inputData) {
        HHRRInfoEmployee uiData = (HHRRInfoEmployee)inputData;

        if (this.gender != null){
            if(this.gender.equals(uiData.gender) != shouldContain) {
                logWarning("gender", this.gender);
                return false;
            }
        }
        if (this.maritalStatus != null){
            if(this.maritalStatus.equals(uiData.maritalStatus) != shouldContain) {
                logWarning("maritalStatus", this.maritalStatus);
                return false;
            }
        }
        if (this.numberChildren != null){
            if (this.numberChildren.equals(uiData.numberChildren) != shouldContain) {
                logWarning("numberChildren", this.numberChildren);
                return false;
            }
        }
        if (this.startDate != null){
            if (this.startDate.equals(uiData.startDate) != shouldContain) {
                logWarning("startDate", this.startDate);
                return false;
            }
        }
        if (this.endDate != null){
            if (this.endDate.equals(uiData.endDate) != shouldContain) {
                logWarning("endDate", this.endDate);
                return false;
            }
        }
        if (this.hireDate != null){
            if (this.hireDate.equals(uiData.hireDate) != shouldContain) {
                logWarning("hireDate", this.hireDate);
                return false;
            }
        }
        if (this.endHireDate != null){
            if (this.endHireDate.equals(uiData.endHireDate) != shouldContain) {
                logWarning("endHireDate", this.endHireDate);
                return false;
            }
        }
        if (this.salaryReviewMonth != null){
            if (this.salaryReviewMonth.equals(uiData.salaryReviewMonth) != shouldContain) {
                logWarning("salaryReviewMonth", this.salaryReviewMonth);
                return false;
            }
        }
        if (this.workingSchedule != null){
            if (this.workingSchedule.equals(uiData.workingSchedule) != shouldContain) {
                logWarning("workingSchedule", this.workingSchedule);
                return false;
            }
        }
        if (this.holidayGroup != null){
            if (this.holidayGroup.equals(uiData.holidayGroup) != shouldContain) {
                logWarning("holidayGroup", this.holidayGroup);
                return false;
            }
        }
        if (this.vacationAnniversary != null){
            if (this.vacationAnniversary.equals(uiData.vacationAnniversary) != shouldContain) {
                logWarning("vacationAnniversary", this.vacationAnniversary);
                return false;
            }
        }
        if (this.internalID != null){
            if (this.internalID.equals(uiData.internalID) != shouldContain) {
                logWarning("internalID", this.internalID);
                return false;
            }
        }
        return true;
    }
}
