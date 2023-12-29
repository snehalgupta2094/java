package designPatterns.decorator.challenge;

public class ThickCrustPizza extends Pizza{
    public ThickCrustPizza(){
        description=" Thick crust pizza";
    }
    @Override
    public double cost() {
        return 100;
    }
}
