package com.jalasoft.automation.erp.steps.hhrr.employee;

import com.jalasoft.automation.erp.api.WebServiceAPI;
import com.jalasoft.automation.erp.objects.general.OdooObject;
import com.jalasoft.automation.erp.objects.hhrr.employee.*;
import com.jalasoft.automation.erp.objects.utils.IDGenerator;
import com.jalasoft.automation.erp.portal.ui.components.OdooForm;
import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.portal.ui.pages.general.GeneralButtonsBar;
import com.jalasoft.automation.erp.portal.ui.pages.general.MainMenu;
import com.jalasoft.automation.erp.portal.ui.pages.general.Search;
import com.jalasoft.automation.erp.portal.ui.pages.hhrr.Submenu;
import com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee.*;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import gherkin.formatter.model.DataTableRow;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;

import java.net.URL;
import java.util.*;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;

/**
 * Created by Henry Benito on 1/28/2016.
 */
public class EmployeeSteps {
    final String basicInfo = "basic",
                 publicInfo = "public",
                 personalInfo = "personal",
                 hhrrInfo = "hhrr",
                 engineeringInfo = "engineering";
    final String ndaInfo = "nda",
                 nationalityInfo = "nationality",
                 emergencyContactsInfo = "emergency",
                 familyMembersInfo = "family",
                 projectsInfo = "project",
                 internalCareerInfo = "internal",
                 externalCareerInfo = "external";
    EmployeeFactory employeeFactory = new EmployeeFactory();


    @And("^I search employee \"([^\"]*)\" into employee list view$")
    public void I_search_employee_into_employee_list_view(String employeeName) throws Throwable {

        Search openERPSearch = new Search();
        EmployeeListView employeeListView = new EmployeeListView();
        try {
                employeeListView.clickOnRecord(employeeName);
        } catch(NoSuchElementException nsse) {
            openERPSearch.advancedSearch("Name",employeeName);
            employeeListView.clickOnRecord(employeeName);
        }
        Thread.sleep(3000);
    }

    /*
     ========================
     Verify simple data Steps
     ========================
     */

    @And("^I verify if he has( not|)? this data in basic information$")
    public void I_verify_if_he_has_this_data_in_basic_information(String hasOrNot,
                                                                  List<BasicInfoEmployee> expectedEmployeeData) throws Throwable {
        for (BasicInfoEmployee expectedDataFromStep : expectedEmployeeData) {
            Assert.assertTrue(matchData(hasOrNot, basicInfo, expectedDataFromStep));
        }
    }

    @And("^I verify if he has( not|)? this data in public information$")
    public void I_verify_if_he_has_this_data_in_public_information(String hasOrNot,
                                                                   List<PublicInfoEmployee> expectedEmployeeData) throws Throwable {
        for (PublicInfoEmployee expectedDataFromStep : expectedEmployeeData) {
            Assert.assertTrue(matchData(hasOrNot, publicInfo, expectedDataFromStep));
        }
    }

    @And("^I verify if he has( not|)? this simple data in personal information$")
    public void I_verify_if_he_has_this_simple_data_in_personal_information(String hasOrNot,
                                                                            List<PersonalInfoEmployee> expectedEmployeeData) throws Throwable {
        for (PersonalInfoEmployee expectedDataFromStep : expectedEmployeeData) {
            Assert.assertTrue(matchData(hasOrNot, personalInfo, expectedDataFromStep));
        }
    }

    @And("^I verify if he has( not|)? this simple data in hrdata information$")
    public void I_verify_if_he_has_this_simple_data_in_hrdata_information(String hasOrNot,
                                                                          List<HHRRInfoEmployee> expectedEmployeeData) throws Throwable {
        for (HHRRInfoEmployee expectedDataFromStep : expectedEmployeeData) {
            Assert.assertTrue(matchData(hasOrNot, hhrrInfo, expectedDataFromStep));
        }
    }

