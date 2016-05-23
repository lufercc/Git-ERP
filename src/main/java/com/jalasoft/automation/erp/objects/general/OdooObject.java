package com.jalasoft.automation.erp.objects.general;
import org.apache.log4j.Logger;

/**
 * Created by Henry Benito on 3/11/2016.
 */
public abstract class OdooObject {
    private Logger log;
    public OdooObject() {
    }

    public void logWarning(String field, String fieldValue) {
        log = Logger.getLogger(getClass());
        log.warn("This expected field: '" + field + "=" + fieldValue + "' was not found in the UI");
    }

    public abstract boolean matchWith(boolean shouldMatch, OdooObject uiData);
}
