package com.ethoca.pages;

import com.ethoca.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SummerDressPage {
    public SummerDressPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//*[@title='Printed Chiffon Dress'])[2]")
    public WebElement Printed_Chiffon_Dress;

    @FindBy(xpath = "(//*[@class='product-image-container'])[3]//a//span")
    public WebElement quickView;

}
