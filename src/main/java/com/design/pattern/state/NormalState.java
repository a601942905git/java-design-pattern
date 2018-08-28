package com.design.pattern.state;

import java.math.BigDecimal;

/**
 * com.design.pattern.state.NormalState
 *
 * @author lipeng
 * @dateTime 2018/8/28 下午4:53
 */
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
