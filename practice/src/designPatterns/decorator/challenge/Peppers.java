package designPatterns.decorator.challenge;

public class Peppers extends Toppings{
    Pizza pizza;
    Peppers(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription()+", peppers";
    }

    @Override
    public double cost() {
        return pizza.cost()+40;
    }
}
