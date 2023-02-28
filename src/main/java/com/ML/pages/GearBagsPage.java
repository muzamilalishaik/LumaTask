package com.ML.pages;

import com.ML.Actions.SeliniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GearBagsPage {
    WebDriver driver;
    SeliniumActions seliniumActions;
    public GearBagsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        seliniumActions=new SeliniumActions();

    }
    @FindBy(xpath = "//span[text()='Gear']")
    WebElement gearfield;

    @FindBy(xpath = "//span[text()='Bags']")
    WebElement bagsfield;

    @FindBy(xpath = "//a[@class='action showcart']")
    WebElement addcart;

    @FindBy(xpath = "//strong[@class='subtitle empty']")
    WebElement addcartmsg;

    @FindBy(xpath = "//button[@title='Close']")
    WebElement addcartclose;

    @FindBy(xpath = "//span[@class='price']")
    WebElement allbagsprice;



    public void selectbags() {
        seliniumActions.movetoelement(driver, gearfield);
        seliniumActions.clickOnElement(bagsfield);
        seliniumActions.clickOnElement(addcart);
    }
        public void closeviewcartmsgbutton(){

        seliniumActions.clickOnElement(addcartclose);
    }





    }


