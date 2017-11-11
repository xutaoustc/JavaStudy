package javastudy.weakReference;
import java.lang.ref.ReferenceQueue;



import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;


class Car{
    String name ="a car";
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
//        ReferenceQueue<byte[]> referenceQueue = new ReferenceQueue<byte[]>();

//        Thread thread = new Thread(() -> {
//            try {
//                int cnt = 0;
//                WeakReference<byte[]> k;
//                while((k = (WeakReference) referenceQueue.remove()) != null) {
//                    System.out.println((cnt++) + "回收了:" + k);
//                }
//            } catch(InterruptedException e) {
//                //结束循环
//            }
//        });
//        thread.setDaemon(true);
//        thread.start();
//
//        Object value = new Object();
//        Map<Object, Object> map = new HashMap<>();
//        for(int i = 0;i < 10000;i++) {
//            byte[] bytes = new byte[1024*1024];
//            WeakReference<byte[]> weakReference = new WeakReference<byte[]>(bytes, referenceQueue);
//            map.put(weakReference, value);
//        }
//        System.out.println("map.size->" + map.size());
//
//        Thread.sleep(10000);

        ReferenceQueue<Car> carQueue = new ReferenceQueue<Car>();

        Thread thread = new Thread(() -> {
            try {
                int cnt = 0;
                WeakReference<Car> k;
                while((k = (WeakReference) carQueue.remove()) != null) {
                    System.out.println((cnt++) + "回收了:" + k.get());
                }
            } catch(InterruptedException e) {
                //结束循环
            }
        });
        thread.setDaemon(true);
        thread.start();


        Thread.sleep(1000);


        WeakReference<Car> sr = new WeakReference<Car>(new Car(),carQueue);
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


        Thread.sleep(5000);
    }
}
