package designPatterns.observer.simpleApplication;

import java.util.ArrayList;

public class SimpleSubject implements Subject{
    private ArrayList<Observer> observers;
    private int value=0;
    public SimpleSubject(){
        this.observers=new ArrayList<>();
    }


    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }

    //Suppose value in subject class changes then notify all observers about update in value
    @Override
    public void notifyObservers() {
        for(Observer observer: observers){
            observer.update(value);
        }
    }

    public void setValue(int value){
        this.value=value;
        notifyObservers();
    }

    public int getValue(){
        return this.value;
    }
}
