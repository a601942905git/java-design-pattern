package com.design.pattern.visitor;

/**
 * com.design.pattern.visitor.NodeB
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午10:57
 */
public class NodeB extends Node {

    @Override
    public void accept(Visitor visitor) {
        visitor.visitor(this);
    }

    public String operationB() {
        return "节点B";
    }
}
