package com.xiaomin;
import  org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.By;
/**
 * Created by xhm on 2017/5/24.
 */
public class testFinal
{
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("http://192.168.64.222:8088/login.aspx");
        driver.findElement(By.id("txt_usercode")).clear();
        driver.findElement(By.id("txt_usercode")).sendKeys("zhangjian");
        driver.findElement(By.id("txt_pwd")).clear();
        driver.findElement(By.id("txt_pwd")).sendKeys("111111");
        driver.findElement(By.id("btn_login")).click();
        driver.findElement(By.linkText("渠道")).click();
        driver.findElement(By.linkText("最终客户23")).click();
    }
}
