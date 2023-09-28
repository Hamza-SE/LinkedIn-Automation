package com.live.linkedin.loginPage;

import com.live.linkedin.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(xpath="//li-icon[@role='banner']")
    WebElement logo;


    @FindBy(tagName = "h1")
    WebElement heading;

    @FindBy(xpath = "//input[@id='username']")
    WebElement usernameField;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//a[text()='Forgot password?']")
    WebElement frgotLink;

    @FindBy(id = "password-visibility-toggle")
    WebElement showPwdToggle;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement signinBtn;

    public LoginPage()
    {
        PageFactory.initElements(driver,this);

    }

    public void clickOnForgotpwdLink(){
    }

    public boolean getLogo(){
       return logo.isDisplayed();
    }

    public String getPageHeading(){
        return heading.getText();
    }

    public void clickOnGoogleLink(){

    }
    public void clickOnAppleLink(){

    }

    public void clickOnSignup(String user, String pass){

        usernameField.sendKeys(user);
        passwordField.sendKeys(pass);
        signinBtn.click();
    }

}
