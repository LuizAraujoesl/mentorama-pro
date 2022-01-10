package com.mentorama.forkjoinpool;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Exemple01 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool commonPool = new ForkJoinPool();
        // Quantos processadores serao utilizados(Cores)
        System.out.println("Numero de Cores considerados: " + commonPool.getParallelism());

        CompletableFuture.allOf(
                execute(commonPool, 1),
                execute(commonPool, 2),
                execute(commonPool, 3)
                ).get();
    }

    private static CompletableFuture<Void> execute(ForkJoinPool commonPool, int executionNumber) {
        return CompletableFuture.runAsync(()->{
            double sum = 0.0;
            for (int i = 0; i < 50; i++) {
                wait1Second();
                System.out.println("Execution: " + executionNumber + "in Thread " + Thread.currentThread().getName());
                sum+= i * ((i * 1) / Integer.MAX_VALUE);
            }
            System.out.println("Result is " + sum);
        }, commonPool);
    }

    private static void wait1Second(){
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
