package com.xiaomin;
import org.openqa.selenium.TakesScreenshot;
import  org.sikuli.script.*;
//上传文件
import java.io.File;
import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

/**
 * Created by xhm on 2017/5/26.
 */
public class testSikuli {
    public static void main(String[] args) throws FindFailed, InterruptedException {
//        Screen s = new Screen();
//
//        //定义图片存放路径
//        String imgpath = "/Users/xhm/Desktop//test/";
//
//        //双击桌面 chrome 浏览器图标
//        s.doubleClick(imgpath + "123.png");
//        //输入 url
////        Thread.sleep(2000);
//
//        s.type(imgpath+"456.png","www.bing.com ");
//        Thread.sleep(2000);
//
//        s.click(imgpath+"789.png");
//        Thread.sleep(2000);
//
////        在bing输入搜索关键字并点击搜索按钮
//        s.type(imgpath+"search_input.png","sikuli");
//        Thread.sleep(2000);
//        s.click(imgpath+"search.png");
//        Thread.sleep(2000);
//        //关闭浏览器
//        s.click(imgpath+"close.png");
        FileUpload();

    }
    public static void FileUpload()throws FindFailed, InterruptedException{
        Screen s = new Screen();

        //定义图片存放路径
        String imgpath = "/Users/xhm/Desktop//test/";

        //双击桌面 chrome 浏览器图标
        s.doubleClick(imgpath + "123.png");
        //输入 url
//        Thread.sleep(2000);
        Thread.sleep(2000);

//        在bing输入搜索关键字并点击搜索按钮
        s.click(imgpath+"input.png");
        Thread.sleep(2000);
        s.click(imgpath+"open.png");

    }

}
