package com.design.pattern.decorator;

/**
 * com.design.pattern.decorator.PersonDecorator
 *
 * @author lipeng
 * @dateTime 2018/8/28 下午9:42
 */
public abstract class PersonDecorator implements Person{

    protected Person person;

    public PersonDecorator(Person person) {
        this.person = person;
    }

    @Override
    public void sayHello() {
        person.sayHello();
    }
}
