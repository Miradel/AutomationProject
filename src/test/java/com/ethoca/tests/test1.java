package com.ethoca.tests;

import com.ethoca.pages.FramePage;
import com.ethoca.pages.HomePage;
import com.ethoca.pages.SummaryPage;
import com.ethoca.pages.SummerDressPage;
import com.ethoca.utilities.BrowserUtil;
import com.ethoca.utilities.ConfigurationReader;
import com.ethoca.utilities.Driver;
import com.ethoca.utilities.TestBase;
import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class test1 extends TestBase {

    @Test
    public void test11() throws InterruptedException {

        // STEP 1: Go to http://automationpractice.com
        driver.get(ConfigurationReader.getProperty("url"));
      //  Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        // STEP 2: Go to 'Women' and select 'Summer Dresses'
        BrowserUtil.hover( pages.homePage().women);
       // Thread.sleep(5000);
      //  BrowserUtil.waitForVisibility(homePage.summerDressButtom,20);
       pages.homePage().summerDressButtom.click();

        // STEP 3: From the available products Grid View, mouse over 'Printed Chiffon Dress' and click 'Quick view'

        BrowserUtil.hover(pages.summerDressPage().Printed_Chiffon_Dress);
       // BrowserUtil.waitForVisibility(summerDressPage.quickView,20);
        pages.summerDressPage().quickView.click();

        //STEP 4: Select 'M' size and click on 'Add to Cart'

        Driver.getDriver().switchTo().frame(pages.framePage().frame);

        Select select = new Select(pages.framePage().dropDown);
        select.selectByValue("2");
       pages.framePage().add_to_Card.click();

        //STEP 5: Click on 'Continue shopping'
        Thread.sleep(2000);
       // BrowserUtil.waitForClickablility(pages.framePage().conShopping,20);
        pages.framePage().conShopping.click();

        //STEP 6: Go to 'Cart' and click 'Check Out'
        Driver.getDriver().switchTo().parentFrame();
       //action.moveToElement(homePage.Cart).perform();
       BrowserUtil.hover(pages.homePage().Cart);
       pages.homePage().checkOut.click();

        //STEP 7: Click 'Proceed to checkout'
      //  Thread.sleep(3000);

        pages.summaryPage().checkOut.click();

        //STEP 8: Enter an email and click on 'Create an Account'
        pages.summaryPage().emailInput.sendKeys(pages.summaryPage().randomEmail());
        Thread.sleep(2000);
        pages.summaryPage().create.click();

        //STEP 9: Fill in mandatory fields and click 'Register'
        Thread.sleep(2000);
        pages.summaryPage().fillMandetoryInfo();

        //STEP 10: Click 'Proceed to checkout' on Address tab
        pages.summaryPage().proceedToCheckOut.click();

        //STEP 11: Agree to 'Terms of service' and Click 'Proceed to checkout' on Shipping tab
        pages.summaryPage().checkBox.click();
        pages.summaryPage().proceedToCheckOut2.click();

        //STEP 12: Confirm the correct order on 'Payment' tab

               // Verify the product name
        Assert.assertEquals(pages.summaryPage().product.getText(),"Printed Chiffon Dress");
               // Verify the product size
        Assert.assertTrue(pages.summaryPage().productSize.getText().contains("M"));
    }
}
