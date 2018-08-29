package com.design.pattern.combine;

/**
 * com.design.pattern.combine.Test
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午2:29
 */
public class Test {

    public static void main(String[] args) {
        Employee ceo = new Employee("John", "CEO");

        // 主管
        Employee headSales = new Employee("Robert","Head Sales");
        Employee headMarketing = new Employee("Michel","Head Marketing");
        ceo.add(headSales);
        ceo.add(headMarketing);

        Employee clerk1 = new Employee("Laura","Marketing");
        Employee clerk2 = new Employee("Bob","Marketing");
        headMarketing.add(clerk1);
        headMarketing.add(clerk2);

        Employee salesExecutive1 = new Employee("Richard","Sales");
        Employee salesExecutive2 = new Employee("Rob","Sales");
        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        System.out.println(ceo);
        for (Employee headEmployee : ceo.getSubordinates()) {
            System.out.println(headEmployee);
            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println(employee);
            }
        }
    }
}
