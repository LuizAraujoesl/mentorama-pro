package com.mentorama.threadpool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ThreadpoolExample01 {
    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(2);

        executor.execute(()->{
            System.out.println(Thread.currentThread().getName() + " Thread service me executou");
        });

        executor.execute(()->{
            System.out.println(Thread.currentThread().getName() + " Thread service me executou");
        });

        executor.execute(()->{
            System.out.println(Thread.currentThread().getName() + " Thread service me executou");
        });

        executor.execute(()->{
            System.out.println(Thread.currentThread().getName() + " Thread service me executou");
        });


    }
}
