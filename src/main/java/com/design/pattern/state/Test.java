package com.design.pattern.state;

import java.math.BigDecimal;

/**
 * com.design.pattern.state.Test
 *
 * @author lipeng
 * @dateTime 2018/8/28 下午5:50
 */
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
