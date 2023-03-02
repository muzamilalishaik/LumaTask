package com.ML.pages;

import com.ML.Actions.SeliniumActions;
import com.ML.Json.ReadFromJson;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewPaymentPage {
    WebDriver driver;
    SeliniumActions seliniumActions;

    public ReviewPaymentPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        seliniumActions=new SeliniumActions();


    }
    @FindBy(xpath = "//button[@class='action primary checkout']")
    WebElement placebutton;

    public void palceorder(){
        seliniumActions.clickOnElement(placebutton);
       // seliniumActions.javaScriptExcecutorClick(placebutton,driver);
    }
    public WebElement reviewaddres(){
        WebElement addresdetail=driver.findElement(By.xpath("//div[@class='checkout-billing-address']"));
        return addresdetail;

    }
}
