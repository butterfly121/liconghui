package page.demo;
import org.openqa.selenium.*;

/**
 * Created by lch on 2017/6/3.
 */
public class LoginPage {
    public static class getElement{
        public static final String TITLE="126 网易免费邮--你的专业电子邮局";
        // 通过 XPATH 获取页面元素
        public static final String IFRAME_XPATH = "//*[@id='loginDiv']/iframe";
        public static final String USERNAME_NAME = "email";
        public static final String PASSWORD_NAME = "password";
        public static final String LOGIN_BUTTON_ID = "dologin";
        //登录成功的用户名
        public static final String LOGIN_SUCCESS_TEXT_ID = "spnUid";


    }
    private WebDriver driver;
    //登录页面URL
    private String url;
    //  声明对象，自动加载页面
    public LoginPage(WebDriver driver, String url){
        this.driver=driver;
        this.url=url;
        //加载页面
        this.driver.get(this.url);

    }
    //获取页面标题
    public String getTitle(){
        return this.driver.getTitle();
    }
    //检查页面是否加载，判断title是否相等，返回T/F
    public boolean isLoaded(){
        System.out.println(this.getTitle());
        return LoginPage.getElement.TITLE.endsWith(this.getTitle());
    }
    //表单的进入
    public void login_iframe(){
        WebElement xf=this.driver.findElement(By.xpath(LoginPage.getElement.IFRAME_XPATH));
        this.driver.switchTo().frame(xf);
    }
    //表单的退出
    public void login_iframe_out(){
        this.driver.switchTo().defaultContent();
    }
    //登录用户名输入框
    public void login_username(String username){
        WebElement el=this.driver.findElement(By.name(getElement.USERNAME_NAME));
        el.clear();;
        el.sendKeys(username);
    }
    //登录密码输入框
    public void  login_password(String password){
        WebElement el=this.driver.findElement(By.name(getElement.PASSWORD_NAME));
        el.clear();
        el.sendKeys(password);
    }
    //登录按钮
    public void login_button(){
        this.driver.findElement(By.id((getElement.LOGIN_BUTTON_ID))).click();
    }
   //登录方法
    public void login(String username,String password){
        login_iframe();
        login_username(username);
        login_password(password);
        login_button();
        login_iframe_out();
    }
    //返回成功之后的用户名
    public String user(){
        String text = this.driver.findElement(By.id(getElement.LOGIN_SUCCESS_TEXT_ID)).getText();
        System.out.println(text);
        return text;
    }

}
