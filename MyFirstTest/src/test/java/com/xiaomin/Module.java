package com.xiaomin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by xhm on 2017/5/26.
 */
public class Module {
    public static void login(WebDriver driver,String username,String password) throws InterruptedException{
        WebElement xf = driver.findElement(By.xpath("//*[@id='x-URS-iframe']"));
        driver.switchTo().frame(xf);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(username);
        Thread.sleep(2000);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(2000);
        driver.findElement(By.id("dologin")).click();
        driver.switchTo().defaultContent();
    }
    public static void loginout(WebDriver driver){
        driver.findElement(By.linkText("退出")).click();
    }
}
