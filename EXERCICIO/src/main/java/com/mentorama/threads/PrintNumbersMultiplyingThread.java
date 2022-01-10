package com.mentorama.threads;

import java.util.List;

public class PrintNumbersMultiplyingThread extends Thread{
    final List<Long> numbers;


    public PrintNumbersMultiplyingThread(List<Long> numbers) {
        this.numbers = numbers;
        setName("PrintNumbersThread");
    }

    @Override
    public void run(){
        numbers.forEach(number ->{
            try{
                sleep(number * 100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(getName() + " - Number: " + number * 100);
        });

    }
}
