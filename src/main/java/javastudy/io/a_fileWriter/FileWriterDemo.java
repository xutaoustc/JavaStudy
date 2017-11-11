package javastudy.io.a_fileWriter;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo {
    public static void main(String[]args) throws IOException {
        //默认会创建文件，如果有同名文件，则覆盖
        FileWriter fw = new FileWriter("fileWriterDemo.txt");

        fw.write("abcde");
        fw.flush();

        fw.close();
    }
}
