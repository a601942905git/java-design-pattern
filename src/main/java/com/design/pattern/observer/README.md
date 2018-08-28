### 观察者模式
- 优点
> 目标对象与观察者之间是解耦的,观察者可以在不影响业务的情况下进行扩展
- 使用场景
> 当一个对象发生变更，需要通知多个对象
- 案例
    - spring事件驱动
    - 消息队列的发布订阅
- 实例：下订单之后会清空购物车、发送短信、扣减库存
- 实现
    - 观察者持有目标对象
    ```
    public abstract class OrderObserver {

        protected OrderSubject orderSubject;
    
        public abstract void update();
    }
    
    public class SmsObserver extends OrderObserver{

        public SmsObserver(OrderSubject orderSubject) {
            this.orderSubject = orderSubject;
            this.orderSubject.addObserver(this);
        }
    
        @Override
        public void update() {
            System.out.println("发送短信。。。。。。");
        }
    }
    
    public class ShoppingCartObserver extends OrderObserver{

        public ShoppingCartObserver(OrderSubject orderSubject) {
            this.orderSubject = orderSubject;
            this.orderSubject.addObserver(this);
        }
    
        @Override
        public void update() {
            System.out.println("清空购物车商品信息。。。。。。");
        }
    }

    public class StockObserver extends OrderObserver{
    
        public StockObserver (OrderSubject orderSubject) {
            this.orderSubject = orderSubject;
            this.orderSubject.addObserver(this);
        }
    
        @Override
        public void update() {
            System.out.println("扣减库存。。。。。。");
        }
    }
    ```
    - 目标对象
    ```
    public class OrderSubject {

        private ArrayList<OrderObserver> observerList = new ArrayList<>();
    
        public void addOrder() {
            System.out.println("下订单。。。。。。");
            notifyAllObservers();
        }
    
        public void addObserver(OrderObserver observer) {
            observerList.add(observer);
        }
    
        /**
         * 通知所有的观察者
         */
        private void notifyAllObservers() {
            for (OrderObserver observer : observerList) {
                observer.update();
            }
        }
    }
    ```
    - 测试代码
    ```
    public class Test {

        public static void main(String[] args) {
            OrderSubject orderSubject = new OrderSubject();
    
            new SmsObserver(orderSubject);
            new StockObserver(orderSubject);
            new ShoppingCartObserver(orderSubject);
    
            orderSubject.addOrder();
        }
    }
    ```
    
### 使用jdk自带的类实现观察者模式
- 被观察者继承Observable
- 观察者实现Observer
- 在被观察这种添加观察者
- 场景
> 老师询问学生某道数学题有没有听懂，学生进行相应的回答
- 实例
    - 被观察者
    ```
    public class Teacher extends Observable {
    
        public void ask() {
            Integer number = 10;
            System.out.println("第" + number +  "道数学题大家都听懂了嘛？？？");
            setChanged();
            notifyObservers(number);
        }
    }

    ```
    - 观察者
    ```
    public class Student1 implements Observer {
    
        private Teacher teacher;
    
        public Student1(Teacher teacher) {
            this.teacher = teacher;
            this.teacher.addObserver(this);
        }
    
        @Override
        public void update(Observable o, Object arg) {
            System.out.println("老师第" + arg + "道数学题我没有听懂？？？");
        }
    }
    
    public class Student2 implements Observer {
    
        private Teacher teacher;
    
        public Student2(Teacher teacher) {
            this.teacher = teacher;
            this.teacher.addObserver(this);
        }
    
        @Override
        public void update(Observable o, Object arg) {
            System.out.println("老师第" + arg + "道数学题我听懂了。。。");
        }
    }
    
    public class Student3 implements Observer {
    
        private Teacher teacher;
    
        public Student3(Teacher teacher) {
            this.teacher = teacher;
            this.teacher.addObserver(this);
        }
    
        @Override
        public void update(Observable o, Object arg) {
            System.out.println("老师第" + arg + "道数学题我也没有听懂？？？");
        }
    }
    ```
    - 测试
    ```
    public class Test {
    
        public static void main(String[] args) {
            Teacher teacher = new Teacher();
    
            new Student1(teacher);
            new Student2(teacher);
            new Student3(teacher);
    
            teacher.ask();
        }
    }
    ```