### 责任链模式
- 优点
> 调用者不必关心处理细节，只需要传递相应参数，通过链式处理，的到返回结果。并且处理链可以支持扩展
- 使用场景
> 一个请求需要多个处理对象
- 案例
    - servlet的filter
    - spring的interceptor
- 场景介绍
> 通过传入日志级别，打印该级别及以下级别的log日志信息
- 实现
    - 抽象日志类
    ```
    public abstract class AbstractLogger {

        protected Integer logLevel = 0;
    
        protected AbstractLogger next;
    
        public void setNext(AbstractLogger abstractLogger) {
            this.next = abstractLogger;
    
        }
    
        public void logMessage(Integer logLevel) {
            if (this.logLevel <= logLevel) {
                write();
            }
    
            if (null != next) {
                next.logMessage(logLevel);
            }
        }
    
        public abstract void write();
    }
    ```
    - 具体级别日志实现
    ```
    public class DebugLogger extends AbstractLogger{

        public DebugLogger(Integer logLevel) {
            this.logLevel = logLevel;
        }
    
        @Override
        public void write() {
            System.out.println("print debug level log message");
        }
    }
    
    public class InfoLogger extends AbstractLogger {

        public InfoLogger(Integer logLevel) {
            this.logLevel = logLevel;
        }
    
        @Override
        public void write() {
            System.out.println("print info level log message");
        }
    }
    
    public class ErrorLogger extends AbstractLogger{

        public ErrorLogger(Integer logLevel) {
            this.logLevel = logLevel;
        }
    
        @Override
        public void write() {
            System.out.println("print error level log message");
        }
    }
    ```
    - 常量类
    ```
    public class LoggerConstants {

        public static final Integer DEBUG_LEVEL = 1;
    
        public static final Integer INFO_LEVEL = 2;
    
        public static final Integer ERROR_LEVEL = 3;
    }
    ```
    - 测试
    ```
    public class Test {

        public static void main(String[] args) {
            AbstractLogger debugLogger = new DebugLogger(1);
            AbstractLogger infoLogger = new InfoLogger(2);
            AbstractLogger errorLogger = new ErrorLogger(3);
    
            debugLogger.setNext(infoLogger);
            infoLogger.setNext(errorLogger);
    
            debugLogger.logMessage(1);
            System.out.println("===========");
            debugLogger.logMessage(2);
            System.out.println("===========");
            debugLogger.logMessage(3);
        }
    }
    ```