### 装饰器模式
- 描述
> 向现有的对象添加功能，但不改变其内部结构
- 优点
> 支持动态扩展现有对象的功能
- 场景
    - 给画添加画框
    - 给手机贴膜、安装手机壳
    - 学生和老师原本只有打招呼的功能，需要再次基础上添加自己的职责功能
- 实例
    - 人接口
    ```
    public interface Person {

        void sayHello();
    }
    ```
    - 学生和老师实现类
    ```
    public class Student implements Person{

        @Override
        public void sayHello() {
            System.out.println("我是一个学生");
        }
    }
    
    public class Teacher implements Person{

        @Override
        public void sayHello() {
            System.out.println("我是一个教师");
        }
    }
    ```
    - 装饰器抽象类实现person接口
    ```
    public abstract class PersonDecorator implements Person{

        protected Person person;
    
        public PersonDecorator(Person person) {
            this.person = person;
        }
    
        @Override
        public void sayHello() {
            person.sayHello();
        }
    }
    ```
    - 装饰器实现类
    ```
    public class FunctionStudentDecorator extends PersonDecorator{

        public FunctionStudentDecorator(Person person) {
           super(person);
        }
    
        @Override
        public void sayHello() {
            this.person.sayHello();
            System.out.println("好好学习");
        }
    }
    
    public class FunctionTeacherDecorator extends PersonDecorator{

        public FunctionTeacherDecorator(Person person) {
            super(person);
        }
    
        @Override
        public void sayHello() {
            this.person.sayHello();
            System.out.println("好好教书");
        }
    }
    ```
    - 测试
    ```
    public class Test {

        public static void main(String[] args) {
            Student student = new Student();
            student.sayHello();
    
            Teacher teacher = new Teacher();
            teacher.sayHello();
            System.out.println("\n");
    
            FunctionStudentDecorator functionStudentDecorator = new FunctionStudentDecorator(new Student());
            functionStudentDecorator.sayHello();
            System.out.println("\n");
    
            FunctionTeacherDecorator functionTeacherDecorator = new FunctionTeacherDecorator(new Teacher());
            functionTeacherDecorator.sayHello();
    
        }
    }

    ```