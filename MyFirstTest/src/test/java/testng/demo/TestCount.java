package testng.demo;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import module.Count;
/**
 * Created by xhm on 2017/5/31.
 */
public class TestCount {
    @Test
    public void testAdd(){
        int z = new Count().add(3,5);
        assertEquals(z,8);
        System.out.println("hhahahahahhaha333333");
    }
}
