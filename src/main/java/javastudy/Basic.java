package javastudy;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.MessageFormat;

public class Basic {
    public static void main(String[]args) throws Exception{
        //MessageFormat
        System.out.println(  MessageFormat.format("hello {0}", "徐涛")  );

        //获取Resource文件
        InputStream inputStream = Basic.class.getResourceAsStream("/" + "test.xml");
        Reader reader = new InputStreamReader(inputStream);
        System.out.println((char)reader.read());

        //System.getProperty(“name”)
        // java -Dname=zhuhui
        System.out.println( System.getProperty("name") );
    }
}
