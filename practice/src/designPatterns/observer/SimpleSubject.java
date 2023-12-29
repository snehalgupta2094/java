package designPatterns.observer;

import java.util.ArrayList;

public class SimpleSubject implements Subject{
    private ArrayList<Observer> observers;
    private int value=0;
    public SimpleSubject(){
        this.observers=new ArrayList<Observer>();
    }


    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
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
        return value;
    }
}
