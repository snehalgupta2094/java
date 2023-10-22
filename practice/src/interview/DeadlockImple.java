package interview;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Deadlock{
    Lock lock1=new ReentrantLock();
    Lock lock2=new ReentrantLock();

    public void acquireLock(Lock l1,Lock l2) throws InterruptedException {
        while (true){
            boolean l1Acquired=l1.tryLock();
            boolean l2Acquired=l2.tryLock();
            if(l1Acquired && l2Acquired){
                return;
            }
            if(l1Acquired)
                l1.unlock();
            if(l2Acquired)
                l2.unlock();

            Thread.sleep(1000);
        }
    }
    public void firstThread() throws InterruptedException {
        System.out.println(System.currentTimeMillis()+" "+Thread.currentThread().getName());
         acquireLock(lock1,lock2);
        try{
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);
            }
        }finally {
            lock1.unlock();
            lock2.unlock();
        }
    }
    public void secondThread() throws InterruptedException {
        System.out.println(System.currentTimeMillis()+" "+Thread.currentThread().getName());
        acquireLock(lock2,lock1);
        try{
            Thread.sleep(1);
            for (int i = 0; i < 1000; i++) {
                System.out.println(i);
            }
        }finally{
                lock1.unlock();
                lock2.unlock();
            }
    }
}
public class DeadlockImple {

    public static void main(String[] args) throws InterruptedException {
        Deadlock deadlock=new Deadlock();
    Thread t1=new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                deadlock.firstThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    deadlock.secondThread();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

}
