package com.xiaomin;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import com.sun.tools.javac.comp.Enter;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;

public class FinalMainTable {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://192.168.64.222:8088/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //登录
    driver.get(baseUrl + "/login.aspx");
    driver.findElement(By.id("txt_usercode")).clear();
    driver.findElement(By.id("txt_usercode")).sendKeys("zhangjian");
    driver.findElement(By.id("txt_pwd")).clear();
    driver.findElement(By.id("txt_pwd")).sendKeys("111111");
    driver.findElement(By.id("btn_login")).click();
    //列表页
    driver.findElement(By.linkText("渠道")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id='side-menu']/li[4]/ul/li[1]/a")).click();
    driver.switchTo().frame("page31");
  }

  @Test
  public  void testFinalMainTable() throws Exception {


    //筛选
    new Select(driver.findElement(By.id("ddr_permissionGroup"))).selectByVisibleText("我参与的最终客户");
    Thread.sleep(2000);
    new Select(driver.findElement(By.id("ddr_permissionGroup"))).selectByVisibleText("我下属的最终客户");
    Thread.sleep(2000);
    new Select(driver.findElement(By.id("ddr_permissionGroup"))).selectByVisibleText("我负责的最终客户");
    Thread.sleep(2000);
    new Select(driver.findElement(By.id("ddr_industry"))).selectByVisibleText("金融");
    Thread.sleep(2000);
    new Select(driver.findElement(By.id("ddr_industry"))).selectByVisibleText("教育");
    Thread.sleep(2000);
    new Select(driver.findElement(By.id("ddr_subIndustry"))).selectByVisibleText("教育");
    Thread.sleep(2000);
    new Select(driver.findElement(By.id("ddr_industry"))).selectByVisibleText("军警");
    Thread.sleep(2000);
    new Select(driver.findElement(By.id("ddr_subIndustry"))).selectByVisibleText("军工");
    Thread.sleep(2000);
    new Select(driver.findElement(By.id("ddr_industry"))).selectByVisibleText("金融");
    Thread.sleep(2000);
    new Select(driver.findElement(By.id("ddr_subIndustry"))).selectByVisibleText("证券");
    Thread.sleep(2000);
    new Select(driver.findElement(By.id("ddr_effective"))).selectByVisibleText("缓存客户");
    Thread.sleep(2000);
    new Select(driver.findElement(By.id("ddr_subIndustry"))).selectByVisibleText("选择行业");
    Thread.sleep(2000);
    new Select(driver.findElement(By.id("ddr_industry"))).selectByVisibleText("选择领域");
    Thread.sleep(2000);
//    driver.findElement(By.cssSelector("#ddr_industry > option")).click();
    new Select(driver.findElement(By.id("ddr_effective"))).selectByVisibleText("有效客户");
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("button.form-control.btn-field-filter")).click();
    Thread.sleep(2000);
//    driver.findElement(By.xpath("//div[@id='sizzle-1495606300603']/table/tbody/tr[2]/td[4]")).click();
    driver.findElement(By.id("search_name")).sendKeys("2");
    driver.findElement(By.id("search_name")).sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    driver.findElement(By.id("search_name")).clear();

    driver.findElement(By.id("search_level")).sendKeys("中客户");
    driver.findElement(By.id("search_level")).sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    driver.findElement(By.id("search_level")).clear();

    driver.findElement(By.id("search_code")).sendKeys("4");
    driver.findElement(By.id("search_code")).sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    driver.findElement(By.id("search_code")).clear();

    driver.findElement(By.id("search_industryName")).sendKeys("酒店");
    driver.findElement(By.id("search_industryName")).sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    driver.findElement(By.id("search_industryName")).clear();

    driver.findElement(By.id("search_createTime")).sendKeys("2017-05-02");
    driver.findElement(By.id("search_createTime")).sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    driver.findElement(By.id("search_createTime")).clear()

    ;driver.findElement(By.id("search_updateTime")).sendKeys("2017-05-02");
    driver.findElement(By.id("search_updateTime")).sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    driver.findElement(By.id("search_updateTime")).clear();

    driver.findElement(By.id("search_contactNumber")).sendKeys("2");
    driver.findElement(By.id("search_contactNumber")).sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    driver.findElement(By.id("search_contactNumber")).clear();

    driver.findElement(By.id("search_personInCharge")).sendKeys("汪");
    driver.findElement(By.id("search_personInCharge")).sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    driver.findElement(By.id("search_personInCharge")).clear();

    driver.findElement(By.id("search_approvalStatus")).sendKeys("待审批");
    driver.findElement(By.id("search_approvalStatus")).sendKeys(Keys.ENTER);
    Thread.sleep(2000);
    driver.findElement(By.id("search_approvalStatus")).clear();
    driver.findElement(By.cssSelector("button.form-control.btn-field-filter")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("td.link-text")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//table[@id='simpledatatable']/thead/tr/th[2]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//table[@id='simpledatatable']/thead/tr/th[2]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//table[@id='simpledatatable']/thead/tr/th[3]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//table[@id='simpledatatable']/thead/tr/th[3]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//table[@id='simpledatatable']/thead/tr/th[4]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//table[@id='simpledatatable']/thead/tr/th[4]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//table[@id='simpledatatable']/thead/tr/th[5]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//table[@id='simpledatatable']/thead/tr/th[5]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//table[@id='simpledatatable']/thead/tr/th[6]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//table[@id='simpledatatable']/thead/tr/th[6]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//table[@id='simpledatatable']/thead/tr/th[7]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//table[@id='simpledatatable']/thead/tr/th[7]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//table[@id='simpledatatable']/thead/tr/th[8]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//table[@id='simpledatatable']/thead/tr/th[8]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//table[@id='simpledatatable']/thead/tr/th[9]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//table[@id='simpledatatable']/thead/tr/th[9]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//table[@id='simpledatatable']/thead/tr/th[10]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//table[@id='simpledatatable']/thead/tr/th[10]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//table[@id='simpledatatable']/thead/tr/th[2]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//table[@id='simpledatatable']/thead/tr/th[2]")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("check_checkAll")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("check_checkAll")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("div.zeromodal-close")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("button.form-control.list-add2")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//i[@onclick='alertClose();']")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("td > input[type=\"checkbox\"]")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("button.form-control.list-add2")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("div.zeromodal-close")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("button.form-control.list-transfer")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//i[@onclick='alertClose();']")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("td > input[type=\"checkbox\"]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("(//input[@type='checkbox'])[5]")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("button.form-control.list-transfer")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//i[@onclick='alertClose();']")).click();
    Thread.sleep(2000);
    new Select(driver.findElement(By.id("ddr_effective"))).selectByVisibleText("缓存客户");
    Thread.sleep(2000);
    driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("button.form-control.list-transfer")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//i[@onclick='alertClose();']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("(//input[@type='checkbox'])[7]")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("button.form-control.list-transfer")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//i[@onclick='alertClose();']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("(//input[@type='checkbox'])[7]")).click();
    Thread.sleep(2000);
    createCustomer();
  }
  @Test
  public  void createCustomer() throws Exception{
    driver.findElement(By.xpath("//*[@id='form1']/div[3]/div[3]/div[1]/button[2]")).click();
    WebElement xf=driver.findElement(By.xpath("html/body/div[4]/div[3]/iframe"));
    driver.switchTo().frame(xf);

    driver.findElement(By.id("Name")).clear();
    driver.findElement(By.id("Name")).sendKeys("0524mmm");
    new Select(driver.findElement(By.id("Level"))).selectByVisibleText("小客户");
    new Select(driver.findElement(By.id("IndustryId"))).selectByVisibleText("军警");
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
