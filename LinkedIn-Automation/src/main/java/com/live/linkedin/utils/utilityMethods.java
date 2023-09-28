package com.live.linkedin.utils;

import com.live.linkedin.base.TestBase;

import java.util.concurrent.TimeUnit;

public class utilityMethods extends TestBase {
    //NOTE : This class will contain all the common methods that can be used many times across the project.



    //For taking screenshot of a particular section of the page.
    public static void segmentScreenshot(){
        //yet to code
    }

    //For taking screenshot of a whole page.
    public static void screenshot(){
        //yet to code
    }

    //Thread sleep
    public static void threadSleep(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void implicitWait(){
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }
}
