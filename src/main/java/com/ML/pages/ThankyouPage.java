package com.ML.pages;

import com.ML.Actions.SeliniumActions;
import com.ML.Json.ReadFromJson;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ThankyouPage {
    WebDriver driver;
    SeliniumActions seliniumActions;

    public ThankyouPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        seliniumActions=new SeliniumActions();


    }
    @FindBy(xpath = "//a[@class='order-number']")
    WebElement ordernumberclick;

    public WebElement ordernumberverify(){
        WebElement ordernumber=driver.findElement(By.xpath("//p[text()='Your order number is: ']"));
        return ordernumber;
    }
    public void clickonOrderNumber(){
        seliniumActions.clickOnElement(ordernumberclick);

    }
    public WebElement verifyDate(){
        WebElement date=driver.findElement(By.cssSelector("div[class='order-date']"));
        return date;
    }
}
