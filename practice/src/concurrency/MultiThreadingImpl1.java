package concurrency;
class RunnerThread extends Thread{
    @Override
    public void run(){
        System.out.println("Running");
    }
}
public class MultiThreadingImpl1 {

    public static void main(String[] args) throws InterruptedException {
        RunnerThread t=new RunnerThread();
        t.start();
        System.out.println("Starting");
        t.join();
        System.out.println("completed!");
    }
}
