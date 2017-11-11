package javastudy.io.g_bufferedOutputStream;

import java.io.*;

public class CopyPic {
    public static void main(String[]args) throws IOException {
        BufferedOutputStream fos = null;
        BufferedInputStream fis = null;


        fos = new BufferedOutputStream(new FileOutputStream("pic_copy.gif"));
        fis = new BufferedInputStream(new FileInputStream("pic.gif"));

        int by = 0;
        while((by=fis.read())!=-1){  //之所以返回int，而不返回byte类型，是因为防止byte是11111111造成提前终止
            fos.write(by);
        }

        fos.close();
        fis.close();
    }
    
}
