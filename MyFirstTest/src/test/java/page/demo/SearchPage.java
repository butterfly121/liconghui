package page.demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
/**
 * Created by xhm on 2017/6/1.
 */
public class SearchPage {
    //百度搜索框
    public static void input(WebDriver driver,String search_key){
        driver.findElement(By.xpath("//*[@id='kw']")).sendKeys(search_key);
    }
    //百度搜索按钮
    public static void button(WebDriver driver) {

        driver.findElement(By.id("su")).click();
    }
}
