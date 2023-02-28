package com.ML.pages;

import com.ML.Actions.SeliniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addtocartpage {
    WebDriver driver;
    SeliniumActions seliniumActions;
    public Addtocartpage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        seliniumActions=new SeliniumActions();

    }
    @FindBy(xpath = "//a[@class='action showcart']")
    WebElement addcart;
    @FindBy(xpath = "//div[@class='primary']/button[@type='button']")
    WebElement checkout;

    @FindBy(xpath = "//button[@type='button']/span[text()='New Address']")
    WebElement newaddress;
    public void clickonaddcart(){
        seliniumActions.clickOnElement(addcart);
    }
    public void proceedtocheckout(){
        seliniumActions.waitandClickElement(checkout);
        seliniumActions.clickOnElement(checkout);
    }
//    public void newaddressbuttom(){
//        seliniumActions.waitandClickElement(newaddress);
//    }
}
