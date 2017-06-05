package testGrid.demo;

import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
/**
 * Created by xhm on 2017/6/1.
 */
public class TestGrid {
    public static void main(String[] args) throws Exception{
        WebDriver driver=new RemoteWebDriver(new URL(
                "http://127.0.0.1:4444/wd/hub"),DesiredCapabilities.chrome());
        driver.get("https://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("selenium");
        driver.findElement(By.id("su")).click();
        driver.quit();

    }
}
