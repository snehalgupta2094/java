package designPatterns.singleton;
class ThreadSafeSingleton{
    private static ThreadSafeSingleton instance;
    private ThreadSafeSingleton(){

    }
    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance==null){
            instance=new ThreadSafeSingleton();
        }
        return instance;
    }
}
public class ThreadSafeSingletonImpl {

    public static void main(String[] args) throws InterruptedException {
        final ThreadSafeSingleton[] i = new ThreadSafeSingleton[1];
        final ThreadSafeSingleton[] j = new ThreadSafeSingleton[1];

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                i[0] = ThreadSafeSingleton.getInstance();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                j[0] = ThreadSafeSingleton.getInstance();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(i[0] == j[0]);
    }
}
