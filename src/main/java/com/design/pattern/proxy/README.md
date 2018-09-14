### 代理模式
- 描述
> 当需要对目标对象进行增加的时候，需要对目标对象进行代理
- 优点
> 可以在不改变对象结构的情况下对对象进行增强
- 场景
    - spring切面
- 静态代理（代理类和被代理对象需要实现同一个接口）
    - 接口
    ```
    public interface UserService {

        /**
         * 打招呼
         * @param name
         */
        void sayHello(String name);
    }

    ```
    - 实现类
    ```
    public class UserServiceImpl implements UserService {

        @Override
        public void sayHello(String name) {
            System.out.println(String.format("Hello,My Name Is%s", name));
        }
    }

    ```
    - 代理类
    ```
    public class Proxy implements UserService {

        private UserService userService;
    
        public Proxy(UserService userService) {
            this.userService = userService;
        }
    
        @Override
        public void sayHello(String name) {
            System.out.println("在目标方法开始前增强");
            userService.sayHello(name);
            System.out.println("在目标方法结束后增强");
        }
    }
    ```
    - 测试
    ```
    public class Test {

        public static void main(String[] args) {
            Proxy proxy = new Proxy(new UserServiceImpl());
            proxy.sayHello("张三");
        }
    }

    ```
- 动态代理
    - jdk动态代理(目标对象实现接口)
    ```
    public class JdkProxyFactory {

        private Object target;
    
        public JdkProxyFactory(Object target) {
            this.target = target;
        }
    
        public Object getInstance() {
            return Proxy.newProxyInstance(
                    target.getClass().getClassLoader(),
                    target.getClass().getInterfaces(),
                    (Object proxy, Method method, Object[] args) -> {
                        System.out.println("在目标方法开始前增强");
                        Object result = method.invoke(target, args);
                        System.out.println("在目标方法结束后增强");
                        return result;
                    });
        }
    }
    
    
    
    public class Test {

        public static void main(String[] args) {
            JdkProxyFactory jdkProxyFactory = new JdkProxyFactory(new UserServiceImpl());
            UserService userService = (UserService) jdkProxyFactory.getInstance();
            userService.sayHello("李四");
        }
    }
    ```
    - cglib动态代理(目标对象没有实现接口)
    ```
    public class StudentService {
    
        public void doHomeWork(String name) {
            System.out.println(String.format("%s正在写家庭作业", name));
        }
    }
    
    public class TeacherService {

        public void teach(String name) {
            System.out.println(String.format("%s老师正在授课", name));
        }
    
    }

    public class ProxyFactory implements MethodInterceptor {
    
        /**
         * 持有目标对象
         */
        private Object target;
    
        public ProxyFactory(Object target) {
            this.target = target;
        }
    
        public Object getInstance() {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(target.getClass());
            enhancer.setCallback(this);
            return enhancer.create();
        }
    
    
        @Override
        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            Object result = null;
            System.out.println("在目标方法开始前增强");
            result = method.invoke(target, objects);
            System.out.println("在目标方法结束后增强");
            return result;
        }
    }
    
    public class Test {

        public static void main(String[] args) {
            ProxyFactory proxyFactory = new ProxyFactory(new StudentService());
            StudentService studentService = (StudentService) proxyFactory.getInstance();
            studentService.doHomeWork("张三");
    
            System.out.println("\n");
    
            proxyFactory = new ProxyFactory(new TeacherService());
            TeacherService teacherService = (TeacherService) proxyFactory.getInstance();
            teacherService.teach("王");
        }
    }
    ```
