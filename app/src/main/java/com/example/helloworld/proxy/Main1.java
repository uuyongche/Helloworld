package com.example.helloworld.proxy;

import java.lang.reflect.Proxy;

public class Main1 {

    public static void main(String[] args) {
        Subject realSubject = new RealSubject();
        SubjectInvocationHandler subjectInvocationHandler = new SubjectInvocationHandler(realSubject);
        Subject subject = (Subject) Proxy.newProxyInstance(subjectInvocationHandler.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(), subjectInvocationHandler);
        subject.sayGoodBye();
        subject.sayHello("str");
    }
}
