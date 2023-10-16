package concurrency;

public class MultiThreadingImpl2 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running");
            }
        });
        System.out.println("Starting");
        t1.start();
        t1.join();
        System.out.println("Completed");
    }
}