package com.xiaomin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by xhm on 2017/5/26.
 */
public class MailLogin {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.126.com/");
        String username="butterfly12186";
        String password="min121";
        Module.login(driver,username,password);
//        Thread.sleep(5000);
        Module.loginout(driver);
        System.out.println("login success");
        driver.quit();
    }

}
