package com.intrum.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")

public class SecurePage {

    @FindBy(id = "e9a9505d-196d-4bac-8d8f-f8a3f406934d-error")
    WebElement errorMessage;

    public SecurePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getErrorMessage() {
        return this.errorMessage.getText().split("\n")[0];
    }
}