    @And("^I verify if he has( not|)? this simple data in engineering information$")
    public void I_verify_if_he_has_this_simple_data_in_engineering_information(String hasOrNot,
                                                                               List<EngInfoEmployee> expectedEmployeeData) throws Throwable {
        for (EngInfoEmployee expectedDataFromStep : expectedEmployeeData) {
            Assert.assertTrue(matchData(hasOrNot, engineeringInfo, expectedDataFromStep));
        }
    }

    /*
     ==========================
     Verify table content Steps
     ==========================
     */
    @And("^I verify if he has( not|)? this nda data$")
    public void I_verify_if_he_has_this_nda_data(String hasOrNot, List<NDA> expectedData) throws Throwable {
        List<OdooObject> expectedObjectData = new ArrayList<>();
        expectedObjectData.addAll(expectedData);
        Assert.assertTrue(matchDataTable(hasOrNot, personalInfo, ndaInfo, expectedObjectData));
    }

    @And("^I verify if he has( not|)? this nationality data$")
    public void I_verify_if_he_has_this_nationality_data(String hasOrNot, List<Nationality> expectedData) throws Throwable {
        List<OdooObject> expectedObjectData = new ArrayList<>();
        expectedObjectData.addAll(expectedData);
        Assert.assertTrue(matchDataTable(hasOrNot, personalInfo, nationalityInfo, expectedObjectData));
    }

    @And("^I verify if he has( not|)? this emergency contact data$")
    public void I_verify_if_he_has_this_emergency_contact_data(String hasOrNot, List<EmergencyContact> expectedData) throws Throwable {
        List<OdooObject> expectedObjectData = new ArrayList<>();
        expectedObjectData.addAll(expectedData);
        Assert.assertTrue(matchDataTable(hasOrNot, personalInfo, emergencyContactsInfo, expectedObjectData));
    }

    @And("^I verify if he has( not|)? this family data$")
    public void I_verify_if_he_has_this_family_data(String hasOrNot, List<FamilyMember> expectedData) throws Throwable {
        List<OdooObject> expectedObjectData = new ArrayList<>();
        expectedObjectData.addAll(expectedData);
        Assert.assertTrue(matchDataTable(hasOrNot, personalInfo, familyMembersInfo, expectedObjectData));
    }

    @And("^I verify if he has( not|)? this project data$")
    public void I_verify_if_he_has_this_project_data(String hasOrNot, List<Project> expectedData) throws Throwable {
        List<OdooObject> expectedObjectData = new ArrayList<>();
        expectedObjectData.addAll(expectedData);
        Assert.assertTrue(matchDataTable(hasOrNot, personalInfo, projectsInfo, expectedObjectData));
    }

    @And("^I verify if he has( not|)? this external career data$")
    public void I_verify_if_he_has_this_external_career_data(String hasOrNot, List<ExternalCareer> expectedData) throws Throwable {
        List<OdooObject> expectedObjectData = new ArrayList<>();
        expectedObjectData.addAll(expectedData);
        Assert.assertTrue(matchDataTable(hasOrNot, personalInfo, externalCareerInfo, expectedObjectData));
    }

    @And("^I verify if he has( not|)? this internal career data$")
    public void I_verify_if_he_has_this_internal_career_data(String hasOrNot, List<InternalCareer> expectedData) throws Throwable {
        List<OdooObject> expectedObjectData = new ArrayList<>();
        expectedObjectData.addAll(expectedData);
        Assert.assertTrue(matchDataTable(hasOrNot, personalInfo, internalCareerInfo, expectedObjectData));
    }

    /*
     ==========================
     Verify tags content Steps
     ==========================
     */
    @And("^I verify if he has( not|)? this tag data$")
    public void I_verify_if_he_has_this_tag_data(String hasOrNot, List<Tag> expectedData) throws Throwable {
        Boolean result= false;
        Boolean shouldBeAble = false;
        if (hasOrNot.isEmpty()) {
            shouldBeAble = true;
        }

        TagInfoReadForm tagInfoReadForm = new TagInfoReadForm();

        result = tagInfoReadForm.hasSameContent(shouldBeAble, expectedData);
        Assert.assertTrue(result);
    }

