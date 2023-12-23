package designPatterns.adapter.challenge;

public class MallardDuck implements Duck {

    @Override
    public void quack() {
        System.out.println("Duck quacks!");
    }

    @Override
    public void fly() {
        System.out.println("Duck flys!");
    }
}
