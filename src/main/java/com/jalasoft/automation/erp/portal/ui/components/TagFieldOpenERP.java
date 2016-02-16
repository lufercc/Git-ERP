package com.jalasoft.automation.erp.portal.ui.components;

import com.jalasoft.automation.erp.portal.ui.custom.hhrr.employee.Tag;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henry Benito on 1/12/2016.
 */
public class TagFieldOpenERP extends PortalUIElement {
    protected WebElement field;
    protected int columnsSize;
    private Logger log = Logger.getLogger(getClass());

    public TagFieldOpenERP() { }


    public List<String> getTags() {
        List<String> result = new ArrayList<>();
        List<WebElement> tagList = field.findElements(By.xpath("./span"));
        this.columnsSize = tagList.size();
        for (WebElement tag : tagList) {
            String value = tag.getAttribute("innerHTML");
            value = value.replaceAll("\n","");
            value = value.trim();
            result.add(value);
        }
        return result;
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.field);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.field);
    }

    public boolean hasSameContent(List<Tag> expectedTagData) {
        List<String> dataFromField = this.getTags();
        if(expectedTagData.size()!= dataFromField.size()) {
            return false;
        }
        Tag currentTag;
        String currentRow;

        while(dataFromField.size() > 0) {
            int tableSize = dataFromField.size();
            for(int indexTagList = 0; indexTagList < expectedTagData.size(); indexTagList++) {
                currentTag = expectedTagData.get(indexTagList);
                for(int indexList = 0; indexList < tableSize; indexList++) {
                    currentRow = dataFromField.get(indexList);
                    if (currentTag.name.equals(currentRow)) {
                        dataFromField.remove(currentRow);
                        break;
                    }
                    if(indexList == (tableSize - 1)) {
                        log.warn("This expected value: '" + currentTag.name + "' was not found in the UI");
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
