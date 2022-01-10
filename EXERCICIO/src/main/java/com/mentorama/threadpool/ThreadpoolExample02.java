package com.mentorama.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadpoolExample02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        for (int i = 0; i < 10; i++) {
            Future<String> future =
                    executorService.submit(()-> "A Thread " + Thread.currentThread().getName() + " me executou");
            String result = future.get();
            System.out.println(result);
        }
    }
}
