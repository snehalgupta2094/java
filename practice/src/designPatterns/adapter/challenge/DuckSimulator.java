package designPatterns.adapter.challenge;

public class DuckSimulator {
    //Target interface: Turkey
    //Adapter: TurkeyAdapter
    //Adaptee: Duck
    public static void main(String[] args) {
        Drone superDrone=new SuperDrone();
        DroneAdapter droneAdapter=new DroneAdapter(superDrone);
        testDuck(droneAdapter);
    }
    public static void testDuck(Duck duck){
        duck.fly();
        duck.quack();
    }
}
