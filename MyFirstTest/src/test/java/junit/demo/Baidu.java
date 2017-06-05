package junit.demo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
/**
 * Created by xhm on 2017/5/31.
 */
public class Baidu {
    private WebDriver driver;
    private String baseUrl;
    @Before
    public void setUp() throws Exception{
        driver = new FirefoxDriver();
        baseUrl="https://www.baidu.com";
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }
    public void baiduSearch(String searchKey){
        driver.findElement(By.id("kw")).clear();
        driver.findElement(By.id("kw")).sendKeys(searchKey);
        driver.findElement(By.id("su")).click();
    }
    @Test
    public void testSearchJunit() throws InterruptedException{
        driver.get(baseUrl+"/");
        baiduSearch("Junit");
        Thread.sleep(2000);
        assertEquals(driver.getTitle(),"Junit_百度搜索");
    }
    @Test
    public void testSearchWebDriver() throws InterruptedException{
        driver.get(baseUrl+"/");
        baiduSearch("WebDriver");
        Thread.sleep(2000);
    }
    @After
    public void tearDown() throws Exception{
        driver.quit();
    }

}
