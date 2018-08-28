package com.design.pattern.state;

import java.math.BigDecimal;

/**
 * com.design.pattern.state.Account
 *
 * @author lipeng
 * @dateTime 2018/8/28 下午4:51
 */
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
