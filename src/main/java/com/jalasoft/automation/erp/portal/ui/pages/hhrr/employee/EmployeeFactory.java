package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.OdooForm;
import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;

/**
 * Created by Henry Benito on 5/18/2016.
 */
public class EmployeeFactory {

    public OdooForm getForm(String infoType, boolean editMode) {
        switch (infoType) {
        case "basic":
            if (editMode) {
                return new BasicInfoEditForm();
            } else {
                return new BasicInfoReadForm();
            }
        case "public":
            if (editMode) {
                return new PublicInfoEditForm();
            } else {
                return new PublicInfoReadForm();
            }
        case "personal":
            if (editMode) {
                return new PersonalInfoEditForm();
            } else {
                return new PersonalInfoReadForm();
            }
        case "hhrr":
            if (editMode) {
                return new HHRRInfoEditForm();
            } else {
                return new HHRRInfoReadForm();
            }
        case "engineering":
            if (editMode) {
                return new EngInfoEditForm();
            } else {
                return new EngInfoReadForm();
            }
        }
        return null;
    }

    public TableOpenERP getTableForm(String infoType, boolean editMode) {
        switch (infoType) {
            case "nda":
                if (editMode) {
                    return new NDAInfoEditForm();
                } else {
                    return new NDAInfoReadForm();
                }
            case "nationality":
                if (editMode) {
                    return new NationalityInfoEditForm();
                } else {
                    return new NationalityInfoReadForm();
                }
            case "emergency":
                if (editMode) {
                    return new EmergencyContactInfoEditForm();
                } else {
                    return new EmergencyContactInfoReadForm();
                }
            case "family":
                if (editMode) {
                    return new FamilyInfoEditForm();
                } else {
                    return new FamilyInfoReadForm();
                }
            case "project":
                if (editMode) {
                    return new ProjectInfoEditForm();
                } else {
                    return new ProjectInfoReadForm();
                }
            case "internal":
                if (editMode) {
                    return new InternalCareerInfoEditForm();
                } else {
                    return new InternalCareerInfoReadForm();
                }
            case "external":
                if (editMode) {
                    return new ExternalCareerInfoEditForm();
                } else {
                    return new ExternalCareerInfoReadForm();
                }
        }
        return null;
    }
}
