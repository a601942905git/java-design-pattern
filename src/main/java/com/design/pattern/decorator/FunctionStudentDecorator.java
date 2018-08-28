package com.design.pattern.decorator;

/**
 * com.design.pattern.decorator.FunctionStudentDecorator
 *
 * @author lipeng
 * @dateTime 2018/8/28 下午9:45
 */
public class FunctionStudentDecorator extends PersonDecorator{

    public FunctionStudentDecorator(Person person) {
       super(person);
    }

    @Override
    public void sayHello() {
        this.person.sayHello();
        System.out.println("好好学习");
    }
}
