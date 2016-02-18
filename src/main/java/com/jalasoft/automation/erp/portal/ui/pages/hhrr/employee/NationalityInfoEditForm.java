package com.jalasoft.automation.erp.portal.ui.pages.hhrr.employee;

import com.jalasoft.automation.erp.portal.ui.components.TableOpenERP;
import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.Nationality;
import com.jalasoft.automation.erp.portal.ui.pages.general.PopupSearch;
import com.jalasoft.automation.erp.portal.ui.pages.general.Search;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Henry Benito on 10/20/2015.
 */
public class NationalityInfoEditForm extends TableOpenERP {

    @FindBy(xpath = "(//table[contains(@class,'oe_list_content')])[1]")
    protected WebElement table;
    protected int tableSize = 100000;


    public NationalityInfoEditForm() {
        super.table = this.table;

    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.table);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.table);
    }

    public void addData(List<Nationality> inputData) {
        WebElement addElement = table.findElement(By.xpath(".//button[@class='oe_button oe_list_add']"));

        for (int i = 0; i < inputData.size(); i++) {
            addElement.click();
            PopupSearch openERPSearch = new PopupSearch();
            openERPSearch.advancedSearch("Nombre del país",inputData.get(i).name);

            WebElement countryCell = this.webDriver.findElement(By.xpath("//div[contains(@class,'oe_popup_list')]//td[text()='" + inputData.get(i).name + "']"));
            countryCell.click();
        }
    }

//    public void removeData(List<Nationality> expectedData) {
//        List<HashMap> dataFromUITable;
//        Nationality currentNationality;
//        HashMap<String,String> currentRow;
//
//        for(int i = 0; i < expectedData.size(); i++) {
//            dataFromUITable = this.getData();
//            currentNationality = expectedData.get(i);
//
//            for(int uit = 0; uit < dataFromUITable.size(); uit++) {
//                currentRow = dataFromUITable.get(uit);
//                if (currentNationality.name.equals(currentRow.get("Nombre del país")) &&
//                        currentNationality.code.equals(currentRow.get("Código de país"))) {
//                    this.deleteElement(uit);
//                    break;
//                }
//            }
//        }
//    }

}
