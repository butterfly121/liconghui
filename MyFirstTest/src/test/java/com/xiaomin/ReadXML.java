package com.xiaomin;
import java.io.IOException;
import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;

import org.w3c.dom.NodeList; import org.xml.sax.SAXException;


/**
 * Created by xhm on 2017/5/26.
 */
public class ReadXML {
    public static void main(String[] args) throws ParserConfigurationException,IOException,SAXException {
        File xmlFile=new File("./datafile/info.xml");
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=factory.newDocumentBuilder();
        Document doc=builder.parse(xmlFile);
        //获取元素属性的名字
        NodeList ma=doc.getElementsByTagName("login");
        System.out.println(ma.item(0).getAttributes().getNamedItem("username"));
        System.out.println(ma.item(0).getAttributes().getNamedItem("passwd"));
        //获取标签对之间的数据
        NodeList ma1=doc.getElementsByTagName("caption");
        System.out.println(ma1.item(0).getTextContent());
        System.out.println(ma1.item(1).getTextContent());
        System.out.println(ma1.item(2).getTextContent());


    }
}
