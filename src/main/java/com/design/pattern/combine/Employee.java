package com.design.pattern.combine;

import java.util.ArrayList;
import java.util.List;

/**
 * com.design.pattern.combine.Employee
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午2:24
 */
public class Employee {

    /**
     * 名称
     */
    private String name;

    /**
     * 岗位
     */
    private String job;

    /**
     * 下属
     */
    private List<Employee> subordinates;

    public Employee(String name, String job) {
        this.name = name;
        this.job = job;
        subordinates = new ArrayList<>();
    }

    public void add(Employee employee) {
        this.subordinates.add(employee);
    }

    public void remove(Employee employee) {
        this.subordinates.remove(employee);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", job='" + job + "'}";
    }
}
