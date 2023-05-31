package com.intrum.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")

public class FormPage {

    @FindBy(xpath = "//div/input")
    WebElement nameFamilyNameInput;

    @FindBy(xpath = "//div[2]/div/input")
    WebElement personalCodeInput;

    @FindBy(xpath = "//div[3]/div/input")
    WebElement debtCaseNumberInput;

    @FindBy(xpath = "//div[4]/div/input")
    WebElement phoneNumberInput;

    @FindBy(xpath = "//div[5]/div/input")
    WebElement emailAddressInput;

    @FindBy(xpath = "//div[6]/div/input")
    WebElement postAddressInput;

    @FindBy(xpath = "//textarea")
    WebElement commentInput;

    @FindBy(xpath = "//option[@value='']")
    WebElement communicationOptionBlank;

    @FindBy(xpath = "//option[@value='Pasts']")
    WebElement communicationOptionPost;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submitButton;

    public FormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void typeNameFamilyName(String nameFamilyName) {
        this.nameFamilyNameInput.sendKeys(nameFamilyName);
    }

    public void typePersonalCode(String personalCodeInput) {
        this.personalCodeInput.sendKeys(personalCodeInput);
    }

    public void typeDebtCaseNumber(String debtCaseNumber) {
        this.debtCaseNumberInput.sendKeys(debtCaseNumber);
    }

    public void typePhoneNumber(String phoneNumber) {
        this.phoneNumberInput.sendKeys(phoneNumber);
    }

    public void typeEmailAddress(String emailAddress) {
        this.emailAddressInput.sendKeys(emailAddress);
    }

    public void typePostAddress(String postAddress) {
        this.postAddressInput.sendKeys(postAddress);
    }

    public void typeComment(String comment) {
        this.commentInput.sendKeys(comment);
    }

    public void selectCommunicationOptionBlank() {
        communicationOptionBlank.click();
    }

    public void selectCommunicationOptionPost() {
        communicationOptionPost.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
