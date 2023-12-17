package designPatterns.strategy.duckApplication;

public class DecoyDuck extends Duck {

    public DecoyDuck(){
        quackBehaviour=new Squeak();
        flyBehaviour=new FlyWithWings();
    }

    @Override
    void display() {
        System.out.println("I am a real Decoy Duck");
    }
}

