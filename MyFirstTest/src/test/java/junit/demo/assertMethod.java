package junit.demo;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by xhm on 2017/5/31.
 */
public class assertMethod {
    public static Boolean Prime(int n){
        for (int i=2;i<Math.sqrt(n);i++){
            if (n%i==0)
                return false;
        }
        return true;
    }
    @Test
    public void testTrue(){
        int n=8;
        assertFalse(assertMethod.Prime(n));
    }
    @Test
    public void testEquals(){
        int number = 10;
        assertEquals(number,10);
        assertNotEquals(number,101);
    }
}
