package com.ML.pages;

import com.ML.Actions.SeliniumActions;
import com.ML.Json.ReadFromJson;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileNotFoundException;

public class ShippingAddresPage {
    WebDriver driver;
    SeliniumActions seliniumActions;
    ReadFromJson readFromJson;
    public ShippingAddresPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        seliniumActions=new SeliniumActions();
        readFromJson=new ReadFromJson();

    }

    @FindBy(xpath = "//button[@class='action action-show-popup']")
    WebElement newaddress;
    @FindBy(name = "shippingAddress.firstname")
    WebElement firstname;

    @FindBy(name = "shippingAddress.lastname")
    WebElement lastname;

    @FindBy(xpath = "//input[@name='company']")
    WebElement company;

    @FindBy(xpath="//input[@name='street[0]']")
    WebElement street;

    @FindBy(xpath =  "//input[@name='city']")
    WebElement city;

    @FindBy(xpath = "//input[@name='telephone']")
    WebElement pohneno;

    @FindBy(xpath = "//select[@name='country_id']")
    WebElement countrycodedropdown;

    @FindBy(xpath = "//select[@name='region_id']")
    WebElement statedropdown;
    @FindBy(xpath = "//input[@name='postcode']")
    WebElement postcodetextfield;

    @FindBy(xpath = "//button[@class='action primary action-save-address']")
    WebElement shipherebutton;

    @FindBy(xpath = "//span[text()='Next']/parent::button/parent::div")
    WebElement nextbutton;



    public void newaddressbutton(){
        seliniumActions.clickOnElement(newaddress);

    }
    public void shippingAddresDetails() throws FileNotFoundException, InterruptedException {
        seliniumActions.clickOnElement(newaddress);
        Thread.sleep(3000);
        //seliniumActions.enterValueOnTextfield(firstname,readFromJson.readFile("First Name"));
       // seliniumActions.enterValueOnTextfield(lastname,readFromJson.readFile("LastName"));
        seliniumActions.enterValueOnTextfield(company,readFromJson.readFile("Company"));
        seliniumActions.enterValueOnTextfield(street,readFromJson.readFile("StreetAddress"));
        seliniumActions.enterValueOnTextfield(city,readFromJson.readFile("City"));
        seliniumActions.selectValueFromDropDown(countrycodedropdown,readFromJson.readFile("countryvalue"),"value");
        seliniumActions.selectValueFromDropDown(statedropdown,readFromJson.readFile("statevalue"),"value");
        seliniumActions.enterValueOnTextfield(postcodetextfield,readFromJson.readFile("postcode"));
        seliniumActions.enterValueOnTextfield(pohneno,readFromJson.readFile("PhoneNumber"));
        Thread.sleep(2000);
        seliniumActions.clickOnElement(shipherebutton);
        seliniumActions.clickOnElement(nextbutton);
    }
    public void clickonneatbutton(){

         seliniumActions.waitandClickElement(nextbutton);
       seliniumActions.javaScriptExcecutorClick(nextbutton,driver);

    }
}
