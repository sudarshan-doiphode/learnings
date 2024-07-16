package com.learn.learnings.multithreading.basics;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("Hello");
                }
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 3; i++) {
                    System.out.println("World");
                }
            }
        });

        thread.start();
        thread1.start();

        thread.join();
        thread1.join();

        System.out.println("Execution Completed!!");
    }
}
