package com.design.pattern.visitor;

/**
 * com.design.pattern.visitor.Test
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午11:10
 */
public class Test {

    public static void main(String[] args) {
        Visitor visitor = new VisitorA("访问者A");
        Client client = new Client(visitor);
        Node node = new NodeA();
        client.add(node);
        node = new NodeB();
        client.add(node);
        client.action();
    }
}
