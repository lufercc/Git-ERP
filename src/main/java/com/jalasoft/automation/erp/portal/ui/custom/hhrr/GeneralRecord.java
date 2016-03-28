package com.jalasoft.automation.erp.portal.ui.custom.hhrr;
import org.apache.log4j.Logger;

/**
 * Created by Henry Benito on 3/11/2016.
 */
public class GeneralRecord {
    private Logger log;
    public GeneralRecord() {
    }

    public void logWarning(String field, String fieldValue) {
        log = Logger.getLogger(getClass());
        log.warn("This expected field: '" + field + "=" + fieldValue + "' was not found in the UI");
    }
}
