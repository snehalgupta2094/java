package designPatterns.strategy.duckApplication;

public class MallardDuck extends Duck {

    public MallardDuck(){
        quackBehaviour=new Quack();
        flyBehaviour=new FlyWithWings();
    }

    @Override
    void display() {
        System.out.println("I am a real Mallard Duck");
    }
}
