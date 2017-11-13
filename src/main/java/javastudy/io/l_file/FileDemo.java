package javastudy.io.l_file;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[]args) throws IOException {
        method_3();
    }


    public static void consMethod(){
        //将fos.txt封装成对象，可以将已有的和未出现的文件或文件夹封装成对象
        File f = new File("/Users/xutao/project/JavaStudy/fos.txt");

        File f1 = new File("/Users/xutao/project/JavaStudy","fos.txt");

        File f2 = new File(new File("/Users/xutao/project/JavaStudy"),"fos.txt");

        File f3 = new File("/Users"+File.separator+"xutao"+File.separator+
                "project"+File.separator+"JavaStudy"+File.separator+"fos.txt");



        System.out.println(f);
        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
    }

    /*
    * File类常见方法：
    * 1. 创建。 boolean createNewFile():在指定位置创建文件，如果该文件已经存在，则不创建，返回false
    *          boolean mkdir():创建文件夹， 只能创建一级目录
    *          boolean mkdirs():创建多级文件夹
    * 2. 删除。boolean delete(): 删除失败返回false。
    *         void deleteOnExit(): 在程序退出时删除指定文件。
    * 3. 判断。boolean exists() 文件是否存在
    *         boolean isDirectory()   在判断文件对象是否是文件或者目录时，必须先判断文件对象封装的内容是否存在
    *         boolean isFile()    在判断文件对象是否是文件或者目录时，必须先判断文件对象封装的内容是否存在
    * 4. 获取信息。
    *         getName():
    *         getPath():   封装的是什么，输出的就是什么，可能是相对路径
    *         getParent():
    *         getAbsolutePath()
    *         lastModified()
    *         length()
    * */

    public static void method_1() throws IOException {
        File f= new File("file.txt");
        File d = new File("dir");

        System.out.println("create:" + f.createNewFile());
        f.deleteOnExit();
//        System.out.println("delete:"+f.delete());

        d.mkdir();
    }

    public static void method_2() throws IOException {
        File f= new File("file.txt");
        System.out.println("exists:" + f.exists());
    }

    public static void method_3() throws IOException {
        File f= new File("fos.txt");

        System.out.println("path:" + f.getPath());
        System.out.println("abspath:" + f.getAbsolutePath());

        System.out.println("parent:" + f.getParent());  //如果f是相对路径，返回的是相对路径中的父目录。此例中是null
    }
}
