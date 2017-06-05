package testGrid.demo;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils; import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;

/**
 * Created by xhm on 2017/6/1.
 */
public class PJTest {
    public static void main(String[] args) throws InterruptedException {
//        DesiredCapabilities DesireCaps = new DesiredCapabilities();
//        DesireCaps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, PHANTOMJSDRIVER_PATH);
        WebDriver driver = new PhantomJSDriver();
        driver.get("https://www.baidu.com/");

        driver.findElement(By.id("kw")).sendKeys("phantomjs");
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);

        //截图
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {

            FileUtils.copyFile(srcFile, new File("/Users/xhm/Desktop/screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

}
