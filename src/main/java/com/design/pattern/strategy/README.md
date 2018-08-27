### 策略模式
- 描述
> 对一组算法进行封装，选择不同的策略执行不同的算法
- 优点
> 对算法内部实现进行封装，调用者只需调用。对于算法支持扩展，调用只要选择对应的策略即可。
- 场景
> 封装加、减、乘、除算法，调用的时候只需要传入对应的策略，来执行相应的算法，得到最终的结果。
- 实例
    - 策略接口
    ```
    public interface Strategy {

        /**
         * 计算
         * @param num1
         * @param num2
         * @return
         */
        int calculate(int num1, int num2);
    }
    ```
    - 策略实现类
    ```
    public class AddStrategy implements Strategy{

        @Override
        public int calculate(int num1, int num2) {
            return num1 + num2;
        }
    }
    
    public class SubtractStrategy implements Strategy{

        @Override
        public int calculate(int num1, int num2) {
            return num1 - num2;
        }
    }
    
    public class MultiStrategy implements Strategy{

        @Override
        public int calculate(int num1, int num2) {
            return num1 * num2;
        }
    }
    
    public class DivideStrategy implements Strategy{

        @Override
        public int calculate(int num1, int num2) {
            return num1 / num2;
        }
    }
    ```
    - 上下文对象，持有策略对象
    ```
    public class Context {

        private Strategy strategy;
    
        public Context(Strategy strategy) {
            this.strategy = strategy;
        }
    
        public int calculate(int num1, int num2) {
            if (null == strategy) {
                return 0;
            }
            return this.strategy.calculate(num1, num2);
        }
    }
    ```
    - 测试
    ```
    public class Test {

        public static void main(String[] args) {
            Context context = new Context(new AddStrategy());
            System.out.println(context.calculate(1, 2));
    
            context = new Context(new SubtractStrategy());
            System.out.println(context.calculate(10, 5));
    
            context = new Context(new MultiStrategy());
            System.out.println(context.calculate(2, 4));
    
            context = new Context(new DivideStrategy());
            System.out.println(context.calculate(80, 5));
        }
    }
    ```