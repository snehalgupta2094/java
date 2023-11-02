package coreJava.collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

class Restaurant{
    int years;
    int totalProducts;
    @Override
    public String toString(){
        return "Years: "+years+" Total no of products: "+totalProducts;
    }
}
public class CollectionBehaviourTestCases {

    public static void main(String[] args) {
        //Hashset can accept null
        HashSet<Integer> set=new HashSet<>();
        set.add(null);
        System.out.println(set);
        //Treeset cannot take null as it cannot perform ordering/sorting on null value
        TreeSet<Integer> treeSet=new TreeSet<>();
        treeSet.add(null);
        System.out.println(treeSet);
        //Testing if variables are assigned values in list of objects after adding it to list will that modify list or not.
        List<Restaurant> restaurants=new ArrayList<>();
        Restaurant restaurant=new Restaurant();
        restaurant.years=3;
        restaurants.add(restaurant);
        for(Restaurant r: restaurants){
            r.totalProducts=9;
        }
        System.out.println(restaurants);
    }
}
