package com.ethoca.pages;

import com.ethoca.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SummaryPage {

    static Faker faker;

    public SummaryPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
    public WebElement checkOut;

    @FindBy(id="email_create")
    public WebElement emailInput;

    @FindBy(xpath = "//*[@id=\"SubmitCreate\"]//span")
    public WebElement create;

    @FindBy(id="customer_firstname")
    public WebElement firstName;

    @FindBy(id="customer_lastname")
    public WebElement lastName;

    @FindBy(id="passwd")
    public WebElement passWord;

    @FindBy(id="address1")
    public WebElement address;

    @FindBy(id="city")
    public WebElement city;

    @FindBy(id="postcode")
    public WebElement postalCode;

    @FindBy(id="phone_mobile")
    public WebElement phone;

    @FindBy(xpath = "//*[@id=\"submitAccount\"]//span")
    public WebElement register;

    @FindBy(id="id_state")
   public WebElement stateList;

    @FindBy(xpath = "//*[@name='processAddress']/span")
    public WebElement proceedToCheckOut;

    @FindBy(id="cgv")
    public WebElement checkBox;

    @FindBy(xpath = "//*[@name='processCarrier']/span")
    public WebElement proceedToCheckOut2;

    @FindBy(xpath = "//*[contains(@id,'product_')]/td[2]/p/a")
    public WebElement product;

    @FindBy(xpath = "//*[contains(@id,'product_')]/td[2]/small/a")
    public WebElement productSize;


    public static String firstNameCreation(){
        faker = new Faker();
        return faker.name().firstName();
    }

    public static String lastNameCreation(){
        return faker.name().lastName();
    }

    public static String randomEmail(){
        return firstNameCreation()+lastNameCreation()+"@gmail.com";
    }

    public static String passWordCreation(){
        return firstNameCreation()+lastNameCreation();
    }


    public static String addressCreation(){
        return faker.address().streetAddress();
    }

    public static String cityCreation(){
        return faker.address().cityName();
    }

    public static String randomeNumber(){
        faker = new Faker();
        int ran = faker.number().numberBetween(1,50);
        String ranNumer = Integer.toString(ran);
        return ranNumer;
    }

    public static String postcodeCreation(){

        return faker.address().zipCode().substring(0,5);
    }

    public static String phoneNumberCreation(){
        return faker.phoneNumber().cellPhone();
    }

    public static void fillMandetoryInfo(){
        SummaryPage summaryPage = new SummaryPage();
        summaryPage.firstName.sendKeys(summaryPage.firstNameCreation());
        summaryPage.lastName.sendKeys(summaryPage.lastNameCreation());
        summaryPage.passWord.sendKeys(summaryPage.passWordCreation());
        summaryPage.address.sendKeys(summaryPage.addressCreation());
        summaryPage.city.sendKeys(summaryPage.cityCreation());
        Select select = new Select(summaryPage.stateList);
        select.selectByValue(summaryPage.randomeNumber());
        summaryPage.postalCode.sendKeys(summaryPage.postcodeCreation());
        summaryPage.phone.sendKeys(summaryPage.phoneNumberCreation());
        summaryPage.register.click();
    }

}
