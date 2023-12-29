package designPatterns.observer.simpleApplication;

public class SimpleApplication {

    public static void main(String[] args) {
        SimpleSubject simpleSubject=new SimpleSubject();
        SimpleObserver simpleObserver=new SimpleObserver(simpleSubject);
        simpleSubject.setValue(80);
        simpleObserver.display();

    }
}
