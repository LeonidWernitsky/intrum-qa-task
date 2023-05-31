package com.intrum.qa.stepdefinitions;

import io.cucumber.java.en.Given;
import com.intrum.qa.pages.InitialPage;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class InitialSteps {

    @Autowired
    private InitialPage initialPage;

    @Given("^I open Initial Page$")
    public void iOpenInitialPage() {
    }

    @When("^I click on formButton$")
    public void iClickOnFormButton() throws InterruptedException {
        this.initialPage.clickContactForm();
    }

    @When("I click on acceptCookies$")
    public void iClickOnAcceptCookies() throws InterruptedException {
        Thread.sleep(3000);
        this.initialPage.clickAcceptCookies();
        Thread.sleep(5000);
    }
}
