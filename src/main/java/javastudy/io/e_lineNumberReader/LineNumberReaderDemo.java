package javastudy.io.e_lineNumberReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumberReaderDemo {
    public static void main(String[]args) throws IOException {
        FileReader fr = new FileReader("fileWriterDemo.txt");

        //带行号
        LineNumberReader bufr = new LineNumberReader(fr);

        String line = null;
        while((line=bufr.readLine())!=null){
            System.out.println(bufr.getLineNumber() + ":" + line);
        }

        bufr.close();
    }
}
