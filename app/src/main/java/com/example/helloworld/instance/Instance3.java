package com.example.helloworld.instance;

public class Instance3 {

    private static Instance3 instance3 = null;
    private Instance3() {}

    public static Instance3 getInstance() {
        if (instance3 == null) {
            synchronized (Instance3.class) {
                if (instance3 == null) {
                    instance3 = new Instance3();
                }
            }
        }

        return instance3;
    }
}
