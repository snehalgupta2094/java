package concurrency;

public class ClassLevelLock {

    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        RunnerStatic r=new RunnerStatic();
        RunnerStatic r1=new RunnerStatic();
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                r.demoMethod();//RunnerStatic.demoMethod();
            }
        });
        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                r1.demoMethod(); //RunnerStatic.demoMethod();
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
class RunnerStatic {

    public static void demoMethod() {
        synchronized (RunnerStatic.class) {
            for (int i = 0; i < 20; i++) {
                System.out.println("Thread number: " + Thread.currentThread().getName());
            }
        }
    }
}