    @And("^I verify if he has( not|)? this holiday policies data$")
    public void I_verify_if_he_has_this_holiday_policies_data(String hasOrNot, List<Tag> expectedData) throws Throwable {
        Boolean result= false;
        Boolean shouldBeAble = false;
        if (hasOrNot.isEmpty()) {
            shouldBeAble = true;
        }

        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.selectTab(hhrrInfo);
        HolidayPoliciesInfoReadForm holidayPoliciesInfoReadForm = new HolidayPoliciesInfoReadForm();

        result = holidayPoliciesInfoReadForm.hasSameContent(shouldBeAble, expectedData);
        Assert.assertTrue(result);
    }

    @And("^I verify if he has( not|)? this other supervisors data$")
    public void I_verify_if_he_has_this_other_supervisors_data(String hasOrNot, List<Tag> expectedData) throws Throwable {
        Boolean result= false;
        Boolean shouldBeAble = false;
        if (hasOrNot.isEmpty()) {
            shouldBeAble = true;
        }

        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.selectTab(engineeringInfo);
        OtherSupervisorsInfoReadForm otherSupervisorsInfoReadForm = new OtherSupervisorsInfoReadForm();

        result = otherSupervisorsInfoReadForm.hasSameContent(shouldBeAble, expectedData);
        Assert.assertTrue(result);
    }

    /*
     ========================
     Modify simple data Steps
     ========================
     */
    @And("^I( should not|) modify the employee with basic data$")
    public void I_modify_the_employee_with_basic_data(String hasOrNot, List<BasicInfoEmployee> basicInfoData) throws Throwable {
        for (BasicInfoEmployee item : basicInfoData) {
            OdooObject itemInput = item;
            modifyData(hasOrNot, basicInfo, itemInput);
        }
    }

    @And("^I( should not|) modify the employee with public data$")
    public void I_modify_the_employee_with_public_data(String hasOrNot, List<PublicInfoEmployee> publicInfoData) throws Throwable {
        for (PublicInfoEmployee item : publicInfoData) {
            OdooObject itemInput = item;
            modifyData(hasOrNot, publicInfo, itemInput);
        }
    }

    @And("^I( should not|) modify the employee with personal data$")
    public void I_modify_the_employee_with_personal_data(String hasOrNot, List<PersonalInfoEmployee> personalInfoData) throws Throwable {
        for (PersonalInfoEmployee item : personalInfoData) {
            OdooObject itemInput = item;
            modifyData(hasOrNot, personalInfo, itemInput);
        }
    }

    @And("^I( should not|) modify the employee with hhrr data$")
    public void I_modify_the_employee_with_hhrr_data(String hasOrNot, List<HHRRInfoEmployee> hhrrInfoData) throws Throwable {
        for (HHRRInfoEmployee item : hhrrInfoData) {
            OdooObject itemInput = item;
            modifyData(hasOrNot, hhrrInfo, itemInput);
        }
    }

    @And("^I( should not|) modify the employee with engineering data$")
    public void I_modify_the_employee_with_engineering_data(String hasOrNot, List<EngInfoEmployee> engInfoData) throws Throwable {
        for (EngInfoEmployee item : engInfoData) {
            OdooObject itemInput = item;
            modifyData(hasOrNot, engineeringInfo, itemInput);
        }
    }


    @And("^I add this nda data to employee form$")
    public void I_add_this_nda_data_to_employee_form(List<NDA> ndaInfoData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        NDAInfoEditForm ndaInfoEditForm = new NDAInfoEditForm();
        employeeForm.selectTab(personalInfo);
        ndaInfoEditForm.addData(ndaInfoData);
    }

    @And("^I add this emergency contact data to employee form$")
    public void I_add_this_emergency_contact_data_to_employee_form(List<EmergencyContact> emergencyContactInfoData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        EmergencyContactInfoEditForm emergencyContactInfoEditForm = new EmergencyContactInfoEditForm();
        employeeForm.selectTab(personalInfo);
        emergencyContactInfoEditForm.addData(emergencyContactInfoData);
    }

