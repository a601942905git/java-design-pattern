package com.design.pattern.visitor;

/**
 * com.design.pattern.visitor.NodeA
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午10:57
 */
public class NodeA  extends Node{

    @Override
    public void accept(Visitor visitor) {
        visitor.visitor(this);
    }

    public String operationA() {
        return "节点A";
    }
}
