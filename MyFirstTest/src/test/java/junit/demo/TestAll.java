package junit.demo;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/**
 * Created by xhm on 2017/5/31.
 */
@RunWith(Suite.class)
@SuiteClasses({
        TestCount.class,
        TestLevel.class,
        assertMethod.class
})
public class TestAll {
}
