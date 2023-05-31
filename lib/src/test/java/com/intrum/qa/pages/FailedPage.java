package com.intrum.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")

public class FailedPage {

    @FindBy(xpath = "(//span[contains(.,'Lūdzu, aizpildiet lauku')])[14]")
    WebElement submitFailLastNotification;

    @FindBy(xpath = "(//span[contains(.,'Lūdzu, aizpildiet lauku')])[2]")
    WebElement submitFailOneMessage;

    public FailedPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getSubmitFailLastNotification() {
        return this.submitFailLastNotification.getText().split("\n")[0];
    }

    public String getSubmitFailOneMessage() {
        return this.submitFailOneMessage.getText().split("\n")[0];
    }
}
