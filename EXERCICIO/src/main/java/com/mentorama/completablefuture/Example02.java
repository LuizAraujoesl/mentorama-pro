package com.mentorama.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Example02 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Suplaier
        String result = CompletableFuture.supplyAsync(()-> Thread.currentThread().getName()).get();
        System.out.println(result);
        //Runnable
        CompletableFuture.runAsync(()-> System.out.println("Executando Thread " + Thread.currentThread().getName())).get();
    }
}
