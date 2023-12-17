package designPatterns.strategy.duckApplication;

public class MallardDuck extends Duck {

    public MallardDuck(){
        setQuackBehavior(new Quack());
        setFlyBehavior(new FlyWithWings());
    }

    @Override
    void display() {
        System.out.println("I am a real Mallard Duck");
    }
}
