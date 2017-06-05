package testGrid.demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.net.URL;

/**
 * Created by xhm on 2017/6/1.
 * 使用selenium Grid 使测试用例在不同的浏览器上运行
 */
public class TestGrid2 {
    public static WebDriver driver;
    public static DesiredCapabilities browser;
    public static void searchKey(WebDriver driver,String browser){
        driver.get("https://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("this is "+browser);
        driver.findElement(By.id("su")).click();
        driver.quit();
    }
    public static void main(String[] args)throws Exception{
        String[] browsers={"chorme","firefox"};
        for (int i=0;i<2;i++){
            System.out.println(browsers[i]);
            if (browsers[i].equals("chorme")){
                browser=DesiredCapabilities.chrome();
            }
            else if(browsers[i].equals("firefox")){
                browser=DesiredCapabilities.firefox();
            }
            else {
                Assert.fail("browser 参数只能为 firefox、 chrome");
            }
            driver=new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"),browser);
            searchKey(driver,browsers[i]);
        }
    }
}