    @And("^I add this family data to employee form$")
    public void I_add_this_family_data_to_employee_form(List<FamilyMember> familyMemberInfoData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        FamilyInfoEditForm familyInfoEditForm = new FamilyInfoEditForm();
        employeeForm.selectTab(hhrrInfo);
        familyInfoEditForm.addData(familyMemberInfoData);
    }

    @And("^I add this project data to employee form$")
    public void I_add_this_project_data_to_employee_form(List<Project> projectInfoData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        ProjectInfoEditForm familyInfoEditForm = new ProjectInfoEditForm();
        employeeForm.selectTab(engineeringInfo);
        familyInfoEditForm.addData(projectInfoData);
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
        employeeForm.selectTab(personalInfo);
        nationalityInfoEditForm.addData(nationalityInfoData);
    }

    @And("^I delete this nda data from employee form$")
    public void I_delete_this_nda_data_from_employee_form(List<NDA> ndaInfoData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        NDAInfoEditForm ndaInfoEditForm = new NDAInfoEditForm();
        employeeForm.selectTab(personalInfo);

        ndaInfoEditForm.removeData(ndaInfoData);
    }

    @And("^I delete this emergency contact data to employee form$")
    public void I_delete_this_emergency_contact_data_to_employee_form(List<EmergencyContact> infoData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        EmergencyContactInfoEditForm emergencyContactInfoEditForm = new EmergencyContactInfoEditForm();
        employeeForm.selectTab(personalInfo);

        emergencyContactInfoEditForm.removeData(infoData);
    }

    @And("^I delete this family data to employee form$")
    public void I_delete_this_family_data_to_employee_form(List<FamilyMember> infoData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        FamilyInfoEditForm familyInfoEditForm = new FamilyInfoEditForm();
        employeeForm.selectTab(hhrrInfo);

        familyInfoEditForm.removeData(infoData);
    }

    @And("^I delete this external career data to employee form$")
    public void I_delete_this_external_career_data_to_employee_form(List<ExternalCareer> infoData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        ExternalCareerInfoEditForm externalCareerInfoEditForm = new ExternalCareerInfoEditForm();
        employeeForm.selectTab("history");

        externalCareerInfoEditForm.removeData(infoData);
    }

    @And("^I delete this internal career data to employee form$")
    public void I_delete_this_internal_career_data_to_employee_form(List<InternalCareer> infoData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        InternalCareerInfoEditForm internalCareerInfoEditForm = new InternalCareerInfoEditForm();
        employeeForm.selectTab("history");

        internalCareerInfoEditForm.removeData(infoData);
    }

    @And("^I delete this nationality data to employee form$")
    public void I_delete_this_nationality_data_to_employee_form(List<Nationality> infoData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        NationalityInfoEditForm nationalityInfoEditForm = new NationalityInfoEditForm();
        employeeForm.selectTab(personalInfo);

        nationalityInfoEditForm.removeData(infoData);
    }

    @And("^I add this tag data to employee form$")
    public void I_add_this_tag_data_to_employee_form(List<Tag> inputData) throws Throwable {
        TagInfoEditForm tagInfoEditForm = new TagInfoEditForm();
        tagInfoEditForm.addTags(inputData);
    }

    @And("^I delete this tag data to employee form$")
    public void I_delete_this_tag_data_to_employee_form(List<Tag> inputData) throws Throwable {
        TagInfoEditForm tagInfoEditForm = new TagInfoEditForm();
        tagInfoEditForm.deleteTags(inputData);
    }

    @And("^I add this holiday policies data to employee form$")
    public void I_add_this_holiday_policies_data_to_employee_form(List<Tag> inputData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.selectTab(hhrrInfo);
        HolidayPoliciesInfoEditForm holidayPoliciesInfoEditForm = new HolidayPoliciesInfoEditForm();
        holidayPoliciesInfoEditForm.addTags(inputData);
    }

