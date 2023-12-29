package designPatterns.decorator.starbuzz;

public class Soy extends CondimentDecorator{
    Beverage beverage;

    public Soy(Beverage beverage){
        this.beverage=beverage;
    }

    @Override
    public double cost() {
        return beverage.cost()+.15;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription()+", Soy";
    }
}
