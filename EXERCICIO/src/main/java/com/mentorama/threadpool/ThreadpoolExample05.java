package com.mentorama.threadpool;



import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadpoolExample05 {
    public static void main(String[] args){
        ScheduledExecutorService executor =  Executors.newScheduledThreadPool(5);

        executor.scheduleAtFixedRate(()-> System.out.println(Thread.currentThread().getName()),1,1, TimeUnit.SECONDS);

        executor.scheduleAtFixedRate(()-> System.out.println(Thread.currentThread().getName()),1,1, TimeUnit.SECONDS);


    }
}
