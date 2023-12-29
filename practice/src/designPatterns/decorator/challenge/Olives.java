package designPatterns.decorator.challenge;

public class Olives extends Toppings{
    Pizza pizza;

    Olives(Pizza pizza){
        this.pizza=pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription()+", olives";
    }

    @Override
    public double cost() {
        return pizza.cost()+25;
    }
}
