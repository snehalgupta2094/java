package LLD;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {
    LinkedHashMap<Integer,Integer> cache;
    int capacity;
    LRUCache(int capacity){
        cache=new LinkedHashMap<Integer,Integer>();
        this.capacity=capacity;
    }
    public void put(int key, int value){
        cache.put(key, value);
        if (cache.size() > capacity) {
            // Remove the least recently used entry
            cache.remove(cache.entrySet().iterator().next().getKey());
        }
    }
    public int get(int key){
        return cache.getOrDefault(key, -1);
    }
}
public class LRU {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // Should print 1
        cache.put(3, 3); // This should remove 2
        System.out.println(cache.get(2)); // Should print -1 (as 2 was removed)
        cache.put(4, 4);
        System.out.println(cache.get(1)); // Should print -1 (as 1 was removed)
        System.out.println(cache.get(3)); // Should print 3
    }
}
