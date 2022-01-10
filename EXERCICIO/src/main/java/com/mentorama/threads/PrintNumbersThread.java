package com.mentorama.threads;

import java.util.List;

public class PrintNumbersThread extends Thread{
    final List<Long> numbers;


    public PrintNumbersThread(List<Long> numbers) {
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
            System.out.println(getName() + " - Number: " + number);
        });

    }
}
