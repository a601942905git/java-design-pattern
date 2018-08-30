package com.design.pattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * com.design.pattern.visitor.Client
 *
 * @author lipeng
 * @dateTime 2018/8/29 下午11:08
 */
public class Client {

    private List<Node> nodeList;

    private Visitor visitor;

    public Client(Visitor visitor) {
        this.visitor = visitor;
        this.nodeList = new ArrayList<>();
    }

    public void action() {
        for (Node node : nodeList) {
            node.accept(this.visitor);
        }
    }

    public void add(Node node) {
        this.nodeList.add(node);
    }
}
