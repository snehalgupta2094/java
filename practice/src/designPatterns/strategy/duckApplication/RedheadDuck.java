package designPatterns.strategy.duckApplication;

public class RedheadDuck extends Duck {

    public RedheadDuck(){
        setQuackBehavior(new Mute());
        setFlyBehavior(new FlyWithWings());
    }

    @Override
    void display() {
        System.out.println("I am a real Readhead Duck");
    }
}
