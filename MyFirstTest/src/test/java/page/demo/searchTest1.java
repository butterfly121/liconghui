package page.demo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

/**
 * Created by lch on 2017/6/3.
 */
public class searchTest1 {
    @Test
    public  void main() throws InterruptedException{
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.baidu.com");
        searchPage1 pa=new searchPage1(driver);
        pa.inputText("webdriver");
        pa.clickButton();

        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public  void test02()throws Exception{
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.baidu.com");
        searchPage2 pa1=new searchPage2(driver);
        pa1.inputText("webdriver selenium");
        pa1.clickButton();

        Thread.sleep(3000);
        driver.quit();
    }
}
