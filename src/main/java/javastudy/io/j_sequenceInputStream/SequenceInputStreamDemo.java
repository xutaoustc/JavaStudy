package javastudy.io.j_sequenceInputStream;

import java.io.*;
import java.util.Vector;

public class SequenceInputStreamDemo {
    public static void main(String[]args) throws IOException {
        Vector<FileInputStream> vector = new Vector<FileInputStream>();

        vector.add(new FileInputStream("1.txt"));
        vector.add(new FileInputStream("2.txt"));
        vector.add(new FileInputStream("3.txt"));

        SequenceInputStream sis = new SequenceInputStream(vector.elements());
        BufferedReader bufr = new BufferedReader(new InputStreamReader(sis));

        String s = null;
        while((s=bufr.readLine())!=null){
            System.out.println(s);
        }
    }
}
