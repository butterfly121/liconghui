package page.demo;
import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/**
 * Created by lch on 2017/6/3.
 */
public class LoginTest {
    private WebDriver driver;
    private String baseUrl;
    private LoginPage page;
    @BeforeTest
    public void SetUP(){
        this.driver=new ChromeDriver();
        this.baseUrl="http://www.126.com";
        this.page=new LoginPage(this.driver,baseUrl);
        driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void testCase()throws InterruptedException{
        page.login("butterfly12186","min121");
        Thread.sleep(5000);
        String username=page.user();
        assertEquals(username,"butterfly12186@126.com");
    }


}
