package coreJava.collections;

import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class CustomCustomHashMapImpl<K,V>{
    Entry<K,V> map[];
    Lock locks[];
    int capacity=10000;
    CustomCustomHashMapImpl(){
        this.map=new Entry[capacity];
        this.locks=new Lock[capacity];
        for(int i=0;i<locks.length;i++){
            locks[i]=new ReentrantLock();
        }
    }
    public V get(K key){
        int index=hash(key);

        Lock lock=locks[index];
        lock.lock();
        try {
            Entry<K, V> current = map[index];
            while (current != null) {
                if (current.key.equals(key)) {
                    return current.value;
                }
                current = current.next;
            }
            return null;
        }finally {
            lock.unlock();
        }
    }
    public void put(K key, V value){
        System.out.println(System.currentTimeMillis()+" "+Thread.currentThread().getName());
        int index=hash(key);
        Entry<K,V> current=map[index];
        Entry<K,V> newNode=new Entry<>(key,value,null);

        Lock lock=locks[index];
        lock.lock();
        try {
            if (current == null) {
                map[index] = newNode;
                return;
            } else {
                Entry<K, V> prev = null;
                while (current != null) {
                    if (current.key.equals(key)) {
                        current.value = value;
                        break;
                    }
                    prev = current;
                    current = current.next;
                }
                if (prev != null)
                    prev.next = newNode;
            }
        }finally {
            lock.unlock();
        }
    }
    public int hash(K key){
        return Objects.hash(key) % capacity;
    }
}
public class CustomConcurrentHashMap {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CustomCustomHashMapImpl<Integer,String> map=new CustomCustomHashMapImpl<>();
        ExecutorService service= Executors.newFixedThreadPool(3);
        Future f1=service.submit(()->{
            map.put(1,"abc");
        });
        Future f2=service.submit(()->{
            map.put(2,"pqr");
        });
        Future f3=service.submit(()->{
            map.put(2,"lmn");
        });
        f1.get();
        f2.get();
        f3.get();
        System.out.println("f1:"+map.get(1));
        System.out.println("f3:"+map.get(2));
        service.shutdown();
        service.awaitTermination(1, TimeUnit.DAYS);
    }
}