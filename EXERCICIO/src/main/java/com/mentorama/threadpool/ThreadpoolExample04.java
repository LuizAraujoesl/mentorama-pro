package com.mentorama.threadpool;



import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadpoolExample04 {
    public static void main(String[] args){
        ScheduledExecutorService executor =  Executors.newScheduledThreadPool(5);

        executor.schedule(()-> System.out.println(Thread.currentThread().getName()),1, TimeUnit.SECONDS);

        executor.schedule(()-> System.out.println(Thread.currentThread().getName()),2, TimeUnit.SECONDS);

        executor.schedule(()-> System.out.println(Thread.currentThread().getName()),3, TimeUnit.SECONDS);


    }
}
