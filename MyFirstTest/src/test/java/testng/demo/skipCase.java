package testng.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

/**
 * Created by xhm on 2017/5/31.
 */
public class skipCase {
    private WebDriver driver;
    private String baseUrl;
    @BeforeTest
    public void setUp(){
        driver=new ChromeDriver();
        baseUrl="http://wwww.baidu.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @AfterTest
    public void tearDown() throws Exception{
        driver.quit();
    }
    @Test(enabled = false)
    public void skipCase()throws Exception{
        driver.get(baseUrl);
        driver.findElement(By.id("kw")).sendKeys("testNG");
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);
        String title=driver.getTitle();
        assertEquals(title,"testNG_百度搜索");
    }
    @Test
    public void test02(){
        System.out.println("啦啦啦啦啦啦啦啦啦");
    }
}
