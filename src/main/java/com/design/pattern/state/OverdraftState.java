package com.design.pattern.state;

import java.math.BigDecimal;

/**
 * com.design.pattern.state.OverdraftState
 *
 * @author lipeng
 * @dateTime 2018/8/28 下午5:23
 */
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
