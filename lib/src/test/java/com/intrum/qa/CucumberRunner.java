package com.intrum.qa;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        glue = "com/intrum/qa/stepdefinitions",
        features = "lib/src/test/resources/features",
        plugin = {
                "pretty",
                "html:build/test-results/html-report.html",
                "json:build/test-results/json-report.json"
        }
        )
public class CucumberRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = true)

        public Object[][] scenarios() {
                return super.scenarios();
        }
}
