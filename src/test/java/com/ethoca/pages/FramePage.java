package com.ethoca.pages;

import com.ethoca.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramePage {
    public FramePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//iframe[contains(@id,'fancybox-frame')]")
    public WebElement frame;

    @FindBy(name = "Submit")
    public WebElement add_to_Card;

    @FindBy(id = "group_1")
    public WebElement dropDown;

    @FindBy(xpath = "//*[@title='Continue shopping']/span")
    public WebElement conShopping;

}
