### 模板模式
- 存在相同行为不同的表现形式
- 优点
    - 封装不变的，扩展可变的
    - 提取公用代码，便于维护
    - 行为由父类控制，子类自己实现
- 场景
> 针对球类比赛，篮球和足球，都需要先凑齐人，然后开始比赛，时间到了结束比赛（流程是相同的）。但是凑齐的人数不同、比赛的方式不同（一个用脚，一个用手）、结束的时间不同
- 实例
    - 抽象类
    ```
    public abstract class Game {

        protected abstract void initialize();
    
        protected abstract void startPlay();
    
        protected abstract void endPlay();
    
        protected final void play() {
            initialize();
            startPlay();
            endPlay();
        }
    }
    ```
    - 实现类
    ```
    public class FootBallGame extends Game{

        @Override
        protected void initialize() {
            System.out.println("集齐22个人，每11个人为一队。双方守门员，踢球人员准备就绪，开始足球比赛。");
        }
    
        @Override
        protected void startPlay() {
            System.out.println("球员用脚进行踢球，踢来踢去。");
        }
    
        @Override
        protected void endPlay() {
            System.out.println("双方踢到90分钟，足球比赛结束。");
        }
    }
    
    public class BasketBallGame extends Game{

        @Override
        protected void initialize() {
            System.out.println("集齐10个人，每5个人为一队。双方球员准备就绪，开始篮球比赛。");
        }
    
        @Override
        protected void startPlay() {
            System.out.println("球员用手控球，传来传去。");
        }
    
        @Override
        protected void endPlay() {
            System.out.println("踢完48分钟，篮球比赛结束。");
        }
    }

    ```

    - 测试
    ```
    public class Test {

        public static void main(String[] args) {
            Game footBallGame = new FootBallGame();
            footBallGame.play();
            System.out.println("\n");
            Game basketBallGame = new BasketBallGame();
            basketBallGame.play();
        }
    }

    ```