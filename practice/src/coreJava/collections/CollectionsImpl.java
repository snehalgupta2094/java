package coreJava.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Pair<K,V>{
    K k;
    V v;
    public Pair(K k, V v) {
        this.k = k;
        this.v = v;
    }


}
class Person{
    int age;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    String name;
    int salary;
    Person(int age, int salary, String name){
        this.name=name;
        this.salary=salary;
        this.age=age;
    }
    @Override
    public String toString(){
        return "Person: "+this.name+" Salary: "+this.salary+" Age: "+age;
    }
}
class PersonComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        int ageComparison = Integer.compare(person1.getAge(), person2.getAge());
        if (ageComparison != 0) {
            return ageComparison;
        }
        return Integer.compare(person1.getSalary(), person2.getSalary());
    }
}
class Employee implements Comparable<Employee>{
    int age;
    String name;
    int salary;
    Employee(int age, int salary, String name){
        this.name=name;
        this.salary=salary;
        this.age=age;
    }
    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.age,o.age);
    }
    @Override
    public String toString(){
        return "Employee: "+this.name+" Salary: "+this.salary+" Age: "+age;
    }
}
public class CollectionsImpl {
    public static void printList(List employeeList){
        System.out.println(employeeList.get(0).toString());
        System.out.println(employeeList.get(1).toString());
        System.out.println(employeeList.get(2).toString());
        System.out.println(employeeList.get(3).toString());
        System.out.println("==========");
    }
    public static void main(String[] args) {
        //List
        List employeeList = new ArrayList<Employee>();
        Employee e1 = new Employee(26, 2345, "abc");
        Employee e2 = new Employee(20, 5436, "def");
        Employee e3 = new Employee(10, 765, "ghi");
        Employee e4 = new Employee(30, 8388, "klm");
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);

        /**Comparable
         * sort by age
         * compareTo
         * **/
        Collections.sort(employeeList);
        printList(employeeList);
        //reverse
        Collections.sort(employeeList, Collections.reverseOrder());
        printList(employeeList);

        ///////////
        List personList = new ArrayList<Person>();
        List personListNew = new ArrayList<Person>(personList);
        Person p1 = new Person(26, 2345, "abc");
        Person p2 = new Person(20, 5436, "def");
        Person p3 = new Person(10, 8388, "ghi");
        Person p4 = new Person(20, 7650, "klm");
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);

        /**Comparator
         * sort by age
         * sort by salary
         * compare
         **/
        Comparator comparatorbyAgeSalary = Comparator.comparingInt(Person::getAge).thenComparingInt(Person::getSalary);
        Collections.sort(personList, comparatorbyAgeSalary);
        printList(personList);
        //non-java8
        Collections.sort(personListNew, new PersonComparator());

        //Iterate hashmap
        HashMap<Integer, String> hashMap = new HashMap();
        hashMap.put(1, "cd");
        hashMap.put(2, "kl");
        hashMap.put(3, "ab");
        hashMap.put(4, "ghi");
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        //Sort by value in hashmap
        List<Map.Entry<Integer, String>> entryList = new ArrayList<>(hashMap.entrySet());
        Comparator<Map.Entry<Integer, String>> stringSort = Comparator.comparing(Map.Entry::getValue);
        Collections.sort(entryList, stringSort);
        System.out.println(entryList);

        //Comparator with Pair object
        ArrayList<Pair<Integer, Integer>> pairs = new ArrayList<>();
        pairs.add(new Pair(2, 20));
        pairs.add(new Pair(17, 29));
        pairs.add(new Pair(22, 20));
        pairs.add(new Pair(1, 20));
        pairs.add(new Pair(15, 20));

        Collections.sort(pairs, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return o1.k.compareTo(o2.k);
            }
        });
        pairs.forEach(pair-> System.out.println(pair.k+", "+pair.v));

    }
}
