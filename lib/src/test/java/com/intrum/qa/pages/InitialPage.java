package com.intrum.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")

public class InitialPage {

    @FindBy(xpath = "//button[contains(.,'Accept All Cookies')]")
    WebElement acceptCookies;

    @FindBy(linkText = "Forma")
    WebElement contactForm;

    public InitialPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickContactForm() throws InterruptedException {
        contactForm.click();
    }
    public void clickAcceptCookies() throws InterruptedException {
        acceptCookies.click();
    }

    public void waitForButton(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("onetrust-accept-btn-handler")));
    }
}
