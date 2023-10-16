package concurrency;

import java.util.LinkedList;

class Processor{
    LinkedList<Integer> list=new LinkedList<>();
    int LIMIT=10;

    Object lock=new Object();

    public void produce() throws InterruptedException {
        int value=0;
        while (true){
            synchronized (lock){
                while (list.size()==LIMIT){
                    lock.wait();
                }
                list.add(value++);
                lock.notify();
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true){
            synchronized (lock){
                while (list.size()==0){
                  lock.wait();
                }
                int value=list.removeFirst();
                System.out.println("List size: "+list.size()+", removed value: "+value);
                lock.notify();
                System.out.println("Sleeping in consumer");
                Thread.sleep(1000);
            }
        }
    }

}
public class ProducerConsumerBasic {

    public static void main(String[] args) {
        Processor p=new Processor();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
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
