package page.demo;
import static org.testng.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/**
 * Created by xhm on 2017/6/1.
 */
public class searchTest {
    private WebDriver driver;
    private String baseUrl;

    @BeforeTest

    public void setUp() throws Exception {
        driver = new ChromeDriver();
        baseUrl = "https://www.baidu.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterTest

    public void tearDown() throws Exception {
        driver.quit();
    }

    // 定义对象数组

    @DataProvider(name = "search")
    public Object[][] Users() {
        return new Object[][]{{"java"},

                {"page object"},
                {"testNG"}
        };

    }

    @Test(dataProvider = "search")
    public void testCase(String search) throws Exception {
        driver.get(baseUrl + "/");

        SearchPage.input(driver, search);
        SearchPage.button(driver);
        Thread.sleep(2000);

        String title = driver.getTitle();
        assertEquals(title, search + "_百度搜索");


    }
}
