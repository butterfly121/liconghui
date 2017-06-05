//import com.sun.jna.platform.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.interactions.Actions;
import javax.swing.*;
import java.security.Key;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.chrome.ChromeOptions;
//窗口截图
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import java.util.Random;
import java.util.Scanner;
/**
 * Created by xhm on 2017/5/25.
 */
public class BrowseGo {
    WebDriver driver=new ChromeDriver();
    public static void main(String[] args) throws InterruptedException {

//        BrowseGoTest();
//        BaiduDemo2();
//        MouseDemo();
//        KeyBord();
//        AssertDemo();
//        TimeOut01();
//        TimeOut02();
//        TimeOut03();
//        ElementDemo();
//        MailLogin();
//        MoreWindows();
//        AlertDemo();
//        UploadFile();
//        DownFileFF();
//        DownFileCC();
//        CookieDemo();
//        JSDemo();
//        Longtext();
//        VideoDemo();
//        GetImg();
        VerificationCode();


    }
    public static void BrowseGoTest() throws InterruptedException{
        WebDriver driver=new ChromeDriver();
        //到百度首页
        driver.get("http://www.baidu.com");
        System.out.printf("now access %s \n",driver.getCurrentUrl());
        Thread.sleep(2000);
        //放大缩小浏览器
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.manage().window().setSize(new Dimension(480,800));
        Thread.sleep(2000);
        driver.manage().window().maximize();
        //点击新闻链接
        driver.findElement(By.linkText("新闻")).click();
        System.out.printf("now access %s \n",driver.getCurrentUrl());
        Thread.sleep(2000);
        //执行浏览器后退
        driver.navigate().back();
        System.out.printf("back to %s \n",driver.getCurrentUrl());
        Thread.sleep(2000);
        //执行浏览器前进
        driver.navigate().forward();
        System.out.printf("forward to %s \n",driver.getCurrentUrl());
        Thread.sleep(2000);
        //刷新当前页面
        driver.navigate().refresh();
        Thread.sleep(2000);
        driver.navigate().back();
        WebElement search_text=driver.findElement(By.id("kw"));
//        WebElement search_button=driver.findElement(By.id("su"));

        search_text.sendKeys("Java");
        Thread.sleep(2000);
        search_text.clear();
        search_text.sendKeys("Selenium");
        search_text.submit();
        Thread.sleep(2000);
        driver.quit();
    }
    public static void BaiduDemo2() throws InterruptedException{
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.baidu.com");
        //获得百度输入框的尺寸
        WebElement size=driver.findElement(By.id("kw"));
        System.out.println(size.getSize());
        Thread.sleep(2000);
        //返回百度页面底部备案信息
        WebElement text=driver.findElement(By.id("cp"));
        System.out.println(text.getText());
        Thread.sleep(2000);
        //返回元素的属性值，可以是id、name、type或元素拥有其他任意属性
        WebElement ty=driver.findElement(By.id("kw"));
        System.out.println(ty.getAttribute("type"));
        Thread.sleep(2000);

        //返回元素的结果是否可见，返回的结果为True或者False
        WebElement display=driver.findElement(By.id("kw"));
        System.out.println(display.isDisplayed());
        Thread.sleep(2000);
        driver.quit();


    }
    //鼠标操作
    public static void MouseDemo() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");
        WebElement search_setting = driver.findElement(By.linkText("设置"));
        Actions action = new Actions(driver);
        //模拟鼠标悬停操作
        action.clickAndHold(search_setting).perform();
        Thread.sleep(2000);
        //鼠标右键点击指定元素
        action.contextClick(search_setting).perform();
        Thread.sleep(2000);
        //鼠标右键点击指定的元素
        action.doubleClick(driver.findElement(By.linkText("地图"))).perform();
        Thread.sleep(2000);
        action.release().perform();


    }
    //键盘操作
    public static void KeyBord() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");
        WebElement input=driver.findElement(By.id("kw"));
        //输入框输入内容
        input.sendKeys("seleniumm");
        Thread.sleep(2000);
        //删除多输入的一个m
        input.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(2000);
        //输入空格+"教程"
        input.sendKeys(Keys.SPACE);
        input.sendKeys("教程");
        Thread.sleep(2000);
        //全选输入框内容
        input.sendKeys(Keys.COMMAND,"a");
        Thread.sleep(2000);
        //剪切输入框内容
        input.sendKeys(Keys.COMMAND,"x");
        Thread.sleep(2000);
        //粘贴内容到输入框
        input.sendKeys(Keys.COMMAND,"v");
        Thread.sleep(2000);
        //通过回车来代替键盘的操作
        input.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        driver.quit();

    }
    //获得验证信息
    public static void AssertDemo() throws InterruptedException{

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");
        System.out.println("Search before ========");
        //获取当前title和URL
        System.out.printf("title of current page is %s\n",driver.getTitle());
        System.out.printf("url of current url is %s\n",driver.getCurrentUrl());

        //百度搜索
        WebElement search=driver.findElement(By.id("kw"));
        search.sendKeys("Selenium");
        search.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        System.out.println("Search after=========");
        System.out.printf("title of current page is %s\n",driver.getTitle());
        System.out.printf("url of current url is %s\n",driver.getCurrentUrl());

        //获取第一条搜索结果的标题
        WebElement result=driver.findElement(By.xpath("html/head/title"));
        System.out.println(result.getText());
        driver.quit();

    }
    //设置元素等待
    private static boolean isElementPresent(WebDriver driver,By el) {
        try {
        driver.findElement(el);
        return true;
    } catch (NoSuchElementException e) {

        return false;
    }
    }
    public static void TimeOut01() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");
        By el=By.id("kw");
        for (int second=1;second<=10;second++){
            System.out.println(second);
            //调用isElementPresent方法，判断元素是否在
            if(isElementPresent(driver,el)){
                break;
            }else {
                Thread.sleep(1000);
                driver.quit();
            }
            if (second==10){
                System.out.println("timeout");
            }
        }
        driver.findElement(el).sendKeys("selenium");
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);

        driver.quit();
        System.out.println("end Selenium");
    }
    //显示等待方法
