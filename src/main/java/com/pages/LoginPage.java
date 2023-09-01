package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public static WebDriver driver;

    public void enterEmail(String email){
        driver.findElement(By.id("input-email")).click();
        driver.findElement(By.id("input-email")).sendKeys(email);
    }

    public void enterPassword(String password){
        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).sendKeys(password);
    }

    public void clickSubmit(){
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }
}
