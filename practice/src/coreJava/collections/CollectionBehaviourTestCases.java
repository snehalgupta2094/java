package coreJava.collections;

import java.util.HashSet;
import java.util.TreeSet;

public class CollectionBehaviourTestCases {

    public static void main(String[] args) {
        HashSet<Integer> set=new HashSet<>();
        set.add(null);
        System.out.println(set);
        TreeSet<Integer> treeSet=new TreeSet<>();
        treeSet.add(null);
        System.out.println(treeSet);
    }
}
