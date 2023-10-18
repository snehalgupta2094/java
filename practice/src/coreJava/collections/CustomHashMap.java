package coreJava.collections;

import java.util.Objects;

class Entry<K,V>{
    K key;
    V value;
    Entry<K,V> next;
    Entry(K key, V value, Entry next){
        this.key=key;
        this.value=value;
        this.next=next;
    }
}
class CustomHashMapImpl<K,V>{
    Entry<K,V> map[];
    int capacity=10000;
    CustomHashMapImpl(){
        this.map=new Entry[capacity];
    }
    public V get(K key){
        int index=hash(key);
        Entry<K,V> current=map[index];
       while (current!=null){
           if(current.key.equals(key)){
               return current.value;
           }
           current=current.next;
       }
        return null;
    }
    public void put(K key, V value){
        int index=hash(key);
        Entry<K,V> current=map[index];
        Entry<K,V> newNode=new Entry<>(key,value,null);
        if(current==null){
            map[index]=newNode;
            return;
        }
        else{
            Entry<K,V> prev=null;
            while(current!=null){
                System.out.println(current.key.equals(key));
                if(current.key.equals(key)){
                    current.value=value;
                    break;
                }
                prev=current;
                current=current.next;
            }
            if(prev!=null)
                prev.next=newNode;
        }
    }
    public int hash(K key){
        return Objects.hash(key)%capacity;
    }
}
public class CustomHashMap {
    public static void main(String[] args) {
        CustomHashMapImpl<Integer,String> map=new CustomHashMapImpl<>();
        map.put(1,"abc");
        map.put(2,"pqr");
        map.put(3,"lmn");
        System.out.println(map.get(1));
        System.out.println(map.get(2));
        System.out.println(map.get(3));
        map.put(3,"pou");
        System.out.println(map.get(3));
    }
}
