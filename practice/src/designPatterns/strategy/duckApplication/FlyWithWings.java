package designPatterns.strategy.duckApplication;

public class FlyWithWings implements FlyBehaviour{

    @Override
    public void fly() {
        System.out.println("I can fly!!");
    }
}
