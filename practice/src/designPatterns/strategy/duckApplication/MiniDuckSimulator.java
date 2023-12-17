package designPatterns.strategy.duckApplication;

public class MiniDuckSimulator {

    public static void main(String[] args) {
        Duck duck=new MallardDuck();
        duck.display();
        duck.performFly();
        duck.performQuack();
        System.out.println("-----------------");
        duck=new RubberDuck();
        duck.display();
        duck.performFly();
        duck.performQuack();
        System.out.println("-----------------");
        duck=new RedheadDuck();
        duck.display();
        duck.performFly();
        duck.performQuack();
        System.out.println("-----------------");
        duck=new DecoyDuck();
        duck.display();
        duck.performFly();
        duck.performQuack();
        System.out.println("-----------------");
    }
}
