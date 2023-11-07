import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;


import static java.lang.Thread.sleep;
import static org.junit.Assert.*;


public class SauseDemo  {

    ChromeDriver driver;
    String BASE_URL = "https://www.saucedemo.com/";



    @Before

    public void SetUp(){
        System.setProperty("web-driver.chrome.driver", "/Users/inna/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(BASE_URL);
    }
@Test

public void loginWithValidData () throws InterruptedException {
    WebElement UserName = driver.findElement(By.id("user-name"));
    UserName.sendKeys("standard_user");
    WebElement password = driver.findElement(By.id("password"));
    password.sendKeys("secret_sauce");
    WebElement loginbutton = driver.findElement(By.id("login-button"));
    loginbutton.click();

    System.out.println(driver.getCurrentUrl());
    sleep(1000);
    assertTrue (driver.getCurrentUrl().contains("inventory"));
    WebElement inventoryContainer = driver.findElements(By.id("inventory-container")).get(0);
    assertTrue (inventoryContainer.isDisplayed());
    
}


@Test
public void loginNegative() throws InterruptedException {


    WebElement userName = driver.findElement(By.id("user-name"));
    userName.sendKeys("locked_out_user");
    WebElement password = driver.findElement(By.id("password"));
    password.sendKeys(("secret_sauce"));
    WebElement loginbutton = driver.findElement(By.id("login-button"));
    loginbutton.click();
    WebElement errorMessage = driver.findElement(By.tagName("h3"));
     sleep(1000);
     assertEquals("Epic sadface: Sorry, this user has been locked out.",errorMessage.getText());
     assertTrue(errorMessage.getText().contains("Sorry, this user has been locked out."));

}
@Test
public void loginNegative1( ) throws InterruptedException {
    WebElement userName = driver.findElement(By.id("user-name"));
    userName.sendKeys("ujhygft");
    WebElement password = driver.findElement(By.id("password"));
    password.sendKeys(("0000000"));
    WebElement loginbutton = driver.findElement(By.id("login-button"));
    loginbutton.click();
    sleep(3000);
    WebElement responseNegRegistrat = driver.findElement(By.tagName("h3"));
    assertEquals("Epic sadface: Username and password do not match any user in this service",
            responseNegRegistrat.getText());


}





    @After
    public void tearDown(){
        driver.quit();
    }





}
