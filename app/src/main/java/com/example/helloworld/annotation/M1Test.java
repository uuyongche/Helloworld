package com.example.helloworld.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class M1Test {

    @M1Annotation(a = "123")
    public void main(String[] args) throws NoSuchMethodException {
        Method method = M1Test.class.getMethod("main", M1Test.class);
        M1Annotation m1Annotation = method.getAnnotation(M1Annotation.class);
        m1Annotation.a();

        ExecutorService exc = Executors.newFixedThreadPool(128);
        exc.execute(new Thread() {
            @Override
            public void run() {
                super.run();
            }
        });

    }
}
