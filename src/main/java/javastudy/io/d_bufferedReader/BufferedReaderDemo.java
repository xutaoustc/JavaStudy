package javastudy.io.d_bufferedReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {
    public static void main(String[]args) throws IOException {
        FileReader fr = new FileReader("fileWriterDemo.txt");

        //该缓冲区提供了一次读一行的方法
        BufferedReader bufr = new BufferedReader(fr);

        String line = null;
        while((line=bufr.readLine())!=null){
            System.out.println(line);
        }

        bufr.close();
    }
}
