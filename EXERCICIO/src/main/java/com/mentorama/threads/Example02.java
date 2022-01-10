package com.mentorama.threads;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Example02 {



    public static void main(String[] args) {

        /*Executando 2 Threads parelamente
         * neste exemplo temos uma lista de numeros e teremos 2 Threads interando elas*/
        final List<Long> numbers1 =  getNumbers(1,10);
        final List<Long> numbers2 =  getNumbers(11,21);

        //Thread 01
        createThread("Thread 01", ()->{
            numbers1.forEach(number-> {
                threadSleep(number * 10000);
                System.out.println(Thread.currentThread().getName() + " - Number: " + number);
            });
        });

        //Thread 02
        createThread("Thread 02", ()->{
            numbers2.forEach(number-> {
                threadSleep(number * 10000);
                System.out.println(Thread.currentThread().getName() + " - Number: " + number);
            });
        });

    }




    private static List<Long> getNumbers(int one, int two){
           return LongStream.rangeClosed(one, two).boxed().collect(Collectors.toList());
       }


        private static void threadSleep(long milliseconds){
            try{
                Thread.sleep(milliseconds);
            }catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        private static void createThread( String threadName, Runnable runnable){
           final Thread thread = new Thread(runnable);
           thread.setName(threadName);
           thread.start();
        }
}
