package com.jalasoft.automation.erp.portal.ui.pages.general;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Henry Benito on 10/27/2015.
 */
public class Search extends PortalUIElement{
    @FindBy(css = "div.oe_searchview_clear")
    protected WebElement clearFilter;

    @FindBy(css = "div.oe_searchview_unfold_drawer")
    protected WebElement searchUnfold;

    @FindBy(css = "div.oe_searchview_advanced > h4")
    protected WebElement openAdvancedSearch;

    @FindBy(css = "div.oe_searchview_advanced")
    protected WebElement advancedSearchContainer;

    @FindBy(css = "select.searchview_extended_prop_field")
    protected WebElement attributeSelect;

    @FindBy(css = "input.field_char")
    protected WebElement valueInput;

    @FindBy(css = "button.oe_apply")
    protected WebElement applyButton;

    public Search() {
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.clearFilter);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.searchUnfold);
    }

    public void advancedSearch(String attribute, String value)
    {
        clearFilter.click();
        searchUnfold.click();
        if(!advancedSearchContainer.getAttribute("class").contains("oe_opened"))
        {
            openAdvancedSearch.click();
        }
        Select attSelect = new Select(attributeSelect);
        attSelect.selectByVisibleText(attribute);
        valueInput.sendKeys(value);
        applyButton.click();
    }
}
