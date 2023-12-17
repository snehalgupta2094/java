package designPatterns.strategy.duckApplication;

public class Squeak implements QuackBehaviour{

    @Override
    public void quack() {
        System.out.println("I can squeak");
    }
}
