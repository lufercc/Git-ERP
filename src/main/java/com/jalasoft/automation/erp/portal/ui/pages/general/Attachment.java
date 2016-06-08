package com.jalasoft.automation.erp.portal.ui.pages.general;

import com.jalasoft.automation.erp.portal.ui.components.PortalUIElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Henry Benito on 10/27/2015.
 */
public class Attachment extends PortalUIElement{
    @FindBy(xpath ="//div[@class='oe_fileupload']")
    protected WebElement container;

    @FindBy(xpath ="//div[@class='oe_fileupload']//input[@name='ufile']")
    protected WebElement inputFilePath;

    public Attachment() {}

    @Override
    public boolean isLoaded() {
        return super.webDriverTools.isElementDisplayed(this.container);
    }

    @Override
    public void waitForLoading() {
        super.webDriverTools.waitUntilElementPresentAndVisible(this.container);
    }

    public void attachFile(String filepath) throws InterruptedException {
        webDriverTools.clearAndSendKeys(inputFilePath, filepath);
        webDriverTools.waitUntilElementPresentAndVisible(By.linkText(getFileName(filepath)));
    }

    private String getFileName(String inputFilePath) {
        String[] stringArray = inputFilePath.split("\\\\");
        return stringArray[stringArray.length-1];
    }

    public List<WebElement> getFilesAttached() {
        return container.findElements(By.xpath(".//a"));
    }

    public List<String> getFilesAsStringList() {
        List<String> result = new ArrayList();
        List<WebElement> files = getFilesAttached();
        for (WebElement file: files) {
            result.add(file.getAttribute("innerHTML").replace("\n","").trim());
        }
        return result;
    }

    public boolean isInTheList(String fileName) {
        List<String> files = getFilesAsStringList();
        for (String file: files) {
            if (fileName.equalsIgnoreCase(file)) {
                return true;
            }
        }
        return false;
    }

    public void deleteFileAttached(String fileName) {
        List<WebElement> files = getFilesAttached();
        for (WebElement file: files) {
            if (fileName.equalsIgnoreCase(file.getAttribute("innerHTML").replace("\n","").trim())) {
                file.findElement(By.xpath("./following-sibling::span[@title='Delete this file']")).click();
            }
        }
    }
}
