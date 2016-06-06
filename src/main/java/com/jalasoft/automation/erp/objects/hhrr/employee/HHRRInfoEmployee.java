package com.jalasoft.automation.erp.objects.hhrr.employee;

import com.jalasoft.automation.erp.objects.general.OdooObject;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class HHRRInfoEmployee extends OdooObject {
    public String user;
    public String gender;
    public String maritalStatus;
    public String numberChildren;
    public String startDate;
    public String endDate;
    public String hireDate;
    public String endHireDate;
    public String salaryReviewDate;
    public String workingSchedule;
    public String holidayGroup;
    public String vacationAnniversary;
    public String internalID;
    public String vacationAllocationPolicies;

    public void fillMainData(HHRRInfoEmployee aux) {
        this.user = aux.user;
        this.gender = aux.gender;
        this.maritalStatus = aux.maritalStatus;
        this.numberChildren = aux.numberChildren;
        this.startDate = aux.startDate;
        this.endDate = aux.endDate;
        this.hireDate = aux.hireDate;
        this.endHireDate = aux.endHireDate;
        this.salaryReviewDate = aux.salaryReviewDate;
        this.workingSchedule = aux.workingSchedule;
        this.holidayGroup = aux.holidayGroup;
        this.vacationAnniversary = aux.vacationAnniversary;
        this.internalID = aux.internalID;
        this.vacationAllocationPolicies = aux.vacationAllocationPolicies;
    }

    public boolean matchWith(boolean shouldContain, OdooObject inputData) {
        HHRRInfoEmployee uiData = (HHRRInfoEmployee)inputData;

        if (this.user != null) {
            if (this.user.equals(uiData.user) != shouldContain) {
                logWarning("user", this.user);
                return false;
            }
        }
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
        if (this.salaryReviewDate != null){
            if (this.salaryReviewDate.equals(uiData.salaryReviewDate) != shouldContain) {
                logWarning("salaryReviewMonth", this.salaryReviewDate);
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
        if (this.vacationAllocationPolicies != null){
            if (this.vacationAllocationPolicies.equals(uiData.vacationAllocationPolicies) != shouldContain) {
                logWarning("internalID", this.vacationAllocationPolicies);
                return false;
            }
        }
        return true;
    }
}
