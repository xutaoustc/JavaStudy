package javastudy.io.n_basicTypeStream;

import java.io.*;

public class DataStreamDemo {
    public static void main(String[]args) throws IOException {
//        writeData();
        readData();
    }

    public static void writeData() throws IOException {
        //类似于ObjectOutputStream， 也需要绑定一个输出流。把基本数据类型和流相结合
        DataOutputStream dos = new DataOutputStream( new FileOutputStream("data.txt"));

        dos.writeInt(234);
        dos.writeBoolean(true);
        dos.writeDouble(9887.543);

        dos.close();
    }

    public static void readData() throws IOException {
        DataInputStream dis = new DataInputStream( new FileInputStream("data.txt") );

        int num = dis.readInt();
        boolean b = dis.readBoolean();
        double d = dis.readDouble();

        System.out.println("num=" + num);
        System.out.println("b=" + b);
        System.out.println("d="+d);
    }

    //ByteArrayInputStream:  在构造的时候，需要接收数据源，而且数据源是一个字节数组。
    //ByteArrayOutputStream: 在构造的时候，不用定义数据目的，因为该对象中已经内部封装了可变长度的字节数组
    //CharArrayReader CharArrayWriter  StringReader StringWriter 类似于ByteArrayInputStream, ByteArrayOutputStream
    //因为这两个流对象都操作数组，并没有使用系统资源。所以不用close关闭
    //用流的读写思想来操作数组。
    public static void byteArrayStream(){
        ByteArrayInputStream bis = new ByteArrayInputStream("ABCDEFG".getBytes());

        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        int by =0;
        while((by=bis.read())!=-1){
            bos.write(by);
        }

        System.out.println(bos.size());
    }

}
