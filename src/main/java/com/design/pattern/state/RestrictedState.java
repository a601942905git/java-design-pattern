package com.design.pattern.state;

import java.math.BigDecimal;

/**
 * com.design.pattern.state.RestrictedState
 *
 * @author lipeng
 * @dateTime 2018/8/28 下午5:23
 */
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
