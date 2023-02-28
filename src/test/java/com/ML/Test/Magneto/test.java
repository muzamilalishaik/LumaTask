package com.ML.Test.Magneto;

import com.ML.Base.Base;
import com.ML.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class test extends Base {
LoginPage loginPage;
    GearBagsPage gearBags;
    Addtocartpage addtocartpage;
    BagsPage bagsPage;
    ShippingAddresPage shippingAddresPage;
    ReviewPaymentPage reviewPaymentPage;

    ThankyouPage thankyouPage;
    @BeforeClass
    public void initilizePages(){
        loginPage=new LoginPage(driver);
        gearBags =new GearBagsPage(driver);
        addtocartpage =new Addtocartpage(driver);
        bagsPage=new BagsPage(driver);
        shippingAddresPage=new ShippingAddresPage(driver);
        reviewPaymentPage=new ReviewPaymentPage(driver);
        thankyouPage=new ThankyouPage(driver);

    }
    @Test
    public void magneto() throws FileNotFoundException, InterruptedException {
        loginPage.loginDetails("shaikmuzamilali@gmail.com","Muz@mil79");
        gearBags.selectbags();
        WebElement addcartmsg = driver.findElement(By.xpath("//strong[@class='subtitle empty']"));
        String addcarttext = addcartmsg.getText();
        String actualmsg ="You have no items in your shopping cart.";
        System.out.println(addcarttext);
        Assert.assertEquals(actualmsg,addcarttext);
        gearBags.closeviewcartmsgbutton();
        bagsPage.addtowishlist(bagsPage.hightestprice(bagsPage.bagPrice()));
        WebElement wishlistiteamname =driver.findElement(By.xpath("//a[contains(text(),'Impulse Duffle ')]"));
        String wishlistname=wishlistiteamname.getText();
        String actualwishlistname="Impulse Duffle";
        Assert.assertEquals(wishlistname,actualwishlistname);
        bagsPage.Addtocartandverifywishlist();
        WebElement emptymsgloctor=driver.findElement(By.xpath("//span[text()='You have no items in your wish list.']"));
        String emptywishlistmsg=emptymsgloctor.getText();
        String actualemptywishlistmsg="You have no items in your wish list.";
        Assert.assertEquals(emptywishlistmsg,actualemptywishlistmsg);
        addtocartpage.clickonaddcart();
        addtocartpage.proceedtocheckout();
        shippingAddresPage.shippingAddresDetails();
        WebElement addresdetail=driver.findElement(By.xpath("//div[@class='checkout-billing-address']"));
        Assert.assertTrue(addresdetail.isDisplayed());
        Thread.sleep(3000);
        reviewPaymentPage.palceorder();
        Assert.assertTrue(thankyouPage.ordernumberverify().isDisplayed());
        thankyouPage.clickonOrderNumber();
        //Assert.assertTrue(thankyouPage.verifyDate().isDisplayed());


//        try {
//            shippingAddresPage.newaddressbutton();
//            shippingAddresPage.shippingAddresDetails();
//        }catch (Exception nse) {
//            shippingAddresPage.clickonneatbutton();
//
//        }

    }

}
