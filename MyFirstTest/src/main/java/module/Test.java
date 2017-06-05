package module;

import module.Count;

/**
 * Created by xhm on 2017/5/27.
 */
public class Test {
    public static void main(String args[]) { //向 add 类传递两个参数 3 和 5

        int result = new Count().add(3, 5); //判断返回结果是否等于 8

        if (result == 8) {
            System.out.println("pass!");

        } else {
            System.out.println("failed!");
        }


    }
}
