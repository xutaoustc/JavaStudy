package javastudy.io.l_file;

import java.io.File;
import java.io.IOException;


//递归打印目录
public class FileDemo3 {
    public static void main(String[]args) throws IOException {
        showDir(new File("/Users/xutao/project/JavaStudy"),0);
    }

    public static String getLevel(int level){
        StringBuilder sb = new StringBuilder();
        for(int x=0;x<level;x++){
            sb.append("|--");
        }
        return sb.toString();
    }

    public static void showDir(File dir, int level){
        System.out.println(getLevel(level) + dir);
        level++;

        File[] files = dir.listFiles();
        for(int x=0;x<files.length;x++){
            if(files[x].isDirectory())
                showDir(files[x],level);
            else
                System.out.println(files[x]);
        }
    }
}
