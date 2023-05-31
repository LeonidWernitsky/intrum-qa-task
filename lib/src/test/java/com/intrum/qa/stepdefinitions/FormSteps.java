package com.intrum.qa.stepdefinitions;

import io.cucumber.java.en.When;
import com.intrum.qa.pages.FormPage;
import org.springframework.beans.factory.annotation.Autowired;

public class FormSteps {
    @Autowired
    private FormPage formPage;

    @When("^I fill the nameFamilyName with \"(.*)\"$")
    public void iFillTheNameFamilyNameInputWith(String nameFamilyName) {
        this.formPage.typeNameFamilyName(nameFamilyName);
    }

    @When("^I fill the personalCode with \"(.*)\"$")
    public void iFillThePasswordInputWith(String personalCode) {
        this.formPage.typePersonalCode(personalCode);
    }

    @When("^I fill the debtCaseNumber with \"(.*)\"$")
    public void iFillTheDebtCaseNumberWith(String debtCaseNumber) {
        this.formPage.typeDebtCaseNumber(debtCaseNumber);
    }

    @When("^I fill the phoneNumber with \"(.*)\"$")
    public void iFillThePhoneNumberWith(String phoneNumber) {
        this.formPage.typePhoneNumber(phoneNumber);
    }

    @When("^I fill the emailAddress with \"(.*)\"$")
    public void iFillTheEmailAddressWith(String emailAddress) {
        this.formPage.typeEmailAddress(emailAddress);
    }

    @When("^I fill the postAddress with \"(.*)\"$")
    public void iFillThePostAddressWith(String postAddress) {
        this.formPage.typePostAddress(postAddress);
    }

    @When("^I fill the comment with \"(.*)\"$")
    public void iFillTheCommentWith(String comment) {
        this.formPage.typeComment(comment);
    }

    @When("^I click on submitButton$")
    public void iClickOnSubmitButton() throws InterruptedException {
        Thread.sleep(2000);
        this.formPage.clickSubmitButton();
        Thread.sleep(5000);
    }

    @When("I click on communicationOptionBlank")
    public void iClickOnCommunicationOptionBlank() {
        this.formPage.selectCommunicationOptionBlank();
    }

    @When("I click on communicationOptionPost")
    public void iClickOnCommunicationOptionPost() {
        this.formPage.selectCommunicationOptionPost();
    }
}
