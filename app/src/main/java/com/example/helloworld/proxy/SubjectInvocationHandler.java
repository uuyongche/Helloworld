package com.example.helloworld.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubjectInvocationHandler implements InvocationHandler {

    private Subject subject;

    public SubjectInvocationHandler(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before method invoke...");
        method.invoke(subject, method);
        System.out.println("after method invoke...");
        return null;
    }
}
