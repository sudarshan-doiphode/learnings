package com.learn.learnings.multithreading.sync;

public class ResolvingProblemWithSingleLockInSync {

    public static int COUNTER1 = 0;
    public static int COUNTER2 = 0;

    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void increment1(){
        synchronized (lock1){
            for (int i = 0; i < 100; i++) {
                COUNTER1++;
            }
        }
    }

    public static void increment2(){
        synchronized (lock2){
            for (int i = 0; i < 100; i++) {
                COUNTER2++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment1();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                increment2();
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        System.out.println(COUNTER1);
        System.out.println(COUNTER2);
    }
}
