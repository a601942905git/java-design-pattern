package com.design.pattern.visitor;

/**
 * com.design.pattern.visitor.VisitorB
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午10:56
 */
public class VisitorB extends Visitor{

    public VisitorB(String name) {
        this.name = name;
    }

    @Override
    public void visitor(NodeA nodeA) {
        System.out.println(name + "访问" + nodeA.operationA());
    }

    @Override
    public void visitor(NodeB nodeB) {
        System.out.println(name + "访问" + nodeB.operationB());
    }
}
