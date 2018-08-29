### 组合模式
- 描述
> 组合模式又叫部分-整体模式，用来实现树形结构，一般都在一个对象中包含一组对象
- 实例
```
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
```