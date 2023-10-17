package coreJava.general;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableClassImpl {

    public static void main(String[] args) {
        HashMap<Integer,String> map=new HashMap<>();
        map.put(1,"sn");
        map.put(2,"ak");
        map.put(3,"ro");
        ImmutableClassExample example=new ImmutableClassExample(1,map,"snehal");
        System.out.println(example.getEmpId());
        System.out.println(example.getEmployeeMap());
        System.out.println(example.getName());
        example.updateValues(2,map,"arjun");
        System.out.println("---after update---");
        System.out.println(example.getEmpId());
        System.out.println(example.getEmployeeMap());
        System.out.println(example.getName());
    }
}
final class  ImmutableClassExample{
    private final int empId;
    private final Map<Integer, String> employeeMap;
    private final String name;

    ImmutableClassExample(final int empId, final HashMap<Integer, String> employeeMap, final String name){
        this.empId=empId;
        this.employeeMap=new HashMap<>(employeeMap);
        this.name=name;
    }
    public int getEmpId() {
        return empId;
    }

    public Map<Integer, String> getEmployeeMap() {
        return Collections.unmodifiableMap(employeeMap);
    }

    public String getName() {
        return name;
    }
    public ImmutableClassExample updateValues(final int empId, final HashMap<Integer, String> employeeMap, final String name){
        return new ImmutableClassExample(empId,new HashMap<>(employeeMap),name);
    }
}
