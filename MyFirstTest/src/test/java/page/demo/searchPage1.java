package page.demo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
/**
 * Created by lch on 2017/6/3.
 */
public class searchPage1 {
    WebDriver driver;

    WebElement wd;
    WebElement su;
    public searchPage1(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void inputText(String search){
        wd.clear();
        wd.sendKeys(search);
    }
    public void clickButton(){
        su.click();
    }
}
