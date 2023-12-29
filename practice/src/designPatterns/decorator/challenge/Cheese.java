package designPatterns.decorator.challenge;

public class Cheese extends Toppings{
    Pizza pizza;

    public Cheese(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public double cost() {
        return pizza.cost()+50;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription()+", cheese";
    }
}
