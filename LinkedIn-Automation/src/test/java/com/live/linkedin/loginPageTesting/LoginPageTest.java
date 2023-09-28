package com.live.linkedin.loginPageTesting;

import com.live.linkedin.base.TestBase;
import com.live.linkedin.loginPage.LoginPage;
import com.live.linkedin.utils.utilityMethods;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    //LoginPage class reference variable
    LoginPage loginPage;

    //constructor of this class
    public LoginPageTest(){
        //Parent class constructor for initializing driver and other properties.
        super();
    }

    //To call it before executing all the tests
    @BeforeClass
    public void setUp(){
        //Parent class method for setting drivers properties launching url etc.
        initialization();
        //Obj of Login Page contains its locators and functions
        loginPage = new LoginPage();
    }

    @Test(description = "This test will verify Current Page Title")
    public void verifyPageTitle(){

        String title= driver.getTitle();
        Assert.assertEquals(title,"LinkedIn Login, Sign in | LinkedIn","Title does not match !");
    }

    @Test
    public void verifyURL(){

        String url = driver.getCurrentUrl();
        Assert.assertEquals(url,prop.getProperty("url"),"URL does not match !");
    }

    @Test
    public void verifyLogo(){

        boolean status = loginPage.getLogo();
        Assert.assertTrue(status,"Logo is not there.");
    }

    @Test
    public void verifyPageHeading(){

        String heading = loginPage.getPageHeading();
        Assert.assertEquals(heading,"Sign in","Page Heading is not matching");
    }

    @Test
    public void verifySignIn(){
        utilityMethods.implicitWait();
        loginPage.clickOnSignup(prop.getProperty("username"), prop.getProperty("password"));

        utilityMethods.threadSleep();
    }

    @Test(enabled = false)
    public void verifyForgotpwdLinkWorking(){
        //yet to code
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
