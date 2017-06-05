import org.openqa.selenium.By;
import  org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Created by xhm on 2017/5/23.
 */
public class baidutest
{
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.baidu.com/");
        WebElement search_text = driver.findElement(By.id("kw"));
        search_text.sendKeys("Java Selenium");
        Thread.sleep(2000);
        search_text.submit();
        driver.quit();
    }
}
