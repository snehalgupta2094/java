package designPatterns.observer.simpleApplication;

public class SimpleObserver implements Observer{
    private int value;
    private Subject simpleSubject;

    public SimpleObserver(SimpleSubject simpleSubject){
        this.simpleSubject=simpleSubject;
        //When new Observer class is created register that observer in subject.
       simpleSubject.registerObserver(this);
    }

    @Override
    public void update(int value) {
        this.value=value;
        display();
    }

    public void display() {
        System.out.println("Value: "+value);
    }
}
