package javastudy.io.l_pipedStream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;


//管道流需要在多线程环境下执行。
//以前输入流输出流需要一个内存空间做连接，现在使用了管道流以后就不用了。
class Read implements Runnable{
    private PipedInputStream in;

    Read(PipedInputStream in){
        this.in = in;
    }

    public void run(){
        try{
            byte[] buf = new byte[1024];
            System.out.println("读取前。。没有数据阻塞");
            int len = in.read(buf);
            System.out.println("读取数据。。阻塞结束");

            String s = new String(buf,0,len);
            System.out.println(s);
            in.close();
        }catch(IOException e){
            throw new RuntimeException("管道读取流失败");
        }
    }
}

class Write implements Runnable{
    private PipedOutputStream out;

    Write(PipedOutputStream out){
        this.out = out;
    }

    public void run(){
        try{
            out.write("piped lai la".getBytes());
            out.close();
        }catch(IOException e){
            throw new RuntimeException("管道输出流失败");
        }
    }
}

//如果PipedInputStream先执行，那么read将会阻塞。等到PipedOutputStream执行后，因为他们两是相连的，数据将写过去
//
public class PipedStreamDemo {
    public static void main(String[]args) throws IOException {
        PipedInputStream in = new PipedInputStream();
        PipedOutputStream out = new PipedOutputStream();

        in.connect(out);

        Read r = new Read(in);
        Write w = new Write(out);

        new Thread(r).start();
        new Thread(w).start();
    }
}
