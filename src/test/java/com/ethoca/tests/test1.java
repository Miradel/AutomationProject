package com.ethoca.tests;

import com.ethoca.utilities.BrowserUtil;
import com.ethoca.utilities.ConfigurationReader;
import com.ethoca.utilities.Driver;
import com.ethoca.utilities.TestBase;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 extends TestBase {
    @Test
    public void test11() throws InterruptedException {
        // Create the new test case and give the name :Whole procees of buy product
        extentLogger = report.createTest("Whole procees of buy product");

        // Use logger to log the steps
        extentLogger.info("STEP 1: Go to http://automationpractice.com");
        driver.get(ConfigurationReader.getProperty("url"));

        extentLogger.info("STEP 2: Go to 'Women' and select 'Summer Dresses'");
        BrowserUtil.hover( pages.homePage().women);
        BrowserUtil.waitForVisibility(pages.homePage().summerDressButtom,20);
        pages.homePage().summerDressButtom.click();

        extentLogger.info("STEP 3: From the available products Grid View, mouse over 'Printed Chiffon Dress' and click 'Quick view'\n");
        BrowserUtil.hover(pages.summerDressPage().Printed_Chiffon_Dress);
       //BrowserUtil.waitForVisibility(summerDressPage.quickView,20);
        pages.summerDressPage().quickView.click();

        extentLogger.info("STEP 4: Select 'M' size and click on 'Add to Cart'");
        driver.switchTo().frame(pages.framePage().frame);

        Select select = new Select(pages.framePage().dropDown);
        select.selectByValue("2");
        pages.framePage().add_to_Card.click();
        Thread.sleep(2000);

        // BrowserUtil.waitForClickablility(pages.framePage().conShopping,3000);
        extentLogger.info("STEP 5: Click on 'Continue shopping'");
        pages.framePage().conShopping.click();
        driver.switchTo().parentFrame();

        extentLogger.info("STEP 6: Go to 'Cart' and click 'Check Out'");
        BrowserUtil.hover(pages.homePage().Cart);
        pages.homePage().checkOut.click();

        extentLogger.info("STEP 7: Click 'Proceed to checkout'");
        pages.summaryPage().checkOut.click();

        extentLogger.info("STEP 8: Enter an email and click on 'Create an Account'");
        pages.summaryPage().emailInput.sendKeys(pages.summaryPage().randomEmail());
        //Thread.sleep(2000);
        pages.summaryPage().create.click();

        extentLogger.info("STEP 9: Fill in mandatory fields and click 'Register'");
       // Thread.sleep(2000);
        pages.summaryPage().fillMandetoryInfo();

        extentLogger.info("STEP 10: Click 'Proceed to checkout' on Address tab");
        pages.summaryPage().proceedToCheckOut.click();

        extentLogger.info("STEP 11: Agree to 'Terms of service' and Click 'Proceed to checkout' on Shipping tab");
        pages.summaryPage().checkBox.click();
        pages.summaryPage().proceedToCheckOut2.click();

        extentLogger.info("STEP 12: Confirm the correct order on 'Payment' tab");
        Assert.assertEquals(pages.summaryPage().product.getText(),"Printed Chiffon Dress");// verify product name
        Assert.assertTrue(pages.summaryPage().productSize.getText().contains("M"));//verify product size
        extentLogger.pass("Whole process of buy a product");
    }
}
