package com.example.helloworld.proxy;

public class RealSubject implements Subject {
    @Override
    public void sayGoodBye() {
        System.out.println("sayGoodBye...");
    }

    @Override
    public void sayHello(String str) {
        System.out.println("sayHello " + str);
    }
}
