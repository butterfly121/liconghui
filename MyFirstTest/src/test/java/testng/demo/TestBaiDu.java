package testng.demo;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by xhm on 2017/5/31.
 */
public class TestBaiDu {
    private WebDriver driver;
    private String baseUrl;
    @BeforeTest
    public void setUp(){
        driver=new ChromeDriver();
        baseUrl="http://wwww.baidu.com/";
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }
    @Test
    @Parameters("test1")//设置测试方法的入参
    public void testCase(String test1) throws Exception{
        driver.get(baseUrl + "/");
        System.out.println("sreach key value:"+ test1);

        driver.findElement(By.id("kw")).sendKeys(test1);
        driver.findElement(By.id("su")).click();

        Thread.sleep(2000);
        String title =driver.getTitle();
        assertEquals(title,test1+"_百度搜索");

    }
    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();

    }
}