//    public static void TimeOut02() throws InterruptedException{
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.baidu.com/");
//        //显示等待，针对某个元素等待
//        WebDriverWait wait=new WebDriverWait(driver,10,1);
//        wait.until(new ExpectedCondition<WebElement>() {
//            @Override
//            public WebElement apply(WebDriver text){
//                return text.findElement(By.id("kw"));
//            }
//        }).sendKeys("selenium");
//        driver.findElement(By.id("su")).click();
//        Thread.sleep(2000);
//        driver.quit();
//    }
    //隐式等待方法
    public static void TimeOut03() throws InterruptedException{
        //页面加载超时设置为5s
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
        driver.get("https://www.baidu.com/");
        Thread.sleep(2000);
        //定位对象时给10s的时间，如果10s内还不定位不到则抛出异常
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.findElement(By.id("kw")).sendKeys("selenium");
        Thread.sleep(2000);
        //异步脚本的超时时间设置成3s
        driver.manage().timeouts().setScriptTimeout(3,TimeUnit.SECONDS);
        Thread.sleep(2000);
        driver.quit();
    }
    //定位一组元素
    public static void ElementDemo()throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");
        WebElement seach_text=driver.findElement(By.id("kw"));
        seach_text.sendKeys("selenium");
        seach_text.submit();
        Thread.sleep(2000);
        //匹配到第一页搜索结果的标题，循环打印
        List<WebElement> seach_result=driver.findElements(By.xpath("//div/div/h3"));
        System.out.println(seach_result.size());
        for (WebElement result : seach_result){
            System.out.println(result.getText());
        }
        System.out.println("-----我是分割线-----");
        WebElement text=seach_result.get(seach_result.size() - 10);
        System.out.println(text.getText());
        driver.quit();;
    }
    //多表单切换
    public static void MailLogin()throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.126.com/");
        WebElement xf = driver.findElement(By.xpath("//*[@id='x-URS-iframe']"));
        driver.switchTo().frame(xf);
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys("username");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("password");
        driver.findElement(By.id("dologin")).click();
        driver.switchTo().defaultContent();
    }
    //多窗口切换***
    public static void MoreWindows() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");
        //获得当前窗口的句柄
        String search_handle=driver.getWindowHandle();
        //打开百度注册窗口
        driver.findElement(By.linkText("登录")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("立即注册")).click();
        //获得所有窗口句柄
        Set<String> handles=driver.getWindowHandles();
        //判断是否是注册窗口，并操作注册窗口上的元素
        for (String handle :handles){
            if (handle.equals(search_handle)==false){
                //切换到注册页面
                driver.switchTo().window(handle);
                System.out.println("no register window!");
                Thread.sleep(2000);
                driver.findElement(By.name("userName")).clear();
                driver.findElement(By.name("userName")).sendKeys("user name");
                driver.findElement(By.name("phone")).clear();
                driver.findElement(By.name("phone")).sendKeys("1589635879");
                Thread.sleep(2000);
                //关闭当前窗口
                driver.close();
            }
        }
        Thread.sleep(2000);
        driver.quit();

    }
    //下拉框处理
    public static void AlertDemo() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");
        driver.findElement(By.linkText("设置")).click();
        driver.findElement(By.linkText("搜索设置")).click();
        Thread.sleep(2000);
        //保存设置
        driver.findElement(By.className("prefpanelgo")).click();
        //接收弹窗
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
        driver.quit();

    }
    //上传文件*** 谷歌和Safari无法运行本地的URL
    public static void UploadFile() throws InterruptedException{
        WebDriver driver = new FirefoxDriver();
//        File file = new File("./HTMLFile/upfile.html");
//        String filePath = file.getAbsolutePath();
        driver.get("http://localhost:63342/MyFirstTest/HTMLFile/upfile.html?_ijt=maoeq488tj06q1k79hhnv2vsdp");
        //定位上传按钮，添加本地文件
        driver.findElement(By.name("file")).sendKeys("/Users/xhm/Desktop/selenium/四、alert，多窗口，下拉框，Wait的处理.docx");
        Thread.sleep(5000);
        driver.quit();

    }
    //下载文件 火狐浏览器
    public static void DownFileFF(){
        FirefoxProfile firefoxProfile=new FirefoxProfile();
        firefoxProfile.setPreference("browser.download.folderList",2);
        firefoxProfile.setPreference("browser.download.dir","/Users/xhm/Desktop/selenium");
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","applaction/octet-stream");
        WebDriver driver =new FirefoxDriver();
        driver.get("http://www.seleniumhq.org/download/");
        driver.findElement(By.partialLinkText("3.4.0")).click();
    }
    //下载文件谷歌浏览器
    public static void DownFileCC(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("profile.default_content_settings.popups=0",
                "download.default_directory=Users/xhm/Desktop/selenium");

        WebDriver driver = new ChromeDriver(options);
        driver.get("http://www.seleniumhq.org/download/");
        driver.findElement(By.partialLinkText("3.4.0")).click();
    }
    //操作cookie
    public static void CookieDemo(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");
        Cookie c1=new Cookie("name","key-aaaaaaa");
        Cookie c2=new Cookie("value","value-bbbbbb");
        //添加浏览器cookie
        driver.manage().addCookie(c1);
        driver.manage().addCookie(c2);
        //获得cookie
        Set<Cookie> coo=driver.manage().getCookies();
        System.out.println(coo);
        //删除所有cookie
        driver.manage().deleteAllCookies();
        Set<Cookie> coo1=driver.manage().getCookies();
        System.out.println(coo1);
        driver.quit();

    }
    //调用JavaScript
    public static void JSDemo() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(700,600));
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).sendKeys("webdriver api");
        driver.findElement(By.id("su")).click();
        Thread.sleep(2000);

        //将页面滚动条拖到底部
        ((JavascriptExecutor)driver).executeScript("window.scrollTo(100,450)");
        Thread.sleep(3000);

        System.out.println("end");
        driver.quit();

    }
    //操作富文本框

    public static void Longtext() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:63342/MyFirstTest/HTMLFile/upfile.html?_ijt=s74s7829qil6fka0k194a8rqmh");
        String text="input text";
        String js="var sum=document.getElementById('id'); sum.value='" + text + "';";
        ((JavascriptExecutor)driver).executeScript(js);
        Thread.sleep(2000);
        //显示隐藏元素
        String js1="document.querySelectorAll('div')[5].style.display='block';";
        ((JavascriptExecutor)driver).executeScript(js1);
        Thread.sleep(2000);
        driver.quit();

    }
    //处理Html5的视频播放
    public static void VideoDemo() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("https://videojs.com/");
        WebElement video=driver.findElement(By.xpath("//body/section/div/video"));
        JavascriptExecutor jse=(JavascriptExecutor)driver;
        //获得视频的URL
        jse.executeScript("return arguments[0].currentSrc;",video);
        //播放视频，播放15s
        jse.executeScript("return arguments[0].play()",video);
        Thread.sleep(15000);
        //暂停视频
        jse.executeScript("arguments[0].pause",video);
        Thread.sleep(2000);
        driver.quit();

    }
    //窗口截图
    public static void GetImg(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://wwww.baidu.com/");
        //截取图片
        File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile,new File("/Users/xhm/Desktop/screenshot.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
        driver.quit();
    }
    //验证码的处理
    public static void VerificationCode(){
        int min=1000;
        int max=9999;
        Random rand=new Random();
        int s=rand.nextInt(max)%(max-min+1)+min;
        String ss=String.valueOf(s);
        System.out.println(ss);

        //创建输入对象
        Scanner sc=new Scanner(System.in);
        //获取用户输入的字符串
        System.out.printf("请输入随机验证码：");
        String str=sc.nextLine();
        if (str.equals(ss)){
            System.out.println("输入正确!");
        }else if(str.equals("Admin@%123")){
            System.out.println("输入正确!");
        }
        else {
            System.out.println("输入错误!");
        }
    }

}

