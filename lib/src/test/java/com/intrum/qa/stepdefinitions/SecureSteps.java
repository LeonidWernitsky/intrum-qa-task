package com.intrum.qa.stepdefinitions;

import io.cucumber.java.en.Then;
import com.intrum.qa.pages.SecurePage;
import org.springframework.beans.factory.annotation.Autowired;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class SecureSteps {

    @Autowired
    private SecurePage securePage;

    @Then("^I see \"(.*)\" text$")
    public void iSeeText(String text) {
        assertThat(this.securePage.getErrorMessage(), is(text));
    }

}
