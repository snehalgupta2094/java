package concurrency;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TryLockImpl{
    Account acc1=new Account();
    Account acc2=new Account();

    private Lock lock1=new ReentrantLock();
    private Lock lock2=new ReentrantLock();
    public void firstThread() throws InterruptedException {
        Random r=new Random();

        for(int i=0;i<10000;i++){
            acquireLock(lock1,lock2);
            try {
                Account.transfer(acc1, acc2, r.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }
    public void secondThread() throws InterruptedException {
        Random r=new Random();
        for(int i=0;i<10000;i++){
            acquireLock(lock2,lock1);
            try{
                Account.transfer(acc2,acc1, r.nextInt(100));
            } finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }
    public void getBalance(){
        System.out.println("Account 1="+acc1.getBalance());
        System.out.println("Account 2="+acc2.getBalance());
        System.out.println("Total="+(acc1.getBalance()+acc2.getBalance()));
    }
    public void acquireLock(Lock lock1, Lock lock2) throws InterruptedException {
        while (true){
            boolean getFirstLock=lock1.tryLock();
            boolean getSecondLock=lock2.tryLock();
            if(getFirstLock && getSecondLock)
                return;
            if(getFirstLock)
                lock1.unlock();
            if(getSecondLock)
                lock2.unlock();
            System.out.println("Sleeping for 1ms");
            Thread.sleep(1);
        }
    }
}
public class TryLock {

    public static void main(String[] args) throws InterruptedException {
        TryLockImpl p=new TryLockImpl();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.firstThread();
                } catch (InterruptedException e) {
                    System.out.println(e.getCause());
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.secondThread();
                } catch (InterruptedException e) {
                    System.out.println(e.getCause());
                }
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        p.getBalance();
    }
}
