package com.learn.learnings.multithreading.sync;

public class WithoutSynchronized {
    public static int COUNTER = 0;

    public static void increment(){
        COUNTER++;
    }

    public static void decrement(){
        COUNTER--;
    }


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    increment();
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    decrement();
                }
            }
        });

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println(COUNTER);
    }
}
