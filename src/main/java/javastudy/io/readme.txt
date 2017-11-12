字节流的抽象基类：InputStream, OutputStream
字符流的抽象基类：Reader, Writer

字符流的缓冲区：缓冲区的出现提高了对数据的读写效率，
              对应类BufferedReader  BufferedWriter
              缓冲区要结合流才可以使用，在流的基础上对流的功能进行了增强


字符流内部有缓冲区，需要flush。 而字节流不需要flush


1. 明确源和目的。
    源：输入流。InputStream Reader
    目的：输出流。OutputStream Writer
2. 操作的数据是否是纯文本
    是：字符流
    不是：字节流
3. 当体系明确后，再明确要使用哪个具体的对象
    通过设备来进行区分
    源设备：内存，硬盘，键盘
    目的设备：内存，硬盘，控制台
4， 是否需要提高效率

例1：将一个文本中的数据存储到另一个文件中。复制文件。
    源：因为是源，所以使用读取流。InputStream Reader
    是不是操作文本文件，是，这时就可以选择Reader
    接下来要明确使用该体系中的哪个对象。明确设备：硬盘
    Reader体系中可以操作文件的对象是FileReader

    目的：OutputStream Writer
    是否是纯文本， 是， 使用Writer
    设备：硬盘，一个文件。
    Writer体系中可以操作文件的对象FileWriter

例2：将键盘录入的数据保存到一个文件中。
    源：InputStream Reader
    是不是纯文本？是！Reader
    设备：硬盘。对应的对象是System.in
    不是选择Reader吗？System.in对应的不是字节流吗？为了操作键盘的文本数据方便，转成字符流按照字符串操作是最方便的。
    所以既然明确了Reader,那么久将System.in转换成Reader。

    目的：OutputStream Writer
    是否纯文本：是！Writer
    设备：硬盘。文件，使用FileWriter

    扩展一下：想要把录入的数据按照指定的b编码表（utf-8），将数据存入到文件中。
    目的：OutputStream Writer
    是否纯文本：是！Writer
    设备：硬盘。文件，使用FileWriter

    但是要指定编码表，只有转换流可以指定。所以要使用OutputStreamWriter,而该转换流对象需要接收一个字节输出流。所以改用FileOutputStream
    同样的，如果要读取指定编码的文件，就需要使用InputStreamReader，默认的FileReader使用的是默认编码


File类：用来将文件或者文件夹封装成对象。方便对文件与文件夹的属性信息进行操作。   流操作只能操作文件的数据