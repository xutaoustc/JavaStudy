package javastudy.io.k_objectInputStream_objectOutputStream;


import java.io.*;

public class ObjectStreamDemo {
    public static void main(String[]args) throws IOException, ClassNotFoundException {
//        writeObj();
        readObj();
    }

    public static void writeObj() throws IOException {
        //将对象输出到一个输出流当中
        ObjectOutputStream oos = new ObjectOutputStream( new FileOutputStream("serialize.obj"));

        oos.writeObject(new Person("lisi",39));
    }

    public static Object readObj() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream( new FileInputStream("serialize.obj") );

        Person p = (Person)ois.readObject();

        System.out.println(p);
        ois.close();
        return p;
    }
}

//静态成员不能被序列化
//serialVersionUID是用来手工指定版本，如果没有指定，JVM会自己使用一个
class Person implements Serializable{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
