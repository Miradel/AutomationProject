package com.ethoca.utilities;

import com.ethoca.pages.FramePage;
import com.ethoca.pages.HomePage;
import com.ethoca.pages.SummaryPage;
import com.ethoca.pages.SummerDressPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase  {

    @BeforeTest
    public void setUp(){

        Driver.getDriver().manage().window().fullscreen();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @AfterClass
    public void tearDown(){
        Driver.getDriver().close();
    }
}
