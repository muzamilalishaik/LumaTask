package com.ML.Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
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

@BeforeSuite
    public void initilizeBrowser(){
    WebDriverManager.edgedriver().setup();
    driver=new EdgeDriver();
}
@Parameters({"browserName","serverlink"})
@BeforeTest
    public void initilizeUrl(String browserName,@Optional("")String serverlink) throws MalformedURLException {
    switch(browserName.toLowerCase()) {
        case "chrome":
            //driver = new ChromeDriver();
            desiredCapabilities = new DesiredCapabilities();
            chromeOptions = new ChromeOptions();
            desiredCapabilities.setCapability("browser","chrome");
            desiredCapabilities.merge(chromeOptions);
            driver = new RemoteWebDriver(new URL(serverlink),chromeOptions);
            // driver.manage().window().setSize(new Dimension(0,500));
            break;
        case "edge":
            //driver = new EdgeDriver();
            desiredCapabilities = new DesiredCapabilities();
            edgeOptions = new EdgeOptions();
            desiredCapabilities.setCapability("browser","edge");
            desiredCapabilities.merge(edgeOptions);
            driver = new RemoteWebDriver(new URL(serverlink),edgeOptions);

            break;
        default	:
            System.out.println("Browser name is invalid");
            break;
    }
    driver.get("https://magento.softwaretestingboard.com/customer/account/");
    driver.manage().window().maximize();

}
//@AfterTest
//    public void killsession(){
//    driver.quit();
//}
}
