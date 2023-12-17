package designPatterns.strategy.duckApplication;

public abstract class Duck {
    FlyBehaviour flyBehaviour;
    QuackBehaviour quackBehaviour;
    public Duck(){}
    abstract void display();
    public void performFly(){
        flyBehaviour.fly();
    }
    public void setFlyBehavior(FlyBehaviour fb) {
        flyBehaviour = fb;
    }

    public void setQuackBehavior(QuackBehaviour qb) {
        quackBehaviour = qb;
    }
    public void performQuack(){
        quackBehaviour.quack();
    }
    public void swim(){
        System.out.println("All ducks can float, even decoy!");
    }
}
