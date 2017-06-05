package com.xiaomin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.*;

/**
 * Created by xhm on 2017/5/26.
 */
public class MailLogin2 {
    public static void main(String[] args) throws InterruptedException,IOException{
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.126.com/");
        File file=new File("/Users/xhm/IdeaProjects/MyFirstTest/datafile/info.txt");
        BufferedReader bufread=new BufferedReader(new FileReader(file));
        String lineTxt=bufread.readLine();
        String username=lineTxt.split(";")[0];
        String password=lineTxt.split(";")[1];;
        Module.login(driver,username,password);
        Thread.sleep(5000);
        System.out.println("login success");
        Module.loginout(driver);
        driver.quit();
    }
}