    @And("^I delete this holiday policies data to employee form$")
    public void I_delete_this_holiday_policies_data_to_employee_form(List<Tag> inputData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.selectTab(hhrrInfo);
        HolidayPoliciesInfoEditForm holidayPoliciesInfoEditForm = new HolidayPoliciesInfoEditForm();
        holidayPoliciesInfoEditForm.deleteTags(inputData);
    }

    @And("^I add this other supervisors data to employee form$")
    public void I_add_this_other_supervisors_data_to_employee_form(List<Tag> inputData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.selectTab(engineeringInfo);
        OtherSupervisorsInfoEditForm otherSupervisorsInfoEditForm = new OtherSupervisorsInfoEditForm();
        otherSupervisorsInfoEditForm.addTags(inputData);
    }

    @And("^I delete this other supervisors data to employee form$")
    public void I_delete_this_other_supervisors_data_to_employee_form(List<Tag> inputData) throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.selectTab(engineeringInfo);
        OtherSupervisorsInfoEditForm otherSupervisorsInfoEditForm = new OtherSupervisorsInfoEditForm();
        otherSupervisorsInfoEditForm.deleteTags(inputData);
    }

    @And("^I create an employee with required fields$")
    public void I_create_an_employee_with_required_fields(List<Employee> inputData) throws Throwable {
        MainMenu mainMenu = new MainMenu();
        Submenu accountingSubmenu = new Submenu();

        mainMenu.goToMenu(hhrrInfo);
        accountingSubmenu.goToSubmenu("employees", true);

        GeneralButtonsBar gralButtons;
        BasicInfoEmployee basicInfoEmployee;
        PublicInfoEmployee publicInfoEmployee;
        PersonalInfoEmployee personalInfoEmployee;
        EngInfoEmployee engInfoEmployee;

        EmployeeForm employeeForm;
        BasicInfoEditForm basicInfoEditForm;
        PublicInfoEditForm publicInfoEditForm;
        PersonalInfoEditForm personalInfoEditForm;
        EngInfoEditForm engInfoEditForm;

        for(Employee employee : inputData) {
            gralButtons = new GeneralButtonsBar();
            gralButtons.clickButton("create");
            Thread.sleep(3000);

            basicInfoEmployee = new BasicInfoEmployee();
            publicInfoEmployee = new PublicInfoEmployee();
            personalInfoEmployee = new PersonalInfoEmployee();
            engInfoEmployee = new EngInfoEmployee();

            employeeForm = new EmployeeForm();
            basicInfoEditForm = new BasicInfoEditForm();
            publicInfoEditForm = new PublicInfoEditForm();
            personalInfoEditForm = new PersonalInfoEditForm();
            engInfoEditForm = new EngInfoEditForm();


            basicInfoEmployee.firstName = employee.firstName;
            basicInfoEmployee.lastName = employee.lastName;
            basicInfoEditForm.modifyData(basicInfoEmployee);

            if (employee.user != null) {
                employeeForm.selectTab(publicInfo);
                publicInfoEmployee.user = employee.user;
                publicInfoEditForm.modifyData(publicInfoEmployee);
            }

            employeeForm.selectTab(personalInfo);
            personalInfoEmployee.idNumber = employee.idNumber;
            personalInfoEditForm.modifyData(personalInfoEmployee);

            employeeForm.selectTab(engineeringInfo);
            engInfoEmployee.manager = employee.manager;
            engInfoEmployee.lead = employee.lead;
            engInfoEditForm.modifyData(engInfoEmployee);

            gralButtons.clickButton("save");
            Thread.sleep(3000);
        }
    }


    @And("^I remove all emergency contact data from employee form$")
    public void I_remove_all_emergency_contact_data_from_employee_form() throws Throwable {
        EmployeeForm employeeForm = new EmployeeForm();
        EmergencyContactInfoEditForm emergencyContactInfoEditForm = new EmergencyContactInfoEditForm();
        employeeForm.selectTab(personalInfo);

        emergencyContactInfoEditForm.deleteAllData();
    }

    @And("^I verify no one of these fields are read in public information$")
    public void I_verify_no_one_of_these_fields_are_read_in_public_information(List<PublicInfoEmployee> expectedPublicEmployeeData) throws Throwable {
        Boolean result= false;

        EmployeeForm employeeForm = new EmployeeForm();
        PublicInfoReadForm publicInfoReadForm = new PublicInfoReadForm();

        employeeForm.selectTab(publicInfo);
        for (PublicInfoEmployee item : expectedPublicEmployeeData) {
            PublicInfoEmployee aux = publicInfoReadForm.getDataFromUI(item);
            if(publicInfoReadForm.fieldsWereRead.isEmpty()) {result = true;}
        }
        Assert.assertTrue(result);
    }

    @And("^I verify no one of these fields are read in personal information$")
    public void I_verify_no_one_of_these_fields_are_read_in_personal_information(List<PersonalInfoEmployee> expectedPersonalEmployeeData) throws Throwable {
        Boolean result= false;

        EmployeeForm employeeForm = new EmployeeForm();
        PersonalInfoReadForm personalInfoReadForm = new PersonalInfoReadForm();

        employeeForm.selectTab(personalInfo);
        for (PersonalInfoEmployee item : expectedPersonalEmployeeData) {
            PersonalInfoEmployee aux = personalInfoReadForm.getDataFromUI(item);
            if(personalInfoReadForm.fieldsWereRead.isEmpty()) {result = true;}
        }
        Assert.assertTrue(result);
    }

    @And("^I verify no one of these fields are read in hhrr information$")
    public void I_verify_no_one_of_these_fields_are_read_in_hhrr_information(List<HHRRInfoEmployee> expectedHHRREmployeeData) throws Throwable {
        Boolean result= false;

        EmployeeForm employeeForm = new EmployeeForm();
        HHRRInfoReadForm hhrrInfoReadForm = new HHRRInfoReadForm();

        employeeForm.selectTab(hhrrInfo);
        for (HHRRInfoEmployee item : expectedHHRREmployeeData) {
            HHRRInfoEmployee aux = hhrrInfoReadForm.getDataFromUI(item);
            if(hhrrInfoReadForm.fieldsWereRead.isEmpty()) {result = true;}
        }
        Assert.assertTrue(result);
    }

    @And("^I verify no one of these fields are read in engineering information$")
    public void I_verify_no_one_of_these_fields_are_read_in_engineering_information(List<EngInfoEmployee> expectedEngEmployeeData) throws Throwable {
        Boolean result= false;

        EmployeeForm employeeForm = new EmployeeForm();
        EngInfoReadForm engInfoReadForm = new EngInfoReadForm();

        employeeForm.selectTab(engineeringInfo);
        for (EngInfoEmployee item : expectedEngEmployeeData) {
            EngInfoEmployee aux = engInfoReadForm.getDataFromUI(item);
            if(engInfoReadForm.fieldsWereRead.isEmpty()) {result = true;}
        }
        Assert.assertTrue(result);
    }

    @And("^I verify if he is not able to go to \"([^\"]*)\" employee tab$")
    public void I_verify_if_he_is_not_able_to_go_to_employee_tab(String tab) throws Throwable {
        boolean gone;
        EmployeeForm employeeForm = new EmployeeForm();
        try {
            employeeForm.selectTab(tab);
            gone = true;
        } catch (ElementNotVisibleException enve) {
            gone = false;
        }
        Assert.assertFalse(gone);
    }

    @And("^I( should not|)? modify the employee info with this \"([^\"]*)\" data$")
    public void I_modify_the_employee_info_with_this_data(String hasOrNot,
                                                          String employeeDataType,
                                                          List<OdooObject> inputData) throws Throwable {
        Boolean shouldBeAble = false;
        if (hasOrNot.isEmpty()) {
            shouldBeAble = true;
        }
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.selectTab("employeeDataType");

        OdooForm employeeEditForm = employeeFactory.getForm(employeeDataType, true);

        for (OdooObject input : inputData) {
            employeeEditForm.modifyData(input);
            if ((!employeeEditForm.fieldsWereEdited.isEmpty() && !shouldBeAble) ||
                (!employeeEditForm.fieldsWereNotEdited.isEmpty() && shouldBeAble)) {
                Assert.fail();
            }
        }
    }

    /*
     ========================
     API Steps
     ========================
     */
    @And("^remove this \"([^\"]*)\" employee via api with this credentials \"([^\"]*)\"$")
    public void removeThisEmployeeViaApiWithThisCredentials(String employeeName, String credentials) throws Throwable {
        WebServiceAPI api = new WebServiceAPI();
        api.authenticate(credentials);
        Assert.assertTrue(api.delete("hr.employee", "name" , employeeName));
    }

    @And("^create employee via api with this credentials \"([^\"]*)\"$")
    public void createEmployeeViaApiWithThisCredentials(String credentials, DataTable inputData) throws Throwable {
        HashMap<String, String> employeeMap = new HashMap();
        for (DataTableRow row : inputData.getGherkinRows()) {
            employeeMap.put(row.getCells().get(0),
                    row.getCells().get(1));
        }
        WebServiceAPI api = new WebServiceAPI();
        api.authenticate(credentials);
        int empID = api.create("hr.employee", employeeMap);
    }

    @And("^create employee with random name via api with this credentials \"([^\"]*)\"$")
    public void createEmployeeWithRandomNameViaApiWithThisCredentials(String credentials) throws Throwable {
        HashMap<String, String> employeeMap = new HashMap();
        IDGenerator idGen = new IDGenerator();
        String randomName = "random emp " + idGen.getRandomString(8);
        employeeMap.put("name", randomName);
        WebServiceAPI api = new WebServiceAPI();
        api.authenticate(credentials);
        int empID = api.create("hr.employee", employeeMap);
        String empName = randomName;
    }

    /*
     ========================
     Common Methods
     ========================
     */
    public void modifyData(String hasOrNot,
                           String employeeDataType,
                           OdooObject inputData) {
        Boolean shouldBeAble = false;
        if (hasOrNot.isEmpty()) {
            shouldBeAble = true;
        }
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.selectTab(employeeDataType);

        OdooForm employeeEditForm = employeeFactory.getForm(employeeDataType, true);

        employeeEditForm.modifyData(inputData);
        if ((!employeeEditForm.getListNonAffected().isEmpty() && shouldBeAble) ||
            (!employeeEditForm.getListAffected().isEmpty() && !shouldBeAble)) {
            Assert.fail();
        }
    }

    public boolean matchData(String hasOrNot,
                             String employeeDataType,
                             OdooObject dataFromStep) {
        Boolean result= false;
        Boolean shouldBeAble = false;
        if (hasOrNot.isEmpty()) {
            shouldBeAble = true;
        }
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.selectTab(employeeDataType);

        OdooForm employeeReadForm = employeeFactory.getForm(employeeDataType, false);
        OdooObject dataFromUI = employeeReadForm.getDataFromUI(dataFromStep);
        Boolean auxResult = dataFromStep.matchWith(shouldBeAble, dataFromUI);
        if (auxResult) {result = true;}
        return result;
    }

    public boolean matchDataTable(String hasOrNot,
                                  String employeeDataType,String employeeDataName,
                                  List<OdooObject> dataFromStep) {
        Boolean shouldBeAble = false;
        if (hasOrNot.isEmpty()) {
            shouldBeAble = true;
        }
        EmployeeForm employeeForm = new EmployeeForm();
        employeeForm.selectTab(employeeDataType);

        TableOpenERP employeeReadForm = employeeFactory.getTableForm(employeeDataName, false);
        return employeeReadForm.hasSameContent(shouldBeAble, dataFromStep);
    }


}
