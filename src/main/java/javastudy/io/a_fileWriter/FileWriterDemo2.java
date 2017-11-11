package javastudy.io.a_fileWriter;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterDemo2 {
    public static void main(String[]args) throws IOException {
        //标准的IO流处理异常流程
        FileWriter fw = null;

        try {
            fw = new FileWriter("fileWriterDemo.txt");

            fw.write("abcdefg");
        }catch (IOException e){
            System.out.println(e.toString());
        }finally {
            try {
                if(fw!=null)
                    fw.close();
            }catch (IOException e){
                System.out.println(e.toString());
            }
        }
    }
}
