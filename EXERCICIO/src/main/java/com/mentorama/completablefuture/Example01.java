package com.mentorama.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class Example01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        Executors.newCachedThreadPool().submit(()-> completableFuture.complete("Executei"));

        // bloqueia Thread para ter resultado
        String result= completableFuture.get();
        System.out.println(result);
    }
}
