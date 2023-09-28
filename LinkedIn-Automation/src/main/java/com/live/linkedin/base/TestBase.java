package com.live.linkedin.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {


    public static WebDriver driver;
    public static Properties prop;

    Actions action;
    public TestBase(){
        try {
            prop=new Properties();

            String userpath = System.getProperty("user.dir");
            FileInputStream ip=new FileInputStream(userpath+"/src/main/java/com/live/linkedin/config/config.properties");
            prop.load(ip);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void initialization(){
        String browser = prop.getProperty("browser");
        if (browser.equals("chrome")){
            // driver=new ChromeDriver();

            //for headlessness
            ChromeOptions options=new ChromeOptions();
            options.addArguments("headless");
            driver=new ChromeDriver(options);

        } else if (browser.equals("ff")) {
            driver=new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));
    }
}
