package coreJava.collections;

import java.util.ConcurrentModificationException;
import java.util.concurrent.ConcurrentHashMap;

public class CustomHashMap {

    public static void main(String[] args) {
        ConcurrentHashMap<String,String> c=new ConcurrentHashMap();
        c.get("");
    }
}
