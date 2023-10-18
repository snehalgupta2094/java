package designPatterns.singleton;
class DoubleLock{
    private static DoubleLock instance;
    private DoubleLock(){

    }
    public static DoubleLock getInstance(){
        if(instance==null){
            synchronized (DoubleLock.class) {
                if(instance==null){
                    instance = new DoubleLock();
                }
            }
        }
        return instance;
    }
}
public class DoubleLockImpl {

    public static void main(String[] args) {
        // Create multiple threads that attempt to access the singleton
        Thread[] threads = new Thread[5];

        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(() -> {
                DoubleLock instance = DoubleLock.getInstance();
                System.out.println("Instance hash code: " + instance.hashCode());
            });
        }

        // Start the threads
        for (Thread thread : threads) {
            thread.start();
        }

        // Wait for all threads to complete
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

