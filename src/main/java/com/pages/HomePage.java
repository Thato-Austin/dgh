package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class HomePage{
    public static WebDriver driver;

    public void setDriver(WebDriver driver){
        HomePage.driver = driver;
    }

    public LoginPage clickLogin(){
        WebElement MyAccount = driver.findElement(
                By.xpath("//div[@id='widget-navbar-217834']/ul/li[6]/a/div"));
        Actions action = new Actions(driver);
        action.moveToElement(MyAccount).perform();
        driver.findElement(By.linkText("Login")).click();
        return new LoginPage();
    }
}
