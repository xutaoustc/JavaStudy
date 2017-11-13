package javastudy.io.m_properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

//Properties是hashtable的子类
//它具备map集合的特点，而且它里面存储的键值对都是字符串
//是集合中和IO技术相结合的集合容器。  该对象特点：可以用于键值对形式的配置文件。

public class PropertiesDemo {
    public static void main(String[]args) throws IOException {
        setAndGet();
    }

    public static void setAndGet() throws IOException {
        Properties prop = new Properties();

        prop.setProperty("zhangsan","30");
        prop.setProperty("lisi","40");

        System.out.println(prop);
        System.out.println(prop.getProperty("zhangsan"));

        prop.setProperty("lisi", 89+"");

        Set<String> names =prop.stringPropertyNames();
        for(String s: names){
            System.out.println(s + ":" + prop.getProperty(s));
        }

        Properties prop1 = new Properties();
        prop1.load(new FileInputStream("properties.txt"));

        System.out.println(prop1);

        prop1.setProperty("a","bbb");

        FileOutputStream fos = new FileOutputStream("properties.txt");
        prop1.store(fos,"haha");
    }
}
