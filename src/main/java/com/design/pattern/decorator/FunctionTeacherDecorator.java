package com.design.pattern.decorator;

/**
 * com.design.pattern.decorator.FunctionTeacherDecorator
 *
 * @author lipeng
 * @dateTime 2018/8/28 下午9:51
 */
public class FunctionTeacherDecorator extends PersonDecorator{


    public FunctionTeacherDecorator(Person person) {
        super(person);
    }

    @Override
    public void sayHello() {
        this.person.sayHello();
        System.out.println("好好教书");
    }
}
