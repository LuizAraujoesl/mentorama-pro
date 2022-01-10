package com.mentorama.threadpool;



import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadpoolExample03 {
    public static void main(String[] args){
        ThreadPoolExecutor executor =  (ThreadPoolExecutor) Executors.newCachedThreadPool();
        executor.setKeepAliveTime(5, TimeUnit.SECONDS);

        executor.submit(()->{
            System.out.println(Thread.currentThread().getName() + " Sendo executada");
            Thread.sleep(1000);
            return null;
        });

        System.out.println("Numero de Threads atual: " + executor.getActiveCount());

        executor.submit(()->{
            System.out.println(Thread.currentThread().getName() + " Sendo executada");
            Thread.sleep(1000);
            return null;
        });

        System.out.println("Numero de Threads atual: " + executor.getActiveCount());

        executor.submit(()->{
            System.out.println(Thread.currentThread().getName() + " Sendo executada");
            Thread.sleep(1000);
            return null;
        });
        System.out.println("Numero de Threads atual: " + executor.getActiveCount());
    }
}
