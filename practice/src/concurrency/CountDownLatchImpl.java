package concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ProcessorImp implements Runnable{
    CountDownLatch latch;
    ProcessorImp(CountDownLatch latch)
    {
        this.latch=latch;
    }

    @Override
    public void run() {
        System.out.println("Started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed!");
        latch.countDown();
    }
}
public class CountDownLatchImpl {

    public static void main(String[] args) {
        CountDownLatch latch=new CountDownLatch(3);
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for(int i=0;i<3;i++){
            executor.submit(new ProcessorImp(latch));
        }
        executor.shutdown();
    }

}
