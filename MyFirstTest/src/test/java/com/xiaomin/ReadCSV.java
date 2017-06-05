package com.xiaomin;

import java.io.IOException;
import  java.nio.charset.Charset;
import com.csvreader.CsvReader;
/**
 * Created by xhm on 2017/5/26.
 */
public class ReadCSV {
    public static void main(String[] args) throws InterruptedException,IOException{
        String filePath="./datafile/info.csv";
        CsvReader reader=new CsvReader(filePath,',',Charset.forName("GBK"));
        reader.readHeaders();

        while (reader.readRecord()){
            //读取一条记录
            System.out.println(reader.getRawRecord());
            System.out.println("======");
            //按列名读取这条记录的值
            System.out.println(reader.get("Name"));
            System.out.println(reader.get("Password"));
            System.out.println("======");
        }
    }
}
