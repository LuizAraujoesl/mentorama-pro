package com.mentorama.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Example04 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> " Hello")
                        .thenCompose(s-> CompletableFuture.supplyAsync(()-> s + " World One"));
        System.out.println(completableFuture.get());

        CompletableFuture<String> completableFuture2 = CompletableFuture.supplyAsync(() -> " Hello")
                .thenCombine(CompletableFuture.supplyAsync(()-> " World Two"), (s1, s2) -> s1 + s2);
        System.out.println(completableFuture2.get());
    }
}
