### 状态模式
- 描述
> 存在多种状态之间的变更
- 优点
> 状态的变更分散到各个实现类中
- 场景
> 张三在银行开通一个信用卡账户，初始信用卡状态为正常状态，当月小于0元大于-2000的时候出于透支状态，当余额小于-2000的时候属于禁用状态。
- 设计状态
    - 正常状态
    - 透支状态
    - 禁用状态
> 并且这几种状态会互相转换，正常-->透支-->禁用-->透支-->正常
- 实现
    - 状态抽象类
    ```
    public abstract class AccountState {

        protected Account account;
    
        protected abstract void changeState();
    
    }
    ```
    - 状态实现类
    ```
    public class NormalState extends AccountState{

        public NormalState(Account account) {
            this.account = account;
        }
    
        @Override
        protected void changeState() {
            BigDecimal balance = account.getBalance();
            if (balance.compareTo(AccountConstants.TWO_THOUSAND) > 0
                    && balance.compareTo(BigDecimal.ZERO) < 0) {
                account.setAccountState(new OverdraftState(this.account));
            } else if (balance.compareTo(AccountConstants.TWO_THOUSAND) <= 0) {
                account.setAccountState(new RestrictedState(this.account));
            }
        }
    }
    
    public class OverdraftState extends AccountState{

        public OverdraftState(Account account) {
            this.account = account;
        }
    
        @Override
        protected void changeState() {
            BigDecimal balance = account.getBalance();
            if (balance.compareTo(BigDecimal.ZERO) > 0) {
                account.setAccountState(new NormalState(this.account));
            } else if (balance.compareTo(AccountConstants.TWO_THOUSAND) <= 0) {
                account.setAccountState(new RestrictedState(this.account));
            }
        }
    }
    
    public class RestrictedState extends AccountState{

        public RestrictedState(Account account) {
            this.account = account;
        }
    
        @Override
        protected void changeState() {
            BigDecimal balance = account.getBalance();
            if (balance.compareTo(BigDecimal.ZERO) > 0) {
                account.setAccountState(new NormalState(this.account));
            } else if (balance.compareTo(AccountConstants.TWO_THOUSAND) > 0
                    && balance.compareTo(BigDecimal.ZERO) < 0) {
                account.setAccountState(new OverdraftState(this.account));
            }
        }
    }
    ```
    - 账户类，充当状态管理类
    ```
    public class Account {

        private String name;
    
        private BigDecimal balance;
    
        private AccountState accountState;
    
        public Account(String name, BigDecimal balance) {
            this.name = name;
            this.balance = balance;
            System.out.println(this.name + "开户");
            this.setAccountState(new NormalState(this));
            System.out.println("现在余额为"+ this.balance);
            System.out.println("---------------------------------------------");
        }
    
        /**
         * 存钱
         */
        public void deposit(BigDecimal money) {
            System.out.println(this.name + "存款" + money);
            this.balance = this.balance.add(money).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
            accountState.changeState();
            System.out.println("现在余额为"+ this.balance);
            System.out.println("现在帐户状态为"+ this.accountState.getClass().getSimpleName());
            System.out.println("---------------------------------------------");
        }
    
        public void withdraw(BigDecimal money) {
            System.out.println(this.name + "取款" + money);
            this.balance = this.balance.subtract(money).divide(BigDecimal.ONE, 2, BigDecimal.ROUND_HALF_UP);
            accountState.changeState();
            System.out.println("现在余额为"+ this.balance);
            System.out.println("现在帐户状态为"+ this.accountState.getClass().getSimpleName());
            System.out.println("---------------------------------------------");
        }
    
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public BigDecimal getBalance() {
            return balance;
        }
    
        public void setBalance(BigDecimal balance) {
            this.balance = balance;
        }
    
        public AccountState getAccountState() {
            return accountState;
        }
    
        public void setAccountState(AccountState accountState) {
            this.accountState = accountState;
        }
    }
    ```
    - 测试
    ```
    public class Test {

        public static void main(String[] args) {
            // 开户
            Account account = new Account("张三", new BigDecimal(2000));
    
            // 发工资存款
            account.deposit(new BigDecimal(5500));
    
            // 交房租存款
            account.withdraw(new BigDecimal(8000));
    
            // 吃饭
            account.withdraw(new BigDecimal(2000));
    
            // 兼职
            account.deposit(new BigDecimal(8000));
        }
    }
    ```