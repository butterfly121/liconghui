package junit.demo;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.After;
import org.junit.Ignore;
import static org.junit.Assert.*;
import module.Count;
/**
 * Created by xhm on 2017/5/31.
 */
public class TestLevel {
    @BeforeClass//所有方法运行之前运行。
    public static void beforeClass(){
        System.out.println("==========beforeClass");
    }
    @AfterClass//在所有的方法运行之后运行
    public static void afterClass(){
        System.out.println("==========afterClass");
    }
    @Before//每个测试方法运行之前运行
    public void before(){
        System.out.println("==========before");
    }
    @After//每个测试方法运行之后运行
    public void after(){
        System.out.println("==========after");
    }
    @Test
    public void testAdd(){
        int z=new Count().add(5,3);
        assertEquals(8,z);
        System.out.println("test Run through");
    }
    //用来知识期望抛出的异常类型
    @Test(expected = java.lang.AssertionError.class)
    public void testAdd2(){
        int z=new Count().add(5,3);
        assertEquals(z,9);
    }
    //timeout表示要求方法在100毫秒内运行完成，否则报错
    @Test(timeout = 100)
    public void testDivision(){
        System.out.println("in Test Division");
    }
    @Ignore //跳过测试
    @Test
    public void testSkip(){
        System.out.println("skip");
    }
}
