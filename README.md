## JAVA设计模式
### 单例模式
- 饿汉模式
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
- 懒汉模式
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
- 双重校验加锁
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
- 枚举
```
public enum Singleton4 {
    INSTANCE;
}
```