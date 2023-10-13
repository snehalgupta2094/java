package concurrency;


public class ObjectLevelLock {

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        Runner r=new Runner();
        Runner r1=new Runner();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                r.demoMethod();
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                r1.demoMethod();
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
        System.out.println("Total time:"+(System.currentTimeMillis()-startTime));
    }

}
class Runner{
    Object lock=new Object();
    public void demoMethod(){
        synchronized (lock){
            for(int i=0;i<20;i++){
                System.out.println("Thread number: "+Thread.currentThread().getName());
            }
        }
    }
}
