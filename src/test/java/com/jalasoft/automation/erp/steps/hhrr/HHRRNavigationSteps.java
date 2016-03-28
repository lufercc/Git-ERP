package com.jalasoft.automation.erp.steps.hhrr;

import com.jalasoft.automation.erp.portal.ui.pages.general.MainMenu;
import com.jalasoft.automation.erp.portal.ui.pages.hhrr.Submenu;
import cucumber.api.java.en.And;
import junit.framework.Assert;
import org.openqa.selenium.NoSuchElementException;

/**
 * Created by Henry Benito on 10/29/2015.
 */
public class HHRRNavigationSteps {

    @And("^I( am not able to|)? go to \"([^\"]*)\" hhrr submenu$")
    public void I_go_to_hhrr_submenu(String hasOrNot, String submenu) throws Throwable {
        boolean itIsDone;
        boolean shouldGo = false;
        MainMenu mainMenu = new MainMenu();
        Submenu accountingSubmenu = new Submenu();
        mainMenu.goToMenu("hhrr");
        if (hasOrNot.isEmpty()) {
            shouldGo = true;
        }
        try {
            accountingSubmenu.goToSubmenu(submenu, shouldGo);
            itIsDone = true;
        } catch(NoSuchElementException nsee) {
            itIsDone = false;
        }
        if (!hasOrNot.isEmpty()) {
            Assert.assertFalse(itIsDone);
        }
    }
}