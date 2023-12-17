package designPatterns.strategy.duckApplication;

public class Quack implements QuackBehaviour{

    @Override
    public void quack() {
        System.out.println("I can quack");
    }
}
