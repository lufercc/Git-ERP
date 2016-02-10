package com.jalasoft.automation.erp.steps.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.*;
import com.jalasoft.automation.erp.portal.ui.pages.general.Search;
import com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
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

    @And("^I verify if he has this nda data$")
    public void I_verify_if_he_has_this_nda_data(List<NDA> expectedNDAData) throws Throwable {
        Boolean result= true;
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.selectTab("personal");
        NDAInfoReadForm ndaInfoReadForm = new NDAInfoReadForm();

        result = ndaInfoReadForm.hasSameContent(expectedNDAData);
        Assert.assertTrue(result);
    }

    @And("^I verify if he has this nationality data$")
    public void I_verify_if_he_has_this_nationality_data(List<Nationality> expectedData) throws Throwable {
        Boolean result= true;
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.selectTab("personal");
        NationalityInfoReadForm nationalityInfoReadForm = new NationalityInfoReadForm();

        result = nationalityInfoReadForm.hasSameContent(expectedData);
        Assert.assertTrue(result);
    }

    @And("^I verify if he has this emergency contact data$")
    public void I_verify_if_he_has_this_emergency_contact_data(List<EmergencyContact> expectedData) throws Throwable {
        Boolean result= true;
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.selectTab("personal");
        EmergencyContactInfoReadForm emergencyContactInfoReadForm = new EmergencyContactInfoReadForm();

        result = emergencyContactInfoReadForm.hasSameContent(expectedData);
        Assert.assertTrue(result);
    }

    @And("^I verify if he has this family data$")
    public void I_verify_if_he_has_this_family_data(List<FamilyMember> expectedData) throws Throwable {
        Boolean result= true;
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.selectTab("hhrr");
        FamilyInfoReadForm familyInfoReadForm = new FamilyInfoReadForm();

        result = familyInfoReadForm.hasSameContent(expectedData);
        Assert.assertTrue(result);
    }

    @And("^I verify if he has this project data$")
    public void I_verify_if_he_has_this_project_data(List<Project> expectedData) throws Throwable {
        Boolean result= true;
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.selectTab("engineering");
        ProjectInfoReadForm projectInfoReadForm = new ProjectInfoReadForm();

        result = projectInfoReadForm.hasSameContent(expectedData);
        Assert.assertTrue(result);
    }

    @And("^I verify if he has this external career data$")
    public void I_verify_if_he_has_this_external_career_data(List<ExternalCareer> expectedData) throws Throwable {
        Boolean result= true;
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.selectTab("history");
        ExternalCareerInfoReadForm externalCareerInfoReadForm = new ExternalCareerInfoReadForm();

        result = externalCareerInfoReadForm.hasSameContent(expectedData);
        Assert.assertTrue(result);
    }

    @And("^I verify if he has this internal career data$")
    public void I_verify_if_he_has_this_internal_career_data(List<InternalCareer> expectedData) throws Throwable {
        Boolean result= true;
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.selectTab("history");
        InternalCareerInfoReadForm internalCareerInfoReadForm = new InternalCareerInfoReadForm();

        result = internalCareerInfoReadForm.hasSameContent(expectedData);
        Assert.assertTrue(result);
    }

    @And("^I verify if he has this tag data$")
    public void I_verify_if_he_has_this_tag_data(List<Tag> expectedData) throws Throwable {
        Boolean result= true;
        EmployeeForm employeeForm = new EmployeeForm();
        TagInfoReadForm tagInfoReadForm = new TagInfoReadForm();

        result = tagInfoReadForm.hasSameContent(expectedData);
        Assert.assertTrue(result);
    }

    @And("^I verify if he has this holiday policies data$")
    public void I_verify_if_he_has_this_holiday_policies_data(List<Tag> expectedData) throws Throwable {
        Boolean result= true;
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.selectTab("hhrr");
        HolidayPoliciesInfoReadForm holidayPoliciesInfoReadForm = new HolidayPoliciesInfoReadForm();

        result = holidayPoliciesInfoReadForm.hasSameContent(expectedData);
        Assert.assertTrue(result);
    }

    @And("^I verify if he has this other supervisors data$")
    public void I_verify_if_he_has_this_other_supervisors_data(List<Tag> expectedData) throws Throwable {
        Boolean result= true;
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.selectTab("engineering");
        OtherSupervisorsInfoReadForm otherSupervisorsInfoReadForm = new OtherSupervisorsInfoReadForm();

        result = otherSupervisorsInfoReadForm.hasSameContent(expectedData);
        Assert.assertTrue(result);
    }
}
