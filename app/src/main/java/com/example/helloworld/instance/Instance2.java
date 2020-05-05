package com.example.helloworld.instance;

public class Instance2 {

    private static Instance2 instance2 = new Instance2();
    private Instance2() {}

    public static Instance2 getInstance2() {
        return instance2;
    }
}
