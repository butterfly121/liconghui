package testng.demo;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertEqualsNoOrder;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import java.util.concurrent.TimeUnit;
/**
 * Created by xhm on 2017/5/31.
 */
public class testMail {
    private WebDriver driver;
    private String baseUrl;
    @BeforeTest
    public void setUp(){
        driver=new ChromeDriver();
        baseUrl="http://wwww.126.com/";
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }
    @AfterTest
    public void tearDown() throws Exception{
        driver.quit();
    }
    //登录方法
    public static void login(WebDriver driver,String username,String password){
        WebElement xf=driver.findElement(By.xpath("//*[@id='loginDiv']/iframe"));
        driver.switchTo().frame(xf);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("dologin")).click();
        driver.switchTo().defaultContent();
    }
    //退出方法
    public static void logout(WebDriver driver){
        driver.findElement(By.linkText("退出")).click();
    }
    @Test
    public void verifyLogin(){
        driver.get(baseUrl);
        String username="testingwtb";
        String password="erro";
        login(driver,username,password);
        String text = driver.findElement(By.id("spnUid")).getText();
        assertEquals(text,"testingwtb@126.com");
        logout(driver);
    }
    @Test (dependsOnMethods = {"verifyLogin"})
    public void verifySearchMail(){
        driver.get(baseUrl);
        String username = "testingwtb"; String password = "a123456";

        login(driver,username,password);
        //搜索
        WebElement search = driver.findElement(By.xpath("//input[@class='nui-ipt-input' and @type='text']"));
        search.sendKeys("小明");

        search.sendKeys(Keys.ENTER);
        String text = driver.findElement(By.className("nui-title-text")).getText();
        System.out.println(text);

        assertEquals(text,"搜索结果"); logout(driver);

    }
    @Test
    public void test01(){
        System.out.println("lallalalalallalalala");
    }
}
