package javastudy.io.b_fileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[]args) throws IOException {

    }

    public static void readDemo1() throws IOException {
        FileReader fr = new FileReader("fileWriterDemo.txt");

        while(true){
            int ch1 = fr.read();
            if(ch1==-1)
                break;
            System.out.println("ch1=" + (char)ch1);
        }

        fr.close();
    }

    public static void readDemo2() throws IOException {
        FileReader fr = new FileReader("fileWriterDemo.txt");

        char[] buf = new char[3];

        int num = 0;
        while( (num=fr.read(buf)) != -1 ){
            System.out.println(new String(buf,0,num));
        }


        fr.close();
    }
}
