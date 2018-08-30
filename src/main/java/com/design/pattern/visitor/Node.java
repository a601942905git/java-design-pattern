package com.design.pattern.visitor;

/**
 * com.design.pattern.visitor.Node
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午10:57
 */
public abstract class Node {

    public abstract void accept(Visitor visitor);
}
