package javastudy.io.o_file;

import java.io.File;
import java.io.IOException;

public class RemoveDir {
    public static void main(String[]args) throws IOException {

    }

    public static void removeDir(File dir){
        File[] files = dir.listFiles();

        for(int x=0;x<files.length;x++){
            if(files[x].isDirectory())
                removeDir(files[x]);
            else
                System.out.println(files[x].toString()+"::"+files[x].delete());
        }

        System.out.println(dir + "::dir::" + dir.delete());
    }
}
