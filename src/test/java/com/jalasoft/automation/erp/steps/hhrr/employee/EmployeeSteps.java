package com.jalasoft.automation.erp.steps.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.*;
import com.jalasoft.automation.erp.portal.ui.pages.general.Search;
import com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee.*;
import cucumber.api.PendingException;import cucumber.api.java.en.And;
import org.apache.xpath.operations.Bool;
import org.junit.Assert;

import java.util.List;

/**
 * Created by Henry Benito on 1/28/2016.
 */
public class EmployeeSteps {
    @And("^I modify the employee with basic data$")
    public void I_modify_the_employee_with_basic_data(List<BasicInfoEmployee> basicEmployeeData) throws Throwable {
        BasicEmpEditForm basicEmpEditForm = new BasicEmpEditForm();

        for (BasicInfoEmployee item : basicEmployeeData) {
            basicEmpEditForm.modifyData(item);
        }
    }

    @And("^I search employee \"([^\"]*)\" into employee list view$")
    public void I_search_employee_into_employee_list_view(String employeeName) throws Throwable {
        Search openERPSearch = new Search();
        openERPSearch.advancedSearch("Nombre",employeeName);
        EmployeeListView assetsAssignationListView = new EmployeeListView();
        assetsAssignationListView.clickOnRecord(employeeName);
    }

    @And("^I verify if he has this data in basic information$")
    public void I_verify_if_he_has_this_data_in_basic_information(List<BasicInfoEmployee> expectedBasicEmployeeData) throws Throwable {
        Boolean result= true;
        BasicInfoReadForm basicInfoReadForm = new BasicInfoReadForm();

        for (BasicInfoEmployee item : expectedBasicEmployeeData) {
            Boolean auxResult = item.contains(basicInfoReadForm.getMainData());
            if(!auxResult) {result = false;}
        }
        Assert.assertTrue(result);
    }

    @And("^I verify if he has this data in public information$")
    public void I_verify_if_he_has_this_data_in_public_information(List<PublicInfoEmployee> expectedPublicEmployeeData) throws Throwable {
        Boolean result= true;
        EmployeeForm employeeForm = new EmployeeForm();
        PublicInfoReadForm publicInfoReadForm = new PublicInfoReadForm();

        employeeForm.selectTab("public");
        for (PublicInfoEmployee item : expectedPublicEmployeeData) {
            Boolean auxResult = item.contains(publicInfoReadForm.getMainData());
            if(!auxResult) {result = false;}
        }
        Assert.assertTrue(result);
    }

    @And("^I verify if he has this simple data in personal information$")
    public void I_verify_if_he_has_this_simple_data_in_personal_information(List<PersonalInfoEmployee> expectedPersonalEmployeeData) throws Throwable {
        Boolean result= true;
        EmployeeForm employeeForm = new EmployeeForm();
        PersonalInfoReadForm personalInfoReadForm = new PersonalInfoReadForm();

        employeeForm.selectTab("personal");
        for (PersonalInfoEmployee item : expectedPersonalEmployeeData) {
            Boolean auxResult = item.contains(personalInfoReadForm.getMainData());
            if(!auxResult) {result = false;}
        }
        Assert.assertTrue(result);
    }

    @And("^I verify if he has this simple data in hrdata information$")
    public void I_verify_if_he_has_this_simple_data_in_hrdata_information(List<HHRRInfoEmployee> expectedHHRREmployeeData) throws Throwable {
        Boolean result= true;
        EmployeeForm employeeForm = new EmployeeForm();
        HHRRInfoReadForm hhrrInfoReadForm = new HHRRInfoReadForm();

        employeeForm.selectTab("hhrr");
        for (HHRRInfoEmployee item : expectedHHRREmployeeData) {
            Boolean auxResult = item.contains(hhrrInfoReadForm.getMainData());
            if(!auxResult) {result = false;}
        }
        Assert.assertTrue(result);
    }

    @And("^I verify if he has this simple data in engineering information$")
    public void I_verify_if_he_has_this_simple_data_in_engineering_information(List<EngInfoEmployee> expectedEngEmployeeData) throws Throwable {
        Boolean result= true;
        EmployeeForm employeeForm = new EmployeeForm();
        EngInfoReadForm engInfoReadForm = new EngInfoReadForm();

        employeeForm.selectTab("engineering");
        for (EngInfoEmployee item : expectedEngEmployeeData) {
            Boolean auxResult = item.contains(engInfoReadForm.getMainData());
            if(!auxResult) {result = false;}
        }
        Assert.assertTrue(result);
    }
}
