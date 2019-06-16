package com.ethoca.pages;

import com.ethoca.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@title='Women']")
    public WebElement women;

    @FindBy(xpath = "//*[@title=\"Summer Dresses\"]")
    public WebElement summerDressButtom;

    @FindBy(xpath = "(//*[@rel='nofollow'])[2]")
    public WebElement Cart;

    @FindBy(xpath = "//*[@id=\"button_order_cart\"]/span")
    public WebElement checkOut;


}
