package com.jalasoft.automation.core.test.setup;


import com.jalasoft.automation.core.test.annotation.BeforeCucumberFeature;
import com.jalasoft.automation.core.test.annotation.AfterCucumberFeature;
import cucumber.api.Scenario;
import org.apache.log4j.Logger;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Mauricio Cadima on 7/27/2015.
 */
public class TestSetupManager {

    private static TestSetupManager testSetupManager;
    private Logger log = Logger.getLogger(getClass());
    private Map<String, Method> beforeFeatureMethodsMap;
    private Map<String, Method> afterFeatureMethodsMap;
    private Map<String, Object> testSetupObjectsMap;
    private String featureInExecution;

    public TestSetupManager() {
        this.beforeFeatureMethodsMap = new HashMap<>();
        this.afterFeatureMethodsMap = new HashMap<>();
        this.testSetupObjectsMap = new HashMap<>();
        this.featureInExecution = "";
    }

    public static TestSetupManager getInstance() {
        if (testSetupManager == null) {
            testSetupManager = new TestSetupManager();
            testSetupManager.init();
        }
        return testSetupManager;
    }

    private void init() {
        try {
            ConfigurationBuilder builder = new ConfigurationBuilder();
            builder.addUrls(ClasspathHelper.forPackage("hooks.setup"));
            builder.setScanners(new SubTypesScanner());
            builder.setScanners(new MethodAnnotationsScanner());
            Reflections reflections = new Reflections(builder);
            Set<Method> beforeMethods = reflections.getMethodsAnnotatedWith(BeforeCucumberFeature.class);
            Set<Method> afterMethods = reflections.getMethodsAnnotatedWith(AfterCucumberFeature.class);
            this.registerMethods(beforeMethods, afterMethods);
        } catch (Exception ex) {
            log.error("Exception raised processing before and after feature", ex);
        }
    }

    private void registerMethods(Set<Method> beforeMethods, Set<Method> afterMethods) throws Exception {
        for (Method method : beforeMethods) {
            BeforeCucumberFeature beforeFeature = method.getAnnotation(BeforeCucumberFeature.class);
            this.beforeFeatureMethodsMap.put(beforeFeature.FeatureName(), method);
            this.registerTestSetupObject(method);
        }
        for (Method method : afterMethods) {
            AfterCucumberFeature afterFeature = method.getAnnotation(AfterCucumberFeature.class);
            this.afterFeatureMethodsMap.put(afterFeature.FeatureName(), method);
            this.registerTestSetupObject(method);
        }
    }

    private void registerTestSetupObject(Method method) throws Exception {
        String className = method.getDeclaringClass().getCanonicalName();
        if (!this.testSetupObjectsMap.containsKey(className)) {
            this.testSetupObjectsMap.put(className, method.getDeclaringClass().newInstance());
        }
    }

    private String getFeatureNameFromScenario(Scenario scenario) {
        String scenarioId = scenario.getId();
        String featureName = scenarioId.substring(0, scenarioId.indexOf(';'));
        return featureName;
    }

    private void checkBeforeMethods(String featureName) throws Exception {
        if (this.beforeFeatureMethodsMap.containsKey(featureName)) {
            Method beforeMethod = this.beforeFeatureMethodsMap.get(featureName);
            beforeMethod.invoke(beforeMethod.getDeclaringClass().newInstance());
        }
    }

    private void checkAfterMethods() throws Exception {
        if (!this.featureInExecution.isEmpty() && this.afterFeatureMethodsMap.containsKey(this.featureInExecution)) {
            Method afterMethod = this.afterFeatureMethodsMap.get(this.featureInExecution);
            afterMethod.invoke(afterMethod.getDeclaringClass().newInstance());
        }
    }

    public void processBeforeCucumberSenario(Scenario scenario) {
        String featureName = getFeatureNameFromScenario(scenario);
        if (!this.featureInExecution.equals(featureName)) {
            try {
                checkAfterMethods();
                checkBeforeMethods(featureName);
            } catch (Exception ex) {
                log.error("exception processing scenario", ex);
            } finally {
                this.featureInExecution = featureName;
            }
        }
    }

    public void finalizeExecution() {
        try {
            this.checkAfterMethods();
        } catch (Exception ex) {
            log.error("exception processing scenario", ex);
        } finally {
            this.featureInExecution = "";
        }
    }
}
