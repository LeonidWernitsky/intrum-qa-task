package com.intrum.qa.stepdefinitions;

import io.cucumber.java.en.Then;
import com.intrum.qa.pages.FailedPage;
import org.springframework.beans.factory.annotation.Autowired;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
public class FailedSteps {
    @Autowired
    private FailedPage failedPage;

    @Then("^I see \"(.*)\" notification$")
    public void iSeeNotification(String notification) {
        assertThat(this.failedPage.getSubmitFailLastNotification(), is(notification));
    }

    @Then("^I see \"(.*)\" message$")
    public void iSeeMessage(String message) {
        assertThat(this.failedPage.getSubmitFailOneMessage(), is(message));
    }
}
