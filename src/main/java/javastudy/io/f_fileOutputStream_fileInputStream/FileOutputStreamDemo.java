package javastudy.io.f_fileOutputStream_fileInputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
    public static void main(String[]args) throws IOException {
        readFile_3();
    }

    public static void writeFile() throws IOException{
        FileOutputStream fos = new FileOutputStream("fos.txt");

        fos.write("abcde".getBytes());
//        fos.flush();    不需要刷新

        fos.close();
    }


    public static void readFile_1() throws IOException{
        FileInputStream fis = new FileInputStream("fos.txt");

        int ch = 0;

        while((ch=fis.read())!=-1){
            System.out.println((char)ch);
        }

        fis.close();
    }

    public static void readFile_2() throws IOException{
        FileInputStream fis = new FileInputStream("fos.txt");

        byte[] buf = new byte[1024];
        int len = 0;

        while((len=fis.read(buf))!=-1){
            System.out.println(new String(buf,0,len));
        }

        fis.close();
    }

    public static void readFile_3() throws IOException{
        FileInputStream fis = new FileInputStream("fos.txt");

        byte[] buf = new byte[fis.available()];  //定义一个刚刚好的缓冲区，不用再循环了。但是数据太大的话慎用
        fis.read(buf);

        System.out.println(new String(buf));

        fis.close();
    }
}
