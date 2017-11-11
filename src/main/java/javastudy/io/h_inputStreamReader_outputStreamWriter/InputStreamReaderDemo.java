package javastudy.io.h_inputStreamReader_outputStreamWriter;

import java.io.*;

public class InputStreamReaderDemo {
    public static void main(String[]args) throws IOException {
        //要定义结束标记over,如果用System.in来处理，则比较麻烦，需要接收并解析，我们希望能用readLine方法，但是这个方法是在BufferedRead里面的
        //因此需要定义一个转换流
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));  //为了能使用readLine方法， 非常重要
//        BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("fileWriterDemo.txt")));  //为了能使用readLine方法， 非常重要

//        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));   //为了能使用换行
        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("fos.txt"),"UTF-8"));   //为了能使用换行


        String line = null;
        while((line=bufr.readLine())!=null){
            if("over".equals(line))
                break;
            bufw.write(line.toUpperCase());
            bufw.newLine();
            bufw.flush();
        }

        bufr.close();
        bufw.close();
    }
}
