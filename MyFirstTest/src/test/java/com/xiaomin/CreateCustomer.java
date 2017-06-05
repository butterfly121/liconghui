package com.xiaomin;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateCustomer {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new ChromeDriver();
    baseUrl = "http://192.168.64.222:8088/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCreateCustomer() throws Exception {
    //新建客户
    driver.get(baseUrl + "/login.aspx");
    driver.findElement(By.id("txt_usercode")).clear();
    driver.findElement(By.id("txt_usercode")).sendKeys("zhangjian");
    driver.findElement(By.id("txt_pwd")).clear();
    driver.findElement(By.id("txt_pwd")).sendKeys("111111");
    driver.findElement(By.id("btn_login")).click();
//    WebElement cre=driver.findElement(By.xpath("//*[@id='form1']"));
//    driver.switchTo().frame(cre);
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='side-menu']/li[4]/a")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='side-menu']/li[4]/ul/li[1]/a")).click();
    Thread.sleep(2000);
    WebElement rc=driver.findElement(By.xpath("//*[@id='page31']"));
    driver.switchTo().frame(rc);
    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    Thread.sleep(2000);
    WebElement sr=driver.findElement(By.xpath("html/body/div[4]/div[3]/iframe"));
    driver.switchTo().frame(sr);
    Thread.sleep(2000);
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    driver.findElement(By.id("Name")).clear();
    driver.findElement(By.id("Name")).sendKeys("客户52409");
    new Select(driver.findElement(By.id("ParentCustomer"))).selectByVisibleText("哈哈哈ssdfsdf");
    new Select(driver.findElement(By.id("Level"))).selectByVisibleText("中客户");
    new Select(driver.findElement(By.id("IndustryId"))).selectByVisibleText("金融");
    Thread.sleep(2000);
//    driver.findElement(By.cssSelector("option[value=\"58e48b60104234cae4494c3f\"]")).click();
    new Select(driver.findElement(By.id("SubIndustryId"))).selectByVisibleText("证券");
    Thread.sleep(2000);
//    driver.findElement(By.cssSelector("option[value=\"58e48bf8104234cae4494c8b\"]")).click();
    new Select(driver.findElement(By.id("AddressProvinceCode"))).selectByVisibleText("湖北");
    Thread.sleep(2000);
//    driver.findElement(By.cssSelector("option[value=\"420000\"]")).click();
    new Select(driver.findElement(By.id("AddressCityCode"))).selectByVisibleText("黄石");
    Thread.sleep(2000);
//    driver.findElement(By.cssSelector("option[value=\"420200\"]")).click();
    new Select(driver.findElement(By.id("AddressAreaCode"))).selectByVisibleText("下陆");
    Thread.sleep(2000);
    driver.findElement(By.id("AddressDetail")).clear();
    driver.findElement(By.id("AddressDetail")).sendKeys("等待咕咚咕咚风格");
    driver.findElement(By.id("Telephone")).clear();
    driver.findElement(By.id("Telephone")).sendKeys("15601235689");
    new Select(driver.findElement(By.id("Department"))).selectByVisibleText("咨询设计二部");
    Thread.sleep(2000);
//    driver.findElement(By.cssSelector("option[value=\"58e5d1f26515600638a97858\"]")).click();
    new Select(driver.findElement(By.id("Department"))).selectByVisibleText("金融行业部");
    Thread.sleep(2000);
//    driver.findElement(By.cssSelector("option[value=\"58e5a0006515600a5c864f5d\"]")).click();
    new Select(driver.findElement(By.id("Department"))).selectByVisibleText("教育行业部");
    Thread.sleep(2000);
//    driver.findElement(By.cssSelector("option[value=\"58e5a0686515600a5c864f7f\"]")).click();
    new Select(driver.findElement(By.id("PersonInCharge"))).selectByVisibleText("张健");
    driver.findElement(By.id("CompanyWebsite")).clear();
    driver.findElement(By.id("CompanyWebsite")).sendKeys("电饭锅电饭锅");
    driver.findElement(By.id("BriefIntroduction")).clear();
    driver.findElement(By.id("BriefIntroduction")).sendKeys("德国反对法国地方");
    driver.findElement(By.id("Remark")).clear();
    driver.findElement(By.id("Remark")).sendKeys("个电饭锅电饭锅");
    driver.findElement(By.id("btn_save")).click();
    Thread.sleep(2000);
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
