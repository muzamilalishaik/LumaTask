package com.ML.pages;

import com.ML.Actions.SeliniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BagsPage {
    WebDriver driver;
    SeliniumActions seliniumActions;
    public BagsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
        seliniumActions=new SeliniumActions();

    }
    @FindBy(xpath = "//span[text()='Add All to Cart']")//span[text()='Add All to Cart']
    WebElement addtocart;
    //div[@class='product-item-details']/div/following-sibling::div/div/button
    @FindBy(xpath = "//a[@class='action showcart']/span[text()='My Cart']")
    WebElement clickonaddcart;

    public Float bagPrice() {

        List<WebElement> listofprice = driver.findElements(By.xpath("//span[@class='price-wrapper ']//span[@class='price']"));
        List<Float> price = new ArrayList<>();
        for (WebElement list : listofprice) {
            price.add(Float.parseFloat(list.getText().replace("$", "")));
        }
        System.out.println("Higest price of bag is " + Collections.max(price));
        Float addmaxprice = Collections.max(price);
        return addmaxprice;

    }
    /*
    this method is use to get the highest price of bags
     */
    public String hightestprice(Float addmaxprice) {
        WebElement addtocart = driver.findElement(By.xpath("//span[@class='price-wrapper ']//span[contains(text(),'" + addmaxprice + "')]"));
        seliniumActions.clickOnElement(addtocart);

        WebElement iteamname=driver.findElement(By.xpath("//span[@class='price-wrapper ']//span[contains(text(),'"+addmaxprice+"')]/ancestor::span/parent::div/parent::div/strong/a[contains(text(),'Impulse Duffle')]"));
        String name= iteamname.getText();
        return name ;



    }
    /*
    this method is use to add the iteam in wishlist
     */
    public void addtowishlist(String name){
        WebElement clickomwishlist=driver.findElement(By.xpath("//a[contains(.,'"+name+"')]/parent::strong[@ class = 'product name product-item-name']/following-sibling::div/following-sibling::div/following-sibling::div/div/div/a[1]"));
        seliniumActions.clickOnElement(clickomwishlist);
    }
/*
this methos is use to add the iteam in cart
and verify the wish list
 */

    public void Addtocartandverifywishlist(){

        seliniumActions.clickOnElement(addtocart);
        seliniumActions.clickOnElement(clickonaddcart);

    }

}
