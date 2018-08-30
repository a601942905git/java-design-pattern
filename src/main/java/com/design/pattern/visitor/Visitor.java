package com.design.pattern.visitor;

/**
 * com.design.pattern.visitor.Visitor
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午10:56
 */
public abstract class Visitor {

    protected String name;

    public abstract void visitor(NodeA nodeA);

    public abstract void visitor(NodeB nodeB);
}
