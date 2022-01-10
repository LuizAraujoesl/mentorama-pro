package com.mentorama.threads;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Example03 {


    public static void main(String[] args) throws InterruptedException {

        /*Executando 2 Threads parelamente
         * neste exemplo temos uma lista de numeros e teremos 2 Threads interando elas*/
        final List<Long> numbers1 =  getNumbers(1,10);
        final List<Long> numbers2 =  getNumbers(11,21);

        final PrintNumbersThread printNumbersThread = new PrintNumbersThread(numbers1);
        printNumbersThread.start();
        printNumbersThread.join();

        new PrintNumbersMultiplyingThread(numbers2).start();

    }

    private static List<Long> getNumbers(int one, int two){
        return LongStream.rangeClosed(one, two).boxed().collect(Collectors.toList());
    }

}
