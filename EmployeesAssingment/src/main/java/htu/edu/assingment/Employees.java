package htu.edu.assingment;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Employees {

    static Map<Integer, Employees> map = new HashMap<Integer, Employees>();
    private int id;
    private String name;
    private double salary;
    private String department;

    public Employees(int id, String name, double salary, String department) throws IOException {
        this.id = id;
        setName(name);
        setSalary(salary);
        setDepartment(department);
        EmployeeManagement.write();
    }

    public Employees(String name, double salary, String department) throws IOException {
        setId();
        setName(name);
        setSalary(salary);
        setDepartment(department);
        map.put(this.id, this);
        EmployeeManagement.write();
    }

    public void setId() {
        this.id = EmployeeManagement.atomicInteger.incrementAndGet();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    @Override
    public String toString() {
        return
                id +
                        " , " + name + '\'' +
                        " , " + salary +
                        " , " + department;
    }
}