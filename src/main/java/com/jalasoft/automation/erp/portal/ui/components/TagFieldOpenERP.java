package com.jalasoft.automation.erp.portal.ui.components;

import com.jalasoft.automation.erp.objects.hhrr.employee.Tag;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henry Benito on 1/12/2016.
 */
public class TagFieldOpenERP extends PortalUIElement {
    protected WebElement inputTag;
    protected List <WebElement> tags;
    protected int columnsSize;
    private Logger log = Logger.getLogger(getClass());
    public boolean allTagsWereAdded;
    public TagFieldOpenERP() { }


    public List<String> getTags() {
        List<String> result = new ArrayList<>();
        this.columnsSize = tags.size();
        for (WebElement tag : tags) {
            String value = tag.getAttribute("innerText");
            value = value.replaceAll("\n","");
            value = value.trim();
            result.add(value);
        }
        return result;
    }

    public void addTags(List<Tag> tagList) {
        try {
            allTagsWereAdded = false;
            if (webDriverTools.isElementDisplayed(inputTag)) {
                for (Tag tag : tagList) {
                    webDriverTools.clearAndSendKeys(inputTag, tag.name);
                    this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
                    WebElement suggestedValue = webDriver.findElement(By.xpath("//ul[contains(@class,'ui-autocomplete') and contains(@style,'display: block')]//a[contains(text(),'" + tag.name + "')]"));
                    suggestedValue.click();
                }
                allTagsWereAdded = true;
            } else {
                logNotAddedRecords();
            }
        } catch (NoSuchElementException nsee) {
            logNotAddedRecords();
        }
    }

    public void deleteTags(List<Tag> tagList) {
        for (Tag inputTag : tagList) {
            for (WebElement tag : tags) {
                String value = tag.getAttribute("innerText");
                value = value.replaceAll("\n","");
                value = value.trim();
                if(inputTag.name.equals(value)) {
                    WebElement removeTag = tag.findElement(By.xpath("./span[contains(@class,'o_delete')]"));
                    removeTag.click();
                }
            }
        }
    }

    public void logNotAddedRecords() {
        log = Logger.getLogger(getClass());
        log.warn("Records were not added");
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.inputTag);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.inputTag);
    }

    public boolean hasSameContent(boolean shouldBeAble, List<Tag> expectedData) {
        List<String> dataFromField  = this.getTags();
        String currentRow;
        int tableSize;

        if((expectedData.size()!= dataFromField.size()) && shouldBeAble) {
            return false;
        }

        if(dataFromField.isEmpty() && !shouldBeAble) {
            return true;
        }

        for(Tag  currentTag : expectedData) {
            tableSize =  dataFromField.size();
            for(int indexList = 0; indexList < tableSize; indexList++) {
                currentRow = dataFromField.get(indexList);
                if (shouldBeAble) {
                    if (currentTag.name.equals(currentRow)) {
                        dataFromField.remove(currentRow);
                        break;
                    }
                    if (indexList == (tableSize - 1)) {
                        return false;
                    }
                } else {
                    if (currentTag.name.equals(currentRow)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
