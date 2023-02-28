package com.ML.pages;

import com.ML.Actions.SeliniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
    SeliniumActions seliniumActions;

    public  LoginPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
        seliniumActions= new SeliniumActions();
    }


@FindBy(id="email")
    WebElement emailtextbox;
    @FindBy(id="pass")
    WebElement passwordtextbox;
    @FindBy(name = "send")
    WebElement singupbutton;
    public  void loginDetails(String email, String pass){

        seliniumActions.enterValueOnTextfield(emailtextbox,email);
        seliniumActions.enterValueOnTextfield(passwordtextbox,pass);
        seliniumActions.clickOnElement(singupbutton);


    }
}
