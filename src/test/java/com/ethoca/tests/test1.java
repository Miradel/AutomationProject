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

    HomePage homePage ;
    SummerDressPage summerDressPage;
    FramePage framePage;
    SummaryPage summaryPage;
    Actions action;

    @Test
    public void test11() throws InterruptedException {
        // STEP 1: Go to http://automationpractice.com
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        // STEP 2: Go to 'Women' and select 'Summer Dresses'
        homePage = new HomePage();

        action = new Actions(Driver.getDriver());
        action.moveToElement(homePage.women).perform();
        //Thread.sleep(3000);
        // BrowserUtil.waitForVisibility(homePage.summerDressButtom,10);
        homePage.summerDressButtom.click();

        // STEP 3: From the available products Grid View, mouse over 'Printed Chiffon Dress' and click 'Quick view'

        summerDressPage = new SummerDressPage();
        action.moveToElement(summerDressPage.Printed_Chiffon_Dress).perform();
       // BrowserUtil.waitForVisibility(summerDressPage.quickView,20);
        summerDressPage.quickView.click();

        //STEP 4: Select 'M' size and click on 'Add to Cart'

        framePage = new FramePage();

        Driver.getDriver().switchTo().frame(framePage.frame);

        Select select = new Select(framePage.dropDown);
        select.selectByValue("2");
       framePage.add_to_Card.click();

        //STEP 5: Click on 'Continue shopping'
        Thread.sleep(2000);
       // BrowserUtil.waitForClickablility(framePage.conShopping,40);
        framePage.conShopping.click();
        //STEP 6: Go to 'Cart' and click 'Check Out'
        Driver.getDriver().switchTo().parentFrame();

      //  Thread.sleep(3000);
       action.moveToElement(homePage.Cart).perform();
      // Thread.sleep(3000);
       homePage.checkOut.click();
        //STEP 7: Click 'Proceed to checkout'
      //  Thread.sleep(3000);
        summaryPage = new SummaryPage();
        summaryPage.checkOut.click();


        //STEP 8: Enter an email and click on 'Create an Account'
        summaryPage.emailInput.sendKeys(summaryPage.randomEmail());
        Thread.sleep(2000);
        summaryPage.create.click();

        //STEP 9: Fill in mandatory fields and click 'Register'
        Thread.sleep(2000);
        summaryPage.firstName.sendKeys(summaryPage.firstNameCreation());
        summaryPage.lastName.sendKeys(summaryPage.lastNameCreation());
        summaryPage.passWord.sendKeys(summaryPage.passWordCreation());
        summaryPage.address.sendKeys(summaryPage.addressCreation());
        summaryPage.city.sendKeys(summaryPage.cityCreation());
        select = new Select(summaryPage.stateList);
        select.selectByValue(summaryPage.randomeNumber());
        summaryPage.postalCode.sendKeys(summaryPage.postcodeCreation());
        summaryPage.phone.sendKeys(summaryPage.phoneNumberCreation());
        summaryPage.register.click();

        //STEP 10: Click 'Proceed to checkout' on Address tab
        summaryPage.proceedToCheckOut.click();
        //STEP 11: Agree to 'Terms of service' and Click 'Proceed to checkout' on Shipping tab
        summaryPage.checkBox.click();
        summaryPage.proceedToCheckOut2.click();

        //STEP 12: Confirm the correct order on 'Payment' tab

        // Verify the product name
        Assert.assertEquals(summaryPage.product.getText(),"Printed Chiffon Dress");
        // Verify the product size
        Assert.assertTrue(summaryPage.productSize.getText().contains("M"));


    }
}
