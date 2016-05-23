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
    protected WebElement field;
    protected int columnsSize;
    private Logger log = Logger.getLogger(getClass());
    public boolean allTagsWereAdded;
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

    public void addTags(List<Tag> tagList) {
        try {
            allTagsWereAdded = false;
            WebElement tagTextField = field.findElement(By.xpath(".//textarea"));
            if (webDriverTools.isElementDisplayed(tagTextField)) {
                for (Tag tag : tagList) {
                    tagTextField.sendKeys(tag.name);
                    this.webDriverTools.waitUntilInvisibilityOpenERPProgress();
                    WebElement suggestedValue = field.findElement(By.xpath(".//span[contains(@class,'text-label')]/span[text()='" + tag.name + "']"));
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
        for (Tag tag : tagList) {
            WebElement suggestedValue = field.findElement(By.xpath(".//div[contains(@class,'text-tag')]//span[text()='" + tag.name + "']/following-sibling::a"));
            suggestedValue.click();
        }
    }

    public void logNotAddedRecords() {
        log = Logger.getLogger(getClass());
        log.warn("Records were not added");
    }

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.field);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.field);
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
