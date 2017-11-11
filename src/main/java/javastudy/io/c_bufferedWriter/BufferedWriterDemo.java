package javastudy.io.c_bufferedWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {
    public static void main(String[]args) throws IOException {
        //创建一个流对象
        FileWriter fw = new FileWriter("fileWriterDemo.txt");

        //为了提高字符写入流的效率，加入了缓冲技术。
        //只要将需要被提高效率的流对象作为参数传递给缓冲区的构造函数即可。
        BufferedWriter bufw = new BufferedWriter(fw);
        bufw.write("aaa");
        bufw.newLine(); //跨平台的换行符
        bufw.flush();

        bufw.close();
    }
}
