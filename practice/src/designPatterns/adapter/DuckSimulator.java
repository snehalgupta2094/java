package designPatterns.adapter;

public class DuckSimulator {
    //Target interface: Turkey
    //Adapter: TurkeyAdapter
    //Adaptee: Duck interface
    public static void main(String[] args) {
        Duck mallardDuck=new MallardDuck();
        testDuck(mallardDuck);
        Turkey wildTurkey=new WildTurkey();
        Duck turkeyAdapter=new TurkeyAdapter(wildTurkey);
        testDuck(turkeyAdapter);
    }
    public static void testDuck(Duck duck){
        duck.fly();
        duck.quack();
    }
}
