package com.intrum.qa.config;

import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class WebDriverManager {

    private static final String DOCKER_HOST = "http://127.0.0.1";
    private static final String SELENIUM_PORT = "4444";
    private static final String CHROME = "chrome";
    private static final String CONTEXT = "local";

    @Autowired
    private DemoSpringSeleniumProperties properties;

    @Bean
    /*
     * Need to add @Scope annotation to the factory method
     * so that we guarantee each scenario will create
     * its own instance of the WebDriver
     */
    @Scope("cucumber-glue")
    /*
     * Bean factory method annotated with @Bean so that
     * Spring will invoke this method and create a new bean
     *
     * Spring uses factory methods to create actual objects at runtime
     * This method is responsible to instantiate the WebDriver
     */
    public WebDriver webDriverFactory() throws IOException {
        if (properties.getContext().equalsIgnoreCase(CONTEXT)) {
            // Use README.md to get more details in "Additional configuration need" article
            System.setProperty("webdriver.gecko.driver", "C:\\Webdriver\\geckodriver.exe");
            return new FirefoxDriver();
        }
        return getRemoteWebDriver(properties.getBrowser());
    }

    private WebDriver getRemoteWebDriver(String browser) throws IOException {
        String remote = String.format("%s:%s/wd/hub", DOCKER_HOST, SELENIUM_PORT);
        if (browser.equalsIgnoreCase(CHROME)) {
            return new RemoteWebDriver(new URL(remote), new ChromeOptions());
        }
        return new RemoteWebDriver(new URL(remote), new FirefoxOptions());
    }
}
