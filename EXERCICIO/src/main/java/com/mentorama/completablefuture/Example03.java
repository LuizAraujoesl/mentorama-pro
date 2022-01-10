package com.mentorama.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example03 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> 10)
                //Apply
                .thenApply(number -> number * 10)
                //Accept
                .thenAccept(number -> System.out.println("O numero e " + number))
                //Run
                .thenRun(()-> System.out.println("Acabou processamento"));
        completableFuture.get();



    }
}
