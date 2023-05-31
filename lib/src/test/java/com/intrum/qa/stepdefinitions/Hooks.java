package com.intrum.qa.stepdefinitions;

import com.intrum.qa.config.DemoSpringSeleniumProperties;
import com.intrum.qa.SpringContextConfiguration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.spring.CucumberContextConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = {SpringContextConfiguration.class})
@Slf4j

public class Hooks {

    /*
     * @Autowired allows Spring to resolve and inject beans
     *
     * Wherever we are instantiating a page or the WebDriver,
     * we will now annotate the attribute with @Autowired
     * so that Spring injects the instance automatically
     */
    @Autowired
    private WebDriver driver;

    @Autowired private DemoSpringSeleniumProperties properties;

    @Before
    public void openBrowser(Scenario scenario) {
        driver.get(properties.getHost());
        log.info("[STARTED] Scenario: " + scenario.getName());
    }

    @After
    public void closeBrowser(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
        driver.quit();
        log.info("[ENDED] Scenario: " + scenario.getName());
    }
}
