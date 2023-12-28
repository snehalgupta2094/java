package concurrency;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class BlockingQueueImpl{
    static BlockingQueue<Integer> queue=new ArrayBlockingQueue<>(10);

    public static void produce(){
        Random random=new Random();
        while (true){
            try {
                queue.put(random.nextInt(100));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread: "+Thread.currentThread().getName()+", Queue size: "+queue.size());
        }
    }
    public static void consume(){
        Random random=new Random();
        while (true){
            try {
                Thread.sleep(100);
                if(random.nextInt(10)==0){
                    Integer value= queue.take();
                    System.out.println("Thread: "+Thread.currentThread().getName()+", Taken value: "+value+", Queue size: "+queue.size());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class ProducerConsumerBQ {

    public static void main(String[] args) {
        BlockingQueueImpl q=new BlockingQueueImpl();
        Thread t1=new Thread(()-> q.produce());
        Thread t2=new Thread(()-> q.consume());
        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
