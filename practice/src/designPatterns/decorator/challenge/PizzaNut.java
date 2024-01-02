package designPatterns.decorator.challenge;

public class PizzaNut {

    public static void main(String[] args) {
        Pizza pizza=new ThickCrustPizza();
        pizza=new Cheese(pizza);
        pizza=new Olives(pizza);
        System.out.println(pizza.getDescription()
                           + " $" + pizza.cost());

        Pizza pizza1=new ThickCrustPizza();
        pizza1=new Peppers(pizza1);
        pizza1=new Olives(pizza1);
        pizza1=new Cheese(pizza1);
        System.out.println(pizza1.getDescription()
                           + " $" + pizza1.cost());

        String s="kjhsiuhaaaaa";
        String key=s.substring(7 - 3, 7);
        System.out.println(key);
    }
}
