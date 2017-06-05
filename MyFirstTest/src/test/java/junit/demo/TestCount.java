package junit.demo;

import org.junit.Test;
import static org.junit.Assert.*;
import module.Count;
/**
 * Created by xhm on 2017/5/27.
 */
public class TestCount {
    @Test
    public void testAdd() {
        int z = new Count().add(3, 5);
        assertEquals(z, 8);
        //错误类型
//        int a = 8/0;//程序本身错误
        //测试失败
//        int z = new Count().add(3, 5);
//        assertEquals(z, 9);


    }
}
