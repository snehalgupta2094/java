package designPatterns.decorator.starbuzz;

public class DarkRoast extends Beverage{

    public DarkRoast(){
        description="Dark roast coffee";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
