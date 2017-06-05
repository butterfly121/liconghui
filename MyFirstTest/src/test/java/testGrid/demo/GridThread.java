package testGrid.demo;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by xhm on 2017/6/1.
 */
public class GridThread {
    private WebDriver driver;
    DesiredCapabilities browserDriver;
    private String baseUrl;
    @Parameters({"browser","nodeUrl"})
    @BeforeTest
    public void setUp(String brower,String nodeUrl) throws MalformedURLException{
      if (brower.equals("firefox")){
          browserDriver=DesiredCapabilities.firefox();
      }
      else if(brower.equals("chrome1")){
          browserDriver=DesiredCapabilities.chrome();
      }
      else {
          Assert.fail("browser 参数只能为 firefox、 chrome");
      }
      String url=nodeUrl+"/wd/hub";
      driver = new RemoteWebDriver(new URL(url),browserDriver);
      baseUrl="https://www.baidu.com/";
    }
    @Parameters({"browser"})
    @Test
    public void test(String browser) throws InterruptedException{
        driver.get(baseUrl);
        driver.findElement(By.id("kw")).sendKeys("this is "+browser);
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);
        System.out.println("title:"+ driver.getTitle());
    }
    @AfterClass
    public void quit(){
        driver.quit();
    }


}
