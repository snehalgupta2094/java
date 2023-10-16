package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class ProcessorThreadPool implements Runnable{
    private int id;
    ProcessorThreadPool(int id){
        this.id=id;
    }
    @Override
    public void run(){
        System.out.println("Starting:"+id);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed:"+id);
    }
}
public class ExecutorServiceExample1 {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service= Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++){
            service.submit(new ProcessorThreadPool(i));
        }
       service.shutdown();
        service.awaitTermination(1,TimeUnit.DAYS);

    }
}
