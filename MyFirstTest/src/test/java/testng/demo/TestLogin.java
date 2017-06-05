package testng.demo;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * Created by xhm on 2017/5/31.
 */
public class TestLogin {
    private WebDriver driver;
    private String baseUrl;
    @BeforeTest
    public void setUp(){
        driver=new ChromeDriver();
        baseUrl="http://www.126.com/";
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }
    @AfterTest
    public void tearDown() throws Exception{
        driver.quit();
    }
    //定义对象数组
    @DataProvider(name = "user")
    public Object[][] Users(){
        return new Object[][]{
            {"","","请输入帐号"},
            {"test","","请输入密码"},
            {"error","error","请点击验证码"},
        };
    }
    //登录方法
    public static void login(WebDriver driver,String username,String password){
        WebElement xf = driver.findElement(By.xpath("//*[@id='loginDiv']/iframe"));
        driver.switchTo().frame(xf);

        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(username);
        driver.findElement(By.name("password")).clear();

        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.id("dologin")).click();
    }
    @Test(dataProvider = "user")
    public void verifyLogin(String username,String password,String assertStr){
        driver.get(baseUrl);
        login(driver,username,password);
        String text=driver.findElement(By.className("ferrorhead")).getText();
        System.out.println(text);
        assertEquals(text,assertStr);
    }
}
