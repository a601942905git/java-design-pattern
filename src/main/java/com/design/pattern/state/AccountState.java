package com.design.pattern.state;

/**
 * com.design.pattern.state.AccountState
 *
 * @author lipeng
 * @dateTime 2018/8/28 下午4:51
 */
public abstract class AccountState {

    protected Account account;

    protected abstract void changeState();

}
