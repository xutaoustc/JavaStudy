package javastudy.io.i_printStream_printWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

//PrintStream
//构造函数可以接收的参数类型：
//1.File对象
//2.字符串路径
//3.字节输出流

//PrintWriter
//构造函数可以接收的参数类型：
//1.File对象
//2.字符串路径
//3.字节输出流
//4.字符输出流

//很重要，使用起来很方便

public class PrintStreamDemo {
    public static void main(String[]args) throws IOException{
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        String line = null;

        while((line=bufr.readLine())!=null){
            if("over".equals(line))
                break;
            out.println(line.toUpperCase());
            out.flush();
        }

        out.close();
        bufr.close();
    }
}
