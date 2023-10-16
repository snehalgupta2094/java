package concurrency;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ReentrantExample{
    private Lock lock=new ReentrantLock();
    private Condition cond=lock.newCondition();
    private int count=0;

    public void firstThread() throws InterruptedException {

            lock.lock();
            cond.await(); //sleep and release lock let other take it
            System.out.println("Woken up!");
            try{
                increment();
            }finally {
                lock.unlock();
            }
    }

    public void secondThread(){
        lock.lock();
        System.out.println("Press return key!");
        new Scanner(System.in).nextLine();
        System.out.println("Got return key");
        cond.signal(); //notify other so that they can acquire lock
        try{
            increment();
        }finally {
           lock.unlock();
        }
    }
    private void increment() {
        for (int i=0;i<1000;i++){
            count++;
        }
    }
    public void finished(){
        System.out.println("Count: "+count);
    }
}
public class ReentrantLockImpl {
    public static void main(String[] args) throws InterruptedException {
        ReentrantExample example=new ReentrantExample();
        Thread t1=new Thread(()->{
            try {
                example.firstThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2=new Thread(()->{
                example.secondThread();
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        example.finished();

    }
}
