package concurrency;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Processing{
    private Account acc1=new Account();
    private Account acc2=new Account();

    private Lock lock1=new ReentrantLock();
    private Lock lock2=new ReentrantLock();
    public void firstThread(){
        Random r=new Random();

        for(int i=0;i<10000;i++){
            lock1.lock();
            lock2.lock();
            try{
                Account.transfer(acc1,acc2, r.nextInt(100));
            }finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }
    public void secondThread(){
        Random r=new Random();

        for(int i=0;i<10000;i++){
            lock1.lock();
            lock2.lock();
            try{
                Account.transfer(acc2,acc1, r.nextInt(100));
            }finally {
                lock1.unlock();
                lock2.unlock();
            }
        }
    }
}
