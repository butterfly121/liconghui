package testGrid.demo;
import java.net.URL;
import java.util.HashMap;

import java.util.Iterator; import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.openqa.selenium.remote.RemoteWebDriver; import org.testng.Assert;
/**
 * Created by xhm on 2017/6/1.
 */
public class TestGrid3 {
    public static WebDriver driver;

    public static DesiredCapabilities br;
    public static void searchKey(WebDriver driver,String browser) {

        driver.get("https://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("this is "+browser);
        driver.findElement(By.id("su")).click();

//        driver.quit();
    }
    public static void main(String[] args) throws Exception {
        HashMap<String,String> config=new HashMap<String, String>();
        config.put("firefox","http://127.0.0.1:5555/wd/hub");
        config.put("chrome","http://127.0.0.1:5556/wd/hub");
        //采用迭代器遍历HashMap
        Iterator<String> item=config.keySet().iterator();
        while (item.hasNext()){
            // 获得字典的 key(浏览器)
            String browser = (String) item.next();

            System.out.println(browser);
            // 获得字典的 value(节点)
            String nodeip = config.get(browser);

            System.out.println(nodeip);

            if (browser.equals("firefox")){
                br = DesiredCapabilities.firefox();
            }else if (browser.equals("chrome")){

                br = DesiredCapabilities.chrome(); }else{
                Assert.fail("browser 参数只能为 firefox、 chrome");

            }
            driver = new RemoteWebDriver(new URL(nodeip), br);
            searchKey(driver,browser);

        }
    }
}
