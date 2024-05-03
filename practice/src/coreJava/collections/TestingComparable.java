package coreJava.collections;

public class TestingComparable {

    public static void main(String[] args) {
        TestingComparable c = new TestingComparable();
        Integer value1 = 112121212;
        Integer value2 = 112121212;
        System.out.println("Value = "+c.compareValues(value1, value2));

    }
     <V extends Comparable<V>>  int compareValues(V value1, V value2) {
         if (value1 == value2) {
             System.out.println("yahan pe aaya mai");
             return 0;
         }
         if (value1 == null) {
             return -1;
         }
         if (value2 == null) {
             return 1;
         }
         if (value1 instanceof String) {
             return ((String) value1).compareToIgnoreCase((String) value2);
         }
         return value1.compareTo(value2);
     }

}
