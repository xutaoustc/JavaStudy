package javastudy.weakReference;
import java.lang.ref.WeakReference;


class Car{

}

public class WeakReferenceTest {
    private static class WeakReferenceChild<K,V> extends WeakReference<K>{
        V value;

        WeakReferenceChild(K key ,V value){
            super(key);
            this.value = value;
        }
    }

    public static void main(String[]args) throws Exception{
        WeakReference<Car> sr = new WeakReference<Car>(new Car());
        System.out.println(sr.get());
        for(int i=0;i<100000;i++){
            int[] a = new int[10000];
        }
        System.out.println(sr.get());


        WeakReferenceChild<Car,String> weakReferenceChild = new WeakReferenceChild<Car, String>(new Car(),"Str");
        System.out.println(weakReferenceChild.get());
        System.out.println(weakReferenceChild.value);
        for(int i=0;i<100000;i++){
            int[] a = new int[10000];
        }
        System.out.println(weakReferenceChild.get());
        System.out.println(weakReferenceChild.value);

    }
}
