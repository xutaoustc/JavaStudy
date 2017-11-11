package javastudy.io.b_fileReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopy {
    public static void main(String[]args) throws IOException {
        FileReader fr = null;
        FileWriter fw = null;

        try{
            fr = new FileReader("fileWriterDemo.txt");
            fw = new FileWriter("fileWriterDemo_copy.txt");

            char[] buf = new char[3];

            int num = 0;
            while( (num=fr.read(buf)) != -1 ){
                fw.write(buf,0,num);
                fw.flush();
            }
        }catch(IOException e){
            throw new RuntimeException("读写失败");
        }finally {
            if(fr!=null)
                try{
                    fr.close();
                }catch (IOException e){

                }

            if(fw!=null)
                try{
                    fw.close();
                }catch (IOException e){

                }
        }
    }
}
