package com.example.helloworld.instance;

public class Instance1 {
    private static Instance1 instance1;

    private Instance1() {}

    public static Instance1 getInstance() {
        if (instance1 == null) {
            instance1 = new Instance1();
        }

        return instance1;
    }
}
