package com.ML.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Base {
 public WebDriver driver;
 DesiredCapabilities desiredCapabilities;
 ChromeOptions chromeOptions;
 EdgeOptions edgeOptions;
/*
this method is you when your runing with  normal testng.xml file
 */
//@BeforeSuite
//    public void initilizeBrowser(){
//    WebDriverManager.edgedriver().setup();
//    driver=new EdgeDriver();
//    driver.get("https://magento.softwaretestingboard.com/customer/account/");
//}
/*
this method is use when your runing with lamdaTest or seleniumGrid
 */
@Parameters({"browserName","serverlink"})
@BeforeTest
    public void initilizeUrl(String browserName,@Optional("")String serverlink) throws MalformedURLException {
    switch(browserName) {
        case "chrome":

            desiredCapabilities = new DesiredCapabilities();
            chromeOptions = new ChromeOptions();
            desiredCapabilities.setCapability("browser","chrome");
            desiredCapabilities.merge(chromeOptions);
            driver = new RemoteWebDriver(new URL(serverlink),chromeOptions);
            driver.get("https://magento.softwaretestingboard.com/customer/account/");

            break;
        case "edge":
            desiredCapabilities = new DesiredCapabilities();
            edgeOptions = new EdgeOptions();
            desiredCapabilities.setCapability("browser","edge");
            desiredCapabilities.merge(edgeOptions);
            driver = new RemoteWebDriver(new URL(serverlink),edgeOptions);
            driver.get("https://magento.softwaretestingboard.com/customer/account/");

            break;
        default	:
            System.out.println("Browser name is invalid");
            break;
    }
    driver.manage().window().maximize();

}
/*
this method is use to close the browser
 */
@AfterTest
    public void killsession(){
    driver.quit();
}
}
