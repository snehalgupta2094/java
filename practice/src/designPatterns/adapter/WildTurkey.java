package designPatterns.adapter;

public class WildTurkey implements Turkey{

    @Override
    public void gobble() {
        System.out.println("Gobble turkey!");
    }

    @Override
    public void fly() {
        System.out.println("Fly turkey!");
    }
}
