package page.demo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Created by lch on 2017/6/3.
 */
public class searchPage2 {
    WebDriver driver;
    @FindBy(xpath = "//*[@id='kw']")
    @CacheLookup
    WebElement searchInput;

    @FindBy(css="#su")
    @CacheLookup
    WebElement searchButton;
    public  searchPage2(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void inputText(String search){
        searchInput.clear();
        searchInput.sendKeys(search);
    }
    public void clickButton(){
        searchButton.click();
    }
}
