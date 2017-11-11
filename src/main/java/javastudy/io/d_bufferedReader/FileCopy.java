package javastudy.io.d_bufferedReader;

import java.io.*;


//通过缓冲区复制文本
public class FileCopy {
    public static void main(String[]args) throws IOException {
        BufferedReader fr = null;
        BufferedWriter fw = null;

        try{
            fr = new BufferedReader( new FileReader("fileWriterDemo.txt") );
            fw = new BufferedWriter( new FileWriter("fileWriterDemo_copy.txt") );

            String line = null;
            //readLine方法不返回回车符
            while( (line=fr.readLine()) != null ){
                fw.write(line);
                fw.newLine();
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
