package com.jalasoft.automation.erp.steps.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.*;
import com.jalasoft.automation.erp.portal.ui.pages.general.Search;
import com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee.*;
import cucumber.api.java.en.And;
import org.junit.Assert;
import java.util.List;

/**
 * Created by Henry Benito on 1/28/2016.
 */
public class EmployeeSteps {
    @And("^I modify the employee with basic data$")
    public void I_modify_the_employee_with_basic_data(List<BasicInfoEmployee> basicInfoData) throws Throwable {
        BasicInfoEditForm basicInfoEditForm = new BasicInfoEditForm();

        for (BasicInfoEmployee item : basicInfoData) {
            basicInfoEditForm.modifyData(item);
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

    @And("^I modify the employee with public data$")
    public void I_modify_the_employee_with_public_data(List<PublicInfoEmployee> publicInfoData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        PublicInfoEditForm publicInfoEditForm = new PublicInfoEditForm();
        employeeForm.selectTab("public");

        for (PublicInfoEmployee item : publicInfoData) {
            publicInfoEditForm.modifyData(item);
        }
    }

    @And("^I modify the employee with personal data$")
    public void I_modify_the_employee_with_personal_data(List<PersonalInfoEmployee> personalInfoData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        PersonalInfoEditForm personalInfoEditForm = new PersonalInfoEditForm();
        employeeForm.selectTab("personal");

        for (PersonalInfoEmployee item : personalInfoData) {
            personalInfoEditForm.modifyData(item);
        }
    }

    @And("^I modify the employee with hhrr data$")
    public void I_modify_the_employee_with_hhrr_data(List<HHRRInfoEmployee> hhrrInfoData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        HHRRInfoEditForm hhrrInfoEditForm = new HHRRInfoEditForm();
        employeeForm.selectTab("hhrr");

        for (HHRRInfoEmployee item : hhrrInfoData) {
            hhrrInfoEditForm.modifyData(item);
        }
    }

    @And("^I modify the employee with engineering data$")
    public void I_modify_the_employee_with_engineering_data(List<EngInfoEmployee> engInfoData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        EngInfoEditForm engInfoEditForm = new EngInfoEditForm();
        employeeForm.selectTab("engineering");

        for (EngInfoEmployee item : engInfoData) {
            engInfoEditForm.modifyData(item);
        }
    }

    @And("^I add this nda data to employee form$")
    public void I_add_this_nda_data_to_employee_form(List<NDA> ndaInfoData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        NDAInfoEditForm ndaInfoEditForm = new NDAInfoEditForm();
        employeeForm.selectTab("personal");
        ndaInfoEditForm.addData(ndaInfoData);
    }

    @And("^I add this emergency contact data to employee form$")
    public void I_add_this_emergency_contact_data_to_employee_form(List<EmergencyContact> emergencyContactInfoData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        EmergencyContactInfoEditForm emergencyContactInfoEditForm = new EmergencyContactInfoEditForm();
        employeeForm.selectTab("personal");
        emergencyContactInfoEditForm.addData(emergencyContactInfoData);
    }

    @And("^I add this family data to employee form$")
    public void I_add_this_family_data_to_employee_form(List<FamilyMember> familyMemberInfoData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        FamilyInfoEditForm familyInfoEditForm = new FamilyInfoEditForm();
        employeeForm.selectTab("hhrr");
        familyInfoEditForm.addData(familyMemberInfoData);
    }

    @And("^I add this external career data to employee form$")
    public void I_add_this_external_career_data_to_employee_form(List<ExternalCareer> externalCareerInfoData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        ExternalCareerInfoEditForm externalCareerInfoEditForm = new ExternalCareerInfoEditForm();
        employeeForm.selectTab("history");
        externalCareerInfoEditForm.addData(externalCareerInfoData);
    }

    @And("^I add this internal career data to employee form$")
    public void I_add_this_internal_career_data_to_employee_form(List<InternalCareer> internalCareerInfoData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        InternalCareerInfoEditForm internalCareerInfoEditForm = new InternalCareerInfoEditForm();
        employeeForm.selectTab("history");
        internalCareerInfoEditForm.addData(internalCareerInfoData);
    }

    @And("^I add this nationality data to employee form$")
    public void I_add_this_nationality_data_to_employee_form(List<Nationality> nationalityInfoData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        NationalityInfoEditForm nationalityInfoEditForm = new NationalityInfoEditForm();
        employeeForm.selectTab("personal");
        nationalityInfoEditForm.addData(nationalityInfoData);
    }

    @And("^I delete this nda data from employee form$")
    public void I_delete_this_nda_data_from_employee_form(List<NDA> ndaInfoData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        NDAInfoEditForm ndaInfoEditForm = new NDAInfoEditForm();
        employeeForm.selectTab("personal");

        ndaInfoEditForm.removeData(ndaInfoData);
    }
}
