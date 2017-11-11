package javastudy.io.f_fileOutputStream_fileInputStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPic {
    public static void main(String[]args) throws IOException {
        FileOutputStream fos = null;
        FileInputStream fis = null;

        try{
            fos = new FileOutputStream("pic_copy.gif");
            fis = new FileInputStream("pic.gif");

            byte[] buf = new byte[1024];
            int len = 0;

            while((len=fis.read(buf))!=-1){
                fos.write(buf,0,len);
            }
        }catch(IOException e){
            throw new RuntimeException("复制文件失败");
        }finally {
            try{
                if(fis!=null)
                    fis.close();
            }catch (Exception e){}

            try{
                if(fos!=null)
                    fos.close();
            }catch (Exception e){}
        }
    }

}
