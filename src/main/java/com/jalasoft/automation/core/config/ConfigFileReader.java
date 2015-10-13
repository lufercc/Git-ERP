package com.jalasoft.automation.core.config;

import java.util.Map;

/**
 * Created by Mauricio on 4/6/2015.
 */
public interface ConfigFileReader {

    Map<String, String> getConfigSection(String sectionName);

    String getConfigValue(String sectionName, String key);

    Map<String, String> getConfigSubSection(String sectionName, String subSectionName);

    boolean isSectionDefined(Object sectionObject, String sectionName);

    boolean isSectionDefined(String sectionName);

    boolean isSubSectionDefined(String parentSection, String subSection);
}
