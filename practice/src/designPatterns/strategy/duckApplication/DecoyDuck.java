package designPatterns.strategy.duckApplication;

public class DecoyDuck extends Duck {

    public DecoyDuck(){
        setQuackBehavior(new Squeak());
        setFlyBehavior(new FlyWithWings());
    }

    @Override
    void display() {
        System.out.println("I am a real Decoy Duck");
    }
}

