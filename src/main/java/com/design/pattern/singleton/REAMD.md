### 单例模式

#### 优点
> 避免频繁创建对象，节约内存空间，降低GC回收对象，提升系统性能

#### 使用场景
- 所有情况不需要不同的对象(例如Service调用DAO，只需要持有DAO对象就好，允许共用对象)，不需要想实体类那样不同的对象有不同的属性（例如学生实体，每个学生有不同学号、姓名、年龄，就必须创建多个对象）

#### 实现方式
- 饿汉模式，在类被加载器加载的时候进行对象实例化
```
public class Singleton1 {

    private static final Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}
```
- 懒汉模式，在调用的时候进行对象实例化（需要加锁保证线程安全）
```
public class Singleton2 {

    private static Singleton2 instance = null;

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        if (null == instance) {
            synchronized (Singleton2.class) {
                if (null == instance) {
                    instance = new Singleton2();
                }
            }
        }
        return instance;
    }
}
```
- 静态内部类，在调用的时候进行对象实例化
```
public class Singleton3 {

    private Singleton3() {

    }

    private static class SingletonHolder {
        private static final Singleton3 INSTANCE = new Singleton3();
    }

    public static Singleton3 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
```
- 枚举类型
```
public enum Singleton4 {
    INSTANCE;
}
